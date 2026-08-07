public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String brand, int year, int numberOfDoors) {
        super(brand, year);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        System.out.println(getClass().getSimpleName() + ": " + brand + " (" + year + ") - " + numberOfDoors + " doors");
    }
}