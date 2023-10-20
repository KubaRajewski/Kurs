package dalsze.podstawy.interfejsy.biznesowa;

class Grunt implements Dzialka {
    private double powierzchnia;

    public Grunt(double powierzchnia) {
        this.powierzchnia = powierzchnia;
    }

    @Override
    public double obliczPodatek() {
        return Nieruchomosc.getPodatekStaly() + 10.0 * powierzchnia;  // 10 zł za każdy metr kwadratowy
    }

    @Override
    public void wyswietlPowierzchnie() {
        System.out.println("Powierzchnia działki: " + powierzchnia + " m^2");
    }
}

