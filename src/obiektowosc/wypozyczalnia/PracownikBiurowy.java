package obiektowosc.wypozyczalnia;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PracownikBiurowy extends Pracownik {
    private static List<PracownikBiurowy> ekstensja = new ArrayList<>();
    private String stanowisko;
    private Optional<Double> premiaOdWypozyczen;

    public PracownikBiurowy(String imie, String nazwisko, String adres, String numerDowodu, int pensja, String rodzajUmowy, String stanowisko) {
        super(imie, nazwisko, adres, numerDowodu, pensja, rodzajUmowy);
        this.stanowisko = stanowisko;
        this.premiaOdWypozyczen = Optional.empty();

        if (stanowisko.equalsIgnoreCase("Sprzedawca")) {
            throw new IllegalArgumentException("Sprzedawca musi miec premie");
        }

        ekstensja.add(this);
    }

    public PracownikBiurowy(String imie, String nazwisko, String adres, String numerDowodu, int pensja, String rodzajUmowy, String stanowisko, double premiaOdWypozyczen) {
        super(imie, nazwisko, adres, numerDowodu, pensja, rodzajUmowy);
        if (!stanowisko.equalsIgnoreCase("Sprzedawca")) {
            throw new IllegalArgumentException("Premie moze miec tylko sprzedawca");
        }

        this.stanowisko = stanowisko;
        this.premiaOdWypozyczen = Optional.of(premiaOdWypozyczen);

        ekstensja.add(this);
    }

    public static List<PracownikBiurowy> getEkstensjaPracownikBiurowy() {
        return ekstensja;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public Optional<Double> getPremiaOdWypozyczen() {
        return premiaOdWypozyczen;
    }

    public void setPremiaOdWypozyczen(Optional<Double> premiaOdWypozyczen) {
        this.premiaOdWypozyczen = premiaOdWypozyczen;
    }
}

