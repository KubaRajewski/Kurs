package dalsze.podstawy.interfejsy.piekarnik;

// Stworz system dla obslugi piekarnikow, mamy rozne piekarniki, np elektryczny, gazowy, parowy. Kazdy z nich ma funkcje typu
// piecz wołowine, piecz kurczaka, piecz chleb ale roznie moga byc implementowane (np inny czas, inna temperatura)

public interface Piekarnik {
    void pieczWolowine();
    void pieczKurczaka();
    void pieczChleb();
}
