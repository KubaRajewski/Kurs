package dalsze.podstawy.interfejsy.zbiornik;

import java.util.ArrayList;
import java.util.List;

public class Zbiornik implements IZbiornik {
    private String nazwa;
    private double pojemnosc;
    private double stan;

    public static List<Operacja> operacje = new ArrayList<>();

    public Zbiornik(String nazwa, double pojemnosc, double stan) {
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.stan = stan;
    }

    @Override
    public void dolej(double ilosc) {
        try {
            if (pojemnosc < ilosc || stan + ilosc > pojemnosc) {
                throw new IllegalArgumentException("Nie można dolać więcej niż pojemność zbiornika");
            } else if (ilosc <= 0) {
                throw new IllegalArgumentException("podaj inna wartosc");
            }

            stan += ilosc;
            operacje.add(new Operacja(nazwaOperacji(), this, ilosc, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            operacje.add(new Operacja(nazwaOperacji(), this, ilosc, false));
        }
    }

    @Override
    public void odlej(double ilosc) {

    }

    @Override
    public void przelej(double ilosc, Zbiornik zbiornik) {

    }

    public String nazwaOperacji() {
        return "Zbiornik: " + nazwa + " Operacja nr: " + (operacje.size() + 1);
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getPojemnosc() {
        return pojemnosc;
    }

    public void setPojemnosc(double pojemnosc) {
        this.pojemnosc = pojemnosc;
    }

    public double getStan() {
        return stan;
    }

    public void setStan(double stan) {
        this.stan = stan;
    }

    @Override
    public String toString() {
        return "Zbiornik{" +
                "nazwa='" + nazwa + '\'' +
                ", pojemnosc=" + pojemnosc +
                ", stan=" + stan +
                '}';
    }
}
