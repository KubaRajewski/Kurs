package dalsze.podstawy.interfejsy.wstep;

public class Samochod implements ISamochod {
    private String marka;
    private String model;
    private int moc;

    public Samochod(String marka, String model, int moc) {
        this.marka = marka;
        this.model = model;
        this.moc = moc;
    }

    public void zwiekszMoc(int n){
        moc += obliczMocDoDodania(n);
    }

    @Override
    public void hamuj() {
        System.out.println("hamujesz");
    }

    @Override
    public void przyspiesz() {
        System.out.println("przyspieszasz");
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getMoc() {
        return moc;
    }
}
