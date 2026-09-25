package semifinal;

/**
 * Ride - an ABSTRACT class. You can never write new Ride(...).
 * It holds what EVERY ride shares: an id, a passenger and a distance.
 */
public abstract class Ride {

    // GIVEN: fields and constructor
    private static int nextId = 1;
    private final int id;
    private final String passenger;
    private final double km;

    public Ride(String passenger, double km) {
        this.id = nextId++;
        this.passenger = passenger;
        this.km = km;
    }

    // GIVEN: getters
    public int getId() {
        return id;
    }

    public String getPassenger() {
        return passenger;
    }

    public double getKm() {
        return km;
    }

    // TODO 2
    public abstract double fare();

    public abstract String vehicle();

    // GIVEN: a finished method every child inherits.
    // It calls vehicle() and fare() - Java runs the CHILD's version.
    public void printTicket() {
        System.out.println("--------------------------------");
        System.out.println(" Ticket #" + id + " | " + vehicle());
        System.out.println(" Passenger : " + passenger);
        System.out.printf(" Distance : %.1f km%n", km);
        System.out.printf(" Fare : PHP %.2f%n", fare());
    }

    // TODO 3
    public void printTicket(String note) {
        printTicket();
        System.out.println(" Note : " + note);
    }
}
