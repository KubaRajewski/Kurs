package dalsze.podstawy.interfejsy.biznesowa;

class Dom implements Budynek {
    private double wartosc;
    private int liczbaPieter;

    public Dom(double wartosc, int liczbaPieter) {
        this.wartosc = wartosc;
        this.liczbaPieter = liczbaPieter;
    }

    @Override
    public double obliczPodatek() {
        return Nieruchomosc.getPodatekStaly() + 0.05 * wartosc;  // 5% wartości nieruchomości
    }

    @Override
    public void wyswietlLiczbePieter() {
        System.out.println("Liczba pięter w domu: " + liczbaPieter);
    }
}
