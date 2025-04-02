package core;

public class Passenger {
    private String name;
    private int age;
    private String dob;
    private String flightNumber;
    private String destination;

    public Passenger(String name, int age, String dob, String flightNumber, String destination) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.flightNumber = flightNumber;
        this.destination = destination;
    }

    public String getName() {
    	return name; 
    	}
    public String getFlightNumber() { 
    	return flightNumber; 
    	}
    public String getDestination() {
    	return destination; 
    	}

    public void displayPassengerInfo() {
        System.out.println("Passenger: " + name + " | Age: " + age + " | DOB: " + dob);
        System.out.println("Flight: " + flightNumber + " | Destination: " + destination);
    }
}