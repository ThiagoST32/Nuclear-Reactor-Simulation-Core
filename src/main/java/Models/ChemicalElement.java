package Models;



public enum ChemicalElement {
    URANIUM_235("U", 92, 238.02891, 1132.2, 3900),
    KRYPTON_92("K",32, 83.798,  -157.36, -153.22),
    BARIUM_141("Ba", 56, 141, 27727.0, 1870.0),
    PLUTONIUM_239("Pu", 94, 244, 639.4, 3230.0);

    private final String symbol;
    private final int atomicNumber;
    private final double massAtomic;
    private final double meltingPoint;
    private final double boilingPoint;


    ChemicalElement(String symbol, int atomicNumber, double massAtomic, double meltingPoint, double boilingPoint) {
        this.symbol = symbol;
        this.atomicNumber = atomicNumber;
        this.massAtomic = massAtomic;
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public double getMassAtomic() {
        return massAtomic;
    }

    public double getMeltingPoint() {
        return meltingPoint;
    }

    public double getBoilingPoint() {
        return boilingPoint;
    }
}
