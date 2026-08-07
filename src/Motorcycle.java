public class Motorcycle extends Vehicle {
    private boolean hasSidecar;

    public Motorcycle(String brand, int year, boolean hasSidecar) {
        super(brand, year);
        this.hasSidecar = hasSidecar;
    }

    @Override
    public void displayInfo() {
        String sidecarText = hasSidecar ? "with sidecar" : "no sidecar";
        System.out.println(getClass().getSimpleName() + ": " + brand + " (" + year + ") - " + sidecarText);
    }
}