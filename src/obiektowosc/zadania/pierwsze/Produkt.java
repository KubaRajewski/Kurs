package obiektowosc.zadania.pierwsze;

import java.util.Optional;

public class Produkt {
    private String nazwa;
    private double cena;
    private Optional<Double> wymiar;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.wymiar = Optional.empty(); // Rozmiar jest opcjonalny i początkowo pusty

        if (nazwa.startsWith("Kondom")) {
            throw new IllegalArgumentException("Kondom musi miec wymiar");
        }
    }

    public Produkt(String nazwa, double cena, double wymiar) {
        if (!nazwa.startsWith("Kondom")) {
            throw new IllegalArgumentException("Wymiar moze miec tylko produkt typu Kondom");
        }
        this.nazwa = nazwa;
        this.cena = cena;
        this.wymiar = Optional.of(wymiar); // Ustawiamy rozmiar, jeśli produkt to Kondom
    }

    // Gettery i settery

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public Optional<Double> getWymiar() {
        return wymiar;
    }

    public void setWymiar(double wymiar) {
        this.wymiar = Optional.of(wymiar);
    }
}
