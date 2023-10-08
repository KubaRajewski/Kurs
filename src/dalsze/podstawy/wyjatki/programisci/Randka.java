package dalsze.podstawy.wyjatki.programisci;

import dalsze.podstawy.wyjatki.exceptions.TragediaExepction;
import dalsze.podstawy.wyjatki.exceptions.ZaDuzeEgoExeption;

public class Randka {
    private String nazwa;
    private Miejsce miejsce;
    private Kobieta kobieta;
    private Programista programista;

    public Randka(String nazwa, Miejsce miejsce, Kobieta kobieta, Programista programista) {
        this.nazwa = nazwa;
        this.miejsce = miejsce;
        this.kobieta = kobieta;
        this.programista = programista;
    }

    public String obliczSzanseNaZaliczenie() {
        double szansa = getMiejsce().getWartosc() + getKobieta().getRozmiarBiustu().getWartosc() - (getKobieta().getIq() / 10);

        try {
            if (szansa > 100) {
                throw new ZaDuzeEgoExeption();
            } else if (szansa < 0) {
                throw new TragediaExepction();
            }
        } catch (ZaDuzeEgoExeption e) {
            szansa = 30;
        } catch (TragediaExepction e) {
            szansa = 0;
        }

        return szansa + "%";
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Miejsce getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(Miejsce miejsce) {
        this.miejsce = miejsce;
    }

    public Kobieta getKobieta() {
        return kobieta;
    }

    public void setKobieta(Kobieta kobieta) {
        this.kobieta = kobieta;
    }

    public Programista getProgramista() {
        return programista;
    }

    public void setProgramista(Programista programista) {
        this.programista = programista;
    }

    @Override
    public String toString() {
        return "Randka{" +
                "nazwa='" + nazwa + '\'' +
                ", miejsce=" + miejsce +
                ", kobieta=" + kobieta +
                ", programista=" + programista +
                '}';
    }
}
