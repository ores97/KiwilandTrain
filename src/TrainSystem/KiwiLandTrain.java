package TrainSystem;

import java.util.*;

public class KiwiLandTrain {
	ArrayList<KiwiLandRoute> routes;  //we create an ArrayList for all the routes that we get from the args of the main
	ArrayList<String> origins; //useful information that we might need if the origins are more than the test input put
	ArrayList<String> destinations; //the same as above but with the destinations

	public static void main(String [] args)
	{

		KiwiLandTrain kiwiLandSystem = new KiwiLandTrain(new ArrayList<KiwiLandRoute>(),new ArrayList<String>(),new ArrayList<String>());
		kiwiLandSystem.addRoutes(args);
		kiwiLandSystem.addPossibleOrigins(args);
		kiwiLandSystem.addPossibleDestinations(args);
		
		
	}
	//method to add the arguments of the main to the routes of the system
	public void addRoutes(String[] args) {
		for(String argRoutes: args) {
			argRoutes = argRoutes.replaceAll(",",""); //we delete all the commas from the input args
			KiwiLandRoute actualRoute = new KiwiLandRoute(argRoutes.substring(0, 1),argRoutes.substring(1, 2),Integer.parseInt(argRoutes.substring(2, 3))); //we create an object of type Kiwiland for putting it in the list created before
			routes.add(actualRoute); //we add the route to the list of routes	
		}
	}
	
	//method to retrieve all the possible origins stations where the train can leave 
	public void addPossibleOrigins(String[] args) {
		for(String argOrigins: args) {
			argOrigins = argOrigins.substring(0, 1);
			if(!origins.contains(argOrigins)) {
				origins.add(argOrigins);
			}			
		}		
	}
	
	//method to retrieve all the possible destinations where the train can go
	public void addPossibleDestinations(String[] args) {
		for(String argDestinations: args) {
			argDestinations = argDestinations.substring(1, 2);
			if(!destinations.contains(argDestinations)) {
				destinations.add(argDestinations);
			}			
		}	
	}
	//Constructors without fields
	public KiwiLandTrain() {
		super();
	}
	
	//Constructors with fields
	public KiwiLandTrain(ArrayList<KiwiLandRoute> routes, ArrayList<String> origins, ArrayList<String> destinations) {
		super();
		this.routes = routes;
		this.origins = origins;
		this.destinations = destinations;
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
	
	
}
