package dalsze.podstawy.interfejsy.zbiornik;

public interface IZbiornik {
    void dolej(double ilosc);
    void odlej(double ilosc);
    void przelej(double ilosc, Zbiornik zbiornik);
}
