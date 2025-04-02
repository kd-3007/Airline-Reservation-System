package core;

interface Reservable {
    void bookSeat(String name, int age, String dob, String destination);
    void cancelSeat(String name);
    void displayFlightInfo();
}