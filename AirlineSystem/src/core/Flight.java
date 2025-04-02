package core;

public class Flight extends Transport implements Reservable {
    public Flight(String flightNumber, String destination, int capacity, double ticketPrice) {
        super(flightNumber, destination, capacity, ticketPrice);
    }

    
    public void displayFlightInfo() {
        super.displayInfo();
    }


	public void displayPassengerList() {
		 System.out.println("Passengers for Flight " + getTransportNumber() + ":");
	        for (Passenger passenger : getPassengers()) {
	            passenger.displayPassengerInfo();
	        }
		
	}
}