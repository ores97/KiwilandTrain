package TrainSystem;

import java.util.*;

public class KiwiLandTrain {
	ArrayList<KiwiLandRoute> routes;  //we create an ArrayList for all the routes that we get from the args of the main
	ArrayList<String> origins; //useful information that we might need if the origins are more than the test input put
	ArrayList<String> destinations; //the same as above but with the destinations
	ArrayList <String[]> routesToCalculate;
	ArrayList <String> distancesCalculated;
	public static void main(String [] args)
	{

		KiwiLandTrain kiwiLandSystem = new KiwiLandTrain(new ArrayList<KiwiLandRoute>(),new ArrayList<String>(),new ArrayList<String>(),new ArrayList <String[]>(),new ArrayList <String>());
		//We add the routes given by the args
		kiwiLandSystem.addRoutesGiven(args);
		//We get all the possible origins and all the possible destinations
		kiwiLandSystem.addPossibleOrigins(args);
		kiwiLandSystem.addPossibleDestinations(args);
		//We add the routes that we need to calculate the distance
		kiwiLandSystem.addRoutesToCalculate();
		//Now we calculate the outputs of the distances
		kiwiLandSystem.calculateDistances();
		//Finally, we print our results 
		kiwiLandSystem.printResults();
		
	}
	
	private void printResults() {
		int i= 0;
		for(String distance:distancesCalculated) {
			i++;
			System.out.println("Output #"+i+": "+distance);
		}
		
	}

	//method to add the routes to calculate in the system
	private void addRoutesToCalculate() {
		//Routes to calculate predefined, can be more or less
		try{
			String[] s1 = {"A","B","C"};
			String[] s2 = {"A","D"};
			String[] s3 = {"A","D","C"};
			String[] s4 = {"A","E","B","C","D"};
			String[] s5 = {"A","E","D"};
			routesToCalculate.add(s1);
			routesToCalculate.add(s2);
			routesToCalculate.add(s3);
			routesToCalculate.add(s4);
			routesToCalculate.add(s5);
		}catch(Exception e) {
			System.err.println("Error within the addition of the routes to calculate");
		}
		
	}
	
	//method to add the arguments of the main to the routes of the system
	public void addRoutesGiven(String[] args) {
		for(String argRoutes: args) {
			try {
				argRoutes = argRoutes.replaceAll(",",""); //we delete all the commas from the input args
				KiwiLandRoute actualRoute = new KiwiLandRoute(argRoutes.substring(0, 1),argRoutes.substring(1, 2),Integer.parseInt(argRoutes.substring(2, 3))); //we create an object of type Kiwiland for putting it in the list created before
				routes.add(actualRoute); //we add the route to the list of routes	
			}catch(Exception e) {
				System.err.println("Error within the addition of the routes to the list");
			}
		}
	}
	
	//method to retrieve all the possible origins stations where the train can leave 
	public void addPossibleOrigins(String[] args) {
		for(String argOrigins: args) {
			try {
				argOrigins = argOrigins.substring(0, 1);
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
				argDestinations = argDestinations.substring(1, 2);
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
			for(String[] stations: routesToCalculate) {
				int distanceActual = 0;
				for(int i=0;i<stations.length - 1;i++) {
					distanceActual = distanceActual + calculateDistance(stations[i],stations[i+1]);
				}
				if (distanceActual<0) { //Puting a threshold verylow helps getting the exception of No such route
					distancesCalculated.add("NO SUCH ROUTE");
					
				}else {
					distancesCalculated.add(String.valueOf(distanceActual));
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
			return distance;
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
		this.routesToCalculate = new ArrayList <String[]>();
		this.distancesCalculated = new ArrayList <String>();
	}
	
	public KiwiLandTrain(ArrayList<KiwiLandRoute> routes, ArrayList<String> origins, ArrayList<String> destinations,
			ArrayList<String[]> routesToCalculate, ArrayList<String> distancesCalculated) {
		super();
		this.routes = routes;
		this.origins = origins;
		this.destinations = destinations;
		this.routesToCalculate = routesToCalculate;
		this.distancesCalculated = distancesCalculated;
	}

	//Constructors with fields
	
	
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
	
	
}
