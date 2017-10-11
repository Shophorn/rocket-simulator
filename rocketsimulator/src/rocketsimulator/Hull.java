package rocketsimulator;

public class Hull extends Part
{
    private final double weight;

    public Hull() {
        weight = 50_000;
    } 
    
    @Override
    public double getWeight() {
        return weight;
    }
}
