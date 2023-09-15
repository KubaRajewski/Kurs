package dalsze.podstawy.enumy.dyplom;

public enum OcenaEnum {
    NIEDOSTATECZNY(2.0),
    DOPUSZCZAJACY(3.0),
    DOSTATECZNY(3.5),
    DOBRY(4.0),
    BARDZO_DOBRY(4.5),
    CELUJACY(5.0);

    private double wartosc;

    OcenaEnum(double wartosc) {
        this.wartosc = wartosc;
    }

    public double getWartosc() {
        return wartosc;
    }
}