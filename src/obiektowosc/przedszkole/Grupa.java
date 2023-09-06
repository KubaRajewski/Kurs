package obiektowosc.przedszkole;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grupa {
    private String nazwa;
    private Wychowawca wychowawca;
    private Sala sala;

    private static final int MAX_LICZBA_DZIECI = 15;

    private List<Dziecko> dzieci = new ArrayList<>();

    private static List<Grupa> ekstensja = new ArrayList<>();

    public Grupa(String nazwa) {
        this.nazwa = nazwa;

        ekstensja.add(this);
    }

    public void dodajDziecko(Dziecko dziecko) {
        if (dzieci.size() < MAX_LICZBA_DZIECI) {
            dzieci.add(dziecko);
            dziecko.setGrupa(this);
        } else {
            throw new IllegalArgumentException("Nie można dodać dziecka do grupy " + nazwa + " - grupa jest pełna");
        }
    }

    public void dodajWychowawce(Wychowawca wychowawca) {
        if (this.wychowawca == null && !wychowawca.getGrupy().contains(this)) {
            this.wychowawca = wychowawca;
            wychowawca.getGrupy().add(this);
        } else {
            throw new IllegalArgumentException("Nie można dodać wychowawcy do grupy " + nazwa + " - grupa ma już wychowawcę");
        }
    }

    public void dodajSale(Sala sala) {
        if (this.sala == null && sala.getGrupa() == null) {
            this.sala = sala;
            sala.setGrupa(this);
        } else {
            throw new IllegalArgumentException("Nie można dodać sali do grupy " + nazwa + " - grupa ma już swoja sale lub sala jest już zajęta");
        }
    }

    // TODO  * - zapisz do pliku imiona i nazwiska wszystkich dzieci którzy sa w grupie dla wychowawcy podanego jako parametr
    public static void zapiszDzieciDoPliku(String imie, String nazwisko) {
        for (Grupa g : ekstensja) {
            if (g.getWychowawca().getImie().equalsIgnoreCase(imie) && g.getWychowawca().getNazwisko().equalsIgnoreCase(nazwisko)){
                String groupName = g.getNazwa();
                String rootPath = "src/obiektowosc/przedszkole";
                String groupFolderPath = rootPath + File.separator + "grupy";
                String filePath = groupFolderPath + File.separator + groupName + ".txt";

                File groupFolder = new File(groupFolderPath);
                groupFolder.mkdirs();

                File f = new File(filePath);

                for (Dziecko d : g.getDzieci()) {
                    zapiszDoPliku(d, f);
                }
            }
        }
    }

    public static void zapiszDoPliku(Dziecko d, File f) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(f, true));
            bw.write(d.getImie() + " " + d.getNazwisko());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public Wychowawca getWychowawca() {
        return wychowawca;
    }

    public void setWychowawca(Wychowawca wychowawca) {
        this.wychowawca = wychowawca;
    }

    public static int getMaxLiczbaDzieci() {
        return MAX_LICZBA_DZIECI;
    }

    public List<Dziecko> getDzieci() {
        return dzieci;
    }

    public void setDzieci(List<Dziecko> dzieci) {
        this.dzieci = dzieci;
    }

    public static List<Grupa> getEkstensja() {
        return ekstensja;
    }

    public static void setEkstensja(List<Grupa> ekstensja) {
        Grupa.ekstensja = ekstensja;
    }

    @Override
    public String toString() {
        return "Nazwa: " + nazwa + ", Sala: " + sala + ", Wychowawca: " + wychowawca;
    }
}
