package core;

import java.util.ArrayList;

public class Transport {
    private String transportNumber;
    private String destination;
    private int capacity;
    private int bookedSeats;
    private double ticketPrice;
    private ArrayList<Passenger> passengers = new ArrayList<>();

    public Transport(String transportNumber, String destination, int capacity, double ticketPrice) {
        this.transportNumber = transportNumber;
        this.destination = destination;
        this.capacity = capacity;
        this.ticketPrice = ticketPrice;
        this.bookedSeats = 0;
    }

    public String getTransportNumber() {
    	return transportNumber; 
    	}
    public String getDestination() {
    	return destination; 
    	}
    public int getAvailableSeats() { 
    	return capacity - bookedSeats; 
    	}
    public double getTicketPrice() { 
    	return ticketPrice;
    	}

    public void bookSeat(String name, int age, String dob, String destination) {
        if (bookedSeats < capacity) {
            bookedSeats++;
            passengers.add(new Passenger(name, age, dob, transportNumber, destination));
            System.out.println("Booking successful! Ticket Price: $" + ticketPrice);
        } 
        else {
            System.out.println("No available seats.");
        }
    }

    public void cancelSeat(String name) {
        for (Passenger p : passengers) {
            if (p.getName().equalsIgnoreCase(name)) {
                passengers.remove(p);
                bookedSeats--;
                System.out.println("Booking canceled for " + name + ".");
                return;
            }
        }
        System.out.println("Passenger not found.");
    }
    public ArrayList<Passenger> getPassengers() {  // Getter for passenger list
        return passengers;
    }
    
    public void displayInfo() {
        System.out.println("\nFlight: " + transportNumber + " | Destination: " + destination);
        System.out.println("Seats: " + bookedSeats + "/" + capacity + " | Price: $" + ticketPrice);
    }
}