package core;

import java.util.ArrayList;


public class FlightManager {
    private ArrayList<Flight> flights;

    public FlightManager() {
        flights = new ArrayList<>();
        flights.add(new Flight("A101", "New York", 100, 250.00));
        flights.add(new Flight("B202", "Los Angeles", 150, 300.00));
        flights.add(new Flight("C303", "Chicago", 120, 200.00));
        flights.add(new Flight("D404", "Houston", 130, 220.00));
        flights.add(new Flight("E505", "San Francisco", 110, 280.00));
        flights.add(new Flight("F606", "Miami", 140, 260.00));
        flights.add(new Flight("G707", "Dallas", 125, 210.00));
        flights.add(new Flight("H808", "Atlanta", 135, 230.00));
        flights.add(new Flight("I909", "Seattle", 115, 270.00));
        flights.add(new Flight("J010", "Boston", 105, 240.00));
    }
    public void displayFlights() {
        for (Flight flight : flights) {
            flight.displayFlightInfo();
        }
    }
    public Flight findFlight(String flightNumber) {
        for (Flight flight : flights) {
            if (flight.getTransportNumber().equalsIgnoreCase(flightNumber)) {
                return flight;
            }
        }
        return null;
    }
    public ArrayList<Flight> getFlights() {
        return flights;
    }
}