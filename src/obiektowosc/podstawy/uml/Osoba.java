package obiektowosc.podstawy.uml;

public abstract class Osoba {
    private String imie;
    private String nazwisko;
    private String adres;

    public Osoba(String imie, String nazwisko, String adres) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
    }

    // metoda abstrakcyjna, nie ma ciala
    // implementujemy ja w podklasach (polimorfizm metod)
    public abstract double obliczDochod();

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public String toString() {
        return imie + " " + nazwisko;
    }
}
