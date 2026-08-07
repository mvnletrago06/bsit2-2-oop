public class Vehicle {
    protected String brand;
    protected int year;

    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    public void displayInfo() {
        // getClass().getSimpleName() dynamically gets "Vehicle" or the subclass name
        System.out.println(getClass().getSimpleName() + ": " + brand + " (" + year + ")");
    }
}