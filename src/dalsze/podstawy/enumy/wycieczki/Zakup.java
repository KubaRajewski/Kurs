package dalsze.podstawy.enumy.wycieczki;

import java.util.ArrayList;
import java.util.List;

public class Zakup {
    private final Wycieczka wycieczka;
    private Klient klient;
    private List<Dodatek> dodatki = new ArrayList<>();

    public Zakup(Wycieczka wycieczka, Klient klient) {
        if (wycieczka == null || klient == null) {
            throw new IllegalArgumentException("Klient i wycieczka musza byc wypelnione");
        }

        this.wycieczka = wycieczka;
        this.klient = klient;
    }

    public double obliczCeneWybranychDodatkow(){
        double suma = 0;
        for (Dodatek dodatek : dodatki) {
            suma =+ dodatek.getCena();
        }
        return suma;
    }

    public Wycieczka getWycieczka() {
        return wycieczka;
    }

    public Klient getKlient() {
        return klient;
    }

    public List<Dodatek> getDodatki() {
        return dodatki;
    }

    public void setDodatki(List<Dodatek> dodatki) {
        this.dodatki = dodatki;
    }

    public void setKlient(Klient klient) {
        this.klient = klient;
    }

}
