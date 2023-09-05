package obiektowosc.przedszkole;

import java.util.ArrayList;
import java.util.List;

public class Kwalifikowany extends Wychowawca{
    private Kwalifikacje kwalifikacje;

    public Kwalifikowany(String imie, String nazwisko, String dataUrodzenia) {
        super(imie, nazwisko, dataUrodzenia);
    }

    public void dodajKwalifikacje(Kwalifikacje kwalifikacje) {
        this.kwalifikacje = kwalifikacje;
        kwalifikacje.dodajWychowawce(this);
    }

    @Override
    public int obliczPensje() {
        int pensja = 0;
        if (kwalifikacje.obliczStopien().equalsIgnoreCase("STARSZY_WYCHOWAWCA")) {
              pensja = 7000;
          } else if (kwalifikacje.obliczStopien().equalsIgnoreCase("WYCHOWAWCA_Z_KURSEM")) {
              pensja = 5000;
          } else if (kwalifikacje.obliczStopien().equalsIgnoreCase("WYCHOWAWCA")) {
              pensja = 3500;
          } else if (kwalifikacje.obliczStopien().equalsIgnoreCase("MLODSZY_WYCHOWAWCA")) {
            pensja = 2000;
        }
        return pensja;
    }

    public Kwalifikacje getKwalifikacje() {
        return kwalifikacje;
    }

    public void setKwalifikacje(Kwalifikacje kwalifikacje) {
        this.kwalifikacje = kwalifikacje;
    }
}
