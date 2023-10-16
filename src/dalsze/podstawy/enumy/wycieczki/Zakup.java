package dalsze.podstawy.enumy.wycieczki;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class Zakup {
    private Klient klient;
    private final Wycieczka wycieczka;
    private List<Dodatek> dodatki;
    private final LocalDate dataZakupu;

    public Zakup(Wycieczka wycieczka, Klient klient, List<Dodatek> dodatki) {
        if (wycieczka == null || klient == null || dodatki == null) {
            throw new IllegalArgumentException("Klient, wycieczka i dodatki musza byc wypelnione");
        }

        this.wycieczka = wycieczka;
        this.klient = klient;
        this.dodatki = dodatki;
        this.dataZakupu = LocalDate.now();

        klient.getZakupy().add(this);
        wycieczka.getZakupy().add(this);
    }

    public double obliczCenyWydatkow(){
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

    public LocalDate getDataZakupu() {
        return dataZakupu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zakup zakup)) return false;
        return Objects.equals(klient, zakup.klient) && Objects.equals(wycieczka, zakup.wycieczka) && Objects.equals(dodatki, zakup.dodatki) && Objects.equals(dataZakupu, zakup.dataZakupu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(klient, wycieczka, dodatki, dataZakupu);
    }

    @Override
    public String toString() {
        return "Zakup{" +
                "klient=" + klient +
                ", wycieczka=" + wycieczka +
                ", dodatki=" + dodatki +
                ", dataZakupu=" + dataZakupu +
                '}';
    }
}
