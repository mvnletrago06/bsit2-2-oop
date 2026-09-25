package semifinal;

/**
 * Jeepney - FULLY WRITTEN FOR YOU. Use it as your model for
 * Tricycle.java and Taxi.java. Read every line.
 *
 * Fare: PHP 13.00 for the first 4 km, then PHP 1.80 per extra km.
 * Students get 20% off.
 */
public class Jeepney extends Ride implements StudentDiscount {

    public Jeepney(String passenger, double km) {
        super(passenger, km);
    }

    @Override
    public double fare() {
        if (getKm() <= 4) {
            return 13.00;
        }
        return 13.00 + (getKm() - 4) * 1.80;
    }

    @Override
    public String vehicle() {
        return "Jeepney";
    }

    @Override
    public double discountedFare() {
        return fare() * 0.80;
    }
}

