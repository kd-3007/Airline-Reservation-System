package core;

import java.util.*;

//Main Airline Reservation System
public class AirlineReservationSystem {
 private static FlightManager flightManager = new FlightManager();
 private static Scanner scanner = new Scanner(System.in);

 public static void main(String[] args) {
     System.out.println("Welcome to Airline Reservation System!");
     while (true) {
    	 
         System.out.println("\n1. View Flights");
         System.out.println("2. Search Flight by Destination");
         System.out.println("3. book flight");
         System.out.println("4. cancelFlight");
         System.out.println("5. Display Bookings");
         System.out.println("6. Exit");
         System.out.print("Choose an option: ");

         if (!scanner.hasNextInt()) {
             System.out.println("Invalid input! Please enter a number.");
             scanner.next(); 
             continue;
         }
         
         int choice = scanner.nextInt();
         scanner.nextLine();

         switch (choice) {
             case 1:
                 flightManager.displayFlights();
                 break;
             case 2:
                 searchFlight();
                 break;
             case 3:
                 bookFlight();
                 break;
             case 4:
                 cancelBooking();
                 break;
             case 5:
                 displayBookings();
                 break;
             case 6:
                 System.out.println("Exiting... Thank you for using our service!");
                 return;
             default:
                 System.out.println("Invalid choice! Please select a valid option.");
         }
     }
 }

 private static void bookFlight() {
     System.out.print("Enter flight number: ");
     String flightNumber = scanner.nextLine();
     Flight flight = flightManager.findFlight(flightNumber);

     if (flight != null) {
         System.out.print("Enter your name: ");
         String name = scanner.nextLine();
         
         int age;
         while (true) {
             System.out.print("Enter your age: ");
             if (scanner.hasNextInt()) {
                 age = scanner.nextInt();
                 scanner.nextLine(); // Consume newline
                 break;
             }
             else {
                 System.out.println("Invalid input! Please enter a valid age.");
                 scanner.next(); // Clear invalid input
             }
         }

         System.out.print("Enter your Date of Birth (YYYY-MM-DD): ");
         String dob = scanner.nextLine();
         System.out.print("Enter destination: ");
         String destination = scanner.nextLine();
         
         flight.bookSeat(name, age, dob, destination);
     }
     else {
         System.out.println("Flight not found! Please check the flight number.");
     }
 }

 private static void cancelBooking() {
     System.out.print("Enter flight number: ");
     String flightNumber = scanner.nextLine();
     Flight flight = flightManager.findFlight(flightNumber);

     if (flight != null) {
         System.out.print("Enter your name: ");
         String name = scanner.nextLine();
         flight.cancelSeat(name);
     } 
     else {
         System.out.println("Flight not found! Please enter a valid flight number.");
     }
 }
 private static void displayBookings() {
     System.out.print("Enter flight number to view bookings: ");
     String flightNumber = scanner.nextLine();
     Flight flight = flightManager.findFlight(flightNumber);

     if (flight != null) {
         flight.displayPassengerList();
     } else {
         System.out.println("Flight not found! Please enter a valid flight number.");
     }
 }
 private static void searchFlight() {
     System.out.print("Enter destination: ");
     String destination = scanner.nextLine();
     boolean found = false;

     for (Flight flight : flightManager.getFlights()) {
         if (flight.getDestination().equalsIgnoreCase(destination)) {
             flight.displayFlightInfo();
             found = true;
         }
     }

     if (!found) {
         System.out.println("No flights available to this destination.");
     }
 }
}