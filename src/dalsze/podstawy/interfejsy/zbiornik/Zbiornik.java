package dalsze.podstawy.interfejsy.zbiornik;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zbiornik implements IZbiornik {
    private final String nazwa;
    private final double pojemnosc;
    private double stan;

    private List<Operacja> operacje = new ArrayList<>();

    private static List<Zbiornik> ekstensja = new ArrayList<>();

    public Zbiornik(String nazwa, double pojemnosc) {
        this.nazwa = nazwa;
        this.pojemnosc = pojemnosc;
        this.stan = 0;

        ekstensja.add(this);
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
            operacje.add(new Operacja(TypOperacji.DOLEWANIE, nazwaOperacji(), this, ilosc, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            operacje.add(new Operacja(TypOperacji.DOLEWANIE, nazwaOperacji(), this, ilosc, false));
        }
    }

    @Override
    public void odlej(double ilosc) {
        try {
            if (stan < ilosc) {
                throw new IllegalArgumentException("Niemożliwe jest odlewanie więcej niż jest w zbiorniku");
            } else if (ilosc <= 0) {
                throw new IllegalArgumentException("podaj inna wartosc");
            }

            stan -= ilosc;
            operacje.add(new Operacja(TypOperacji.ODLEWANIE, nazwaOperacji(), this, ilosc, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            operacje.add(new Operacja(TypOperacji.ODLEWANIE, nazwaOperacji(), this, ilosc, false));
        }
    }

    @Override
    public void przelej(Zbiornik zbiornik, double ilosc) {
        try {
            if (zbiornik.getStan() < ilosc) {
                throw new IllegalArgumentException("Nie można przelewać więcej niż jest w zbiorniku");
            } else if (ilosc <= 0) {
                throw new IllegalArgumentException("podaj inna wartosc");
            }

            zbiornik.setStan(zbiornik.getStan() - ilosc);
            stan += ilosc;
            operacje.add(new Operacja(TypOperacji.PRZELEWANIE, nazwaOperacji(), this, ilosc, true));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            operacje.add(new Operacja(TypOperacji.PRZELEWANIE, nazwaOperacji(), this, ilosc, false));
        }
    }

    public int getIloscZlychOperacji() {
        int ilosc = 0;
        for (Operacja operacja : operacje) {
            if (!operacja.isCzyPowiodloSie()) {
                ilosc++;
            }
        }
        return ilosc;
    }

    public int getIloscOperacjiDanegoTypu(TypOperacji typOperacji) {
        int licznik = 0;

        for (Operacja operacja : operacje) {
            if (operacja.getTypOperacji() == typOperacji) {
                licznik++;
            }
        }

        return licznik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getPojemnosc() {
        return pojemnosc;
    }


    public double getStan() {
        return stan;
    }

    public void setStan(double stan) {
        this.stan = stan;
    }

    public static List<Zbiornik> getEkstensja() {
        return ekstensja;
    }

    public List<Operacja> getOperacje() {
        return operacje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zbiornik zbiornik)) return false;
        return Double.compare(zbiornik.pojemnosc, pojemnosc) == 0 && Double.compare(zbiornik.stan, stan) == 0 && Objects.equals(nazwa, zbiornik.nazwa) && Objects.equals(operacje, zbiornik.operacje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, pojemnosc, stan, operacje);
    }

    private String nazwaOperacji() {
        return "Zbiornik: " + nazwa + " Operacja nr: " + (operacje.size() + 1);
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + ", Pojemnosc: " + pojemnosc + ", Stan: " + stan;
    }
}
