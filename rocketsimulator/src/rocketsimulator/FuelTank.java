package rocketsimulator;

/**
 *
 * @author Samu Tikkanen and Leo Tamminen
 */
public class FuelTank extends Part{
    private double amount;
    private final double fuelDensity = 0.8; // kg / dm3, density of Kerosene, can be made configurable
    private final double ownWeight;
    
    public FuelTank(double capacity) {
        this.amount = capacity;
        this.ownWeight = this.amount*0.02;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public double getWeight() {
        return ownWeight + amount * fuelDensity;
    }

    public double useFuel(double usage) {
        if (amount < usage) {
            double percent = amount/usage;
            amount = 0;
            return percent;
        } else {
            amount -= usage;
            return 1;
        }
    }
}
