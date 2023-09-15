package obiektowosc.przedszkole;

public class Kwalifikacje {

    private Wychowawca wychowawca;
    private boolean licencjat;
    private boolean magister;
    private boolean doktorat;
    private boolean kursDoszkalajacy;
    private int stazPracy;

    public Kwalifikacje(boolean licencjat, boolean magister, boolean doktorat, boolean kursDoszkalajacy, int stazPracy) {
        this.wychowawca = wychowawca;
        this.licencjat = licencjat;
        this.magister = magister;
        this.doktorat = doktorat;
        this.kursDoszkalajacy = kursDoszkalajacy;
        this.stazPracy = stazPracy;
    }

    public String obliczStopien() {
        String stopien = "";
        if (this.licencjat && !this.isMagister() && !this.doktorat && !this.isKursDoszkalajacy() && this.stazPracy < 5) {
            stopien = "MLODSZY_WYCHOWAWCA";
        } else if (this.licencjat && this.isMagister() && !this.doktorat && !this.isKursDoszkalajacy() && this.stazPracy > 5) {
            stopien = "WYCHOWAWCA";
        } else if (this.licencjat && this.isMagister() && !this.doktorat && this.isKursDoszkalajacy() && this.stazPracy > 5) {
            stopien = "WYCHOWAWCA_Z_KURSEM";
        } else if ((this.licencjat && this.isMagister() && this.doktorat) || this.licencjat && this.isMagister() && !this.doktorat && this.isKursDoszkalajacy() && this.stazPracy > 10) {
            stopien = "STARSZY_WYCHOWAWCA";
        }
        return stopien;
    }

    public void dodajWychowawce(Wychowawca wychowawca) {
        this.wychowawca = wychowawca;
    }

    public Wychowawca getWychowawca() {
        return wychowawca;
    }

    public void setWychowawca(Wychowawca wychowawca) {
        this.wychowawca = wychowawca;
    }

    public boolean isLicencjat() {
        return licencjat;
    }

    public void setLicencjat(boolean licencjat) {
        this.licencjat = licencjat;
    }

    public boolean isMagister() {
        return magister;
    }

    public void setMagister(boolean magister) {
        this.magister = magister;
    }

    public boolean isDoktorat() {
        return doktorat;
    }

    public void setDoktorat(boolean doktorat) {
        this.doktorat = doktorat;
    }

    public boolean isKursDoszkalajacy() {
        return kursDoszkalajacy;
    }

    public void setKursDoszkalajacy(boolean kursDoszkalajacy) {
        this.kursDoszkalajacy = kursDoszkalajacy;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }
}
