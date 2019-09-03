package TrainSystem;

import java.util.*;

public class KiwiLandTrain {
	ArrayList<KiwiLandRoute> routes;  //we create an ArrayList for all the routes that we get from the args of the main
	ArrayList<String> origins; //useful information that we might need if the origins are more than the test input put
	ArrayList<String> destinations; //the same as above but with the destinations
	ArrayList <ArrayList<String>> routesToCalculate; //to input the routes to calculate
	ArrayList <String> distancesCalculated; //to get the values of the distances calculated
	String outputResult; //the result of all the calculations in a structure
	
	public static void main(String [] args)
	{
		//We create the object of the system
		KiwiLandTrain kiwiLandSystem = new KiwiLandTrain(new ArrayList<KiwiLandRoute>(),new ArrayList<String>(),new ArrayList<String>(),new ArrayList <ArrayList<String>>(),new ArrayList <String>(),"");
		//We add the routes given by the args
		kiwiLandSystem.addRoutesGiven(args);
		if(kiwiLandSystem.getRoutes().size()>0) {
			//We get all the possible origins and all the possible destinations
			kiwiLandSystem.addPossibleOrigins(args); //
			kiwiLandSystem.addPossibleDestinations(args);
			//We add the routes that we need to calculate the distance
			kiwiLandSystem.addRoutesToCalculate();
			if(kiwiLandSystem.getRoutesToCalculate().size()>0) {
				//Now we calculate the outputs of the distances
				kiwiLandSystem.calculateDistances();
				//Finally, we print our results 
				kiwiLandSystem.printResults();
			}
		}	
	}
	//method to print the results as the document asked
	public void printResults() {
		int i= 0;
		outputResult = "Graph: "; //we put the structure of the document for the given routes
		
		for(KiwiLandRoute r : routes) {
			outputResult = outputResult + r.toString();
			i++;
			if(i != routes.size()) {
				outputResult = outputResult + ", ";
			}
			else {
				outputResult = outputResult + "\n";
			}
		}
		i= 0;
		outputResult = outputResult + "Expected Output:\n"; //and then we do the same for the distances calculated
		for(String distance:distancesCalculated) {
			i++;
			outputResult = outputResult + "Output #"+i+": "+distance+"\n";
		}
		System.out.print(outputResult);
	}

	//method to add the routes to calculate in the system
	private void addRoutesToCalculate() {
		//Routes to calculate are asked to the user
		try{
			String routescanned = "";
			while (!routescanned.equals("-1")) {
				System.out.println("Enter a route to be calculated: (for example ABC)");
				System.out.println("If you want to finish adding routes, enter -1"); //this is to stop asking
				Scanner scanner = new Scanner(System.in);
				routescanned = scanner.nextLine().toUpperCase(); //the basic system for asking the user, we put the upper case
				System.out.println("Your route is " + routescanned);
				if(!routescanned.equals("-1")) { //If the user puts a -1, the program stops asking
					ArrayList<String> s1 = new ArrayList<String>();
					for(int i = 0;i<routescanned.length();i++) {
						s1.add(routescanned.substring(i,i+1));
					}
					routesToCalculate.add(s1); //finally, we add the route to the system
				}
			}
		}catch(Exception e) {
			System.err.println("Error within the addition of the routes to calculate");
		}
		
	}
	
	//method to add the arguments of the main to the routes of the system
	public void addRoutesGiven(String[] args) {
		for(String argRoutes: args) {
			try {
				argRoutes = argRoutes.replaceAll(",",""); //we delete all the commas from the input args
				if(argRoutes.length()>3) {
					throw new IllegalArgumentException();
				}
				int distance = Integer.parseInt(argRoutes.substring(2, 3)); //here we check if the distance is well, if not it will throw the catch exception and pass this one
				String origen = argRoutes.substring(0, 1).toUpperCase();
				String destination = argRoutes.substring(1, 2).toUpperCase();
				KiwiLandRoute actualRoute = new KiwiLandRoute(origen,destination,distance); //we create an object of type Kiwiland for putting it in the list created before
				routes.add(actualRoute); //we add the route to the list of routes	
			}catch(NumberFormatException e) { //when the integer for example cant be casted from the string arg
				System.err.println("Error with one of the arguments passed in the main: "+argRoutes);
			}
			catch(IllegalArgumentException  s) { //when the argument is too big
				System.err.println("The next argument is longer than the expected: "+argRoutes);
			}
		}
	}
	
