package TrainSystem;


//Simple class to save all the route's information
public class KiwiLandRoute {
	private String origin;
	private String destination;
	private int distance;
	
	public KiwiLandRoute(String origin, String destination, int distance) {
		super();
		this.origin = origin;
		this.destination = destination;
		this.distance = distance;
	}
	public KiwiLandRoute() {
		super();
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	

}
