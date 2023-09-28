package dalsze.podstawy.interfejsy.dodatkowe.Biblioteka;

public interface Czytelnik {
    void wypozycz(Ksiazka ksiazka);
    void zwroc(Ksiazka ksiazka);
    boolean czyMaZalegleKsiazki();
}