	//method to retrieve all the possible origins stations where the train can leave 
	public void addPossibleOrigins(String[] args) {
		for(String argOrigins: args) {
			try {
				argOrigins = argOrigins.substring(0, 1); //we get only the origin from the substring
				if(!origins.contains(argOrigins)) {
					origins.add(argOrigins);
				}
			}catch(Exception e) {
				System.err.println("Error within the origins listing");
			}
		}		
	}
	
	//method to retrieve all the possible destinations where the train can go
	public void addPossibleDestinations(String[] args) {
		for(String argDestinations: args) {
			try {
				argDestinations = argDestinations.substring(1, 2); //we get only the origin from the substring
				if(!destinations.contains(argDestinations)) {
					destinations.add(argDestinations);
				}
			}catch(Exception e) {
				System.err.println("Error within the destinations listing");
			}
		}	
	}
	
	//method to calculate all the distances needed for getting the output
	public void calculateDistances() {
		try {
			for(ArrayList<String> stations: routesToCalculate) {
				try {
					int distanceActual = 0;
					for(int i=0;i<stations.size() - 1;i++) {
						distanceActual = distanceActual + calculateDistance(stations.get(i),stations.get(i+1)); //we calculate the distance of all edges between stations using the other function
						if (distanceActual < 0) {//Puting a threshold very low helps getting the exception of No such route
							distancesCalculated.add("NO SUCH ROUTE");
							break; //we save time putting this here and breaking the internal loop
						}
					}
					if (distanceActual>=0) { //if everything works, then we put the distance correctly
						distancesCalculated.add(String.valueOf(distanceActual));
					}	
				}catch(Exception e) {
					System.err.println("Error within the calculation of one route");
					distancesCalculated.add("ERROR IN CALCULATING DISTANCES");
				}
				
			}
		}catch(Exception e) {
			System.err.println("Error within the calculation of the distances in total");
		}
	}
	
	//method to calculate the distance from point X to point Y
	public int calculateDistance(String origin,String destination){
		try {
			int distance = -10000; //we put this value to know if a destination cant be arrived
			for(KiwiLandRoute r: routes) {
				if(r.getOrigin().equals(origin)&&r.getDestination().equals(destination)) {
					distance = r.getDistance();
				}
			}
			return distance; //If we don't get any possible route, then the distance we return has a value of -10000 and the system knows its a NO ROUTE 
		}catch(Exception e) {
			System.err.println("Error within the calculation of the distance between two stations");
			return -10000;
		}
		
	}
	
	//Constructors without fields
	public KiwiLandTrain() {
		super();
		this.routes = new ArrayList<KiwiLandRoute>();
		this.origins = new ArrayList<String>();
		this.destinations = new ArrayList<String>();
		this.routesToCalculate = new ArrayList <ArrayList<String>>();
		this.distancesCalculated = new ArrayList <String>();
		this.outputResult = "";
	}
	//Constructors with fields
	public KiwiLandTrain(ArrayList<KiwiLandRoute> routes, ArrayList<String> origins, ArrayList<String> destinations,
			ArrayList<ArrayList<String>> routesToCalculate, ArrayList<String> distancesCalculated, String output) {
		super();
		this.routes = routes;
		this.origins = origins;
		this.destinations = destinations;
		this.routesToCalculate = routesToCalculate;
		this.distancesCalculated = distancesCalculated;
		this.outputResult = output;
	}

	//Getters and Setters part
	public ArrayList<KiwiLandRoute> getRoutes() {
		return routes;
	}

	public void setRoutes(ArrayList<KiwiLandRoute> routes) {
		this.routes = routes;
	}

	public ArrayList<String> getOrigins() {
		return origins;
	}

	public void setOrigins(ArrayList<String> origins) {
		this.origins = origins;
	}

	public ArrayList<String> getDestinations() {
		return destinations;
	}

	public void setDestinations(ArrayList<String> destinations) {
		this.destinations = destinations;
	}

	public ArrayList<ArrayList<String>> getRoutesToCalculate() {
		return routesToCalculate;
	}

	public void setRoutesToCalculate(ArrayList<ArrayList<String>> routesToCalculate) {
		this.routesToCalculate = routesToCalculate;
	}

	public ArrayList<String> getDistancesCalculated() {
		return distancesCalculated;
	}

	public void setDistancesCalculated(ArrayList<String> distancesCalculated) {
		this.distancesCalculated = distancesCalculated;
	}
	public String getOutputResult() {
		return outputResult;
	}
	public void setOutputResult(String outputResult) {
		this.outputResult = outputResult;
	}
	
	
}
