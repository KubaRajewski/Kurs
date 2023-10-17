package dalsze.podstawy.interfejsy.piekarnik;


public class PiekarnikParowy implements Piekarnik{
    private int temperatura;
    private int czas; // minuty

    @Override
    public void pieczWolowine() {
        setCzas(80);
        setTemperatura(110);
    }

    @Override
    public void pieczKurczaka() {
        setCzas(60);
        setTemperatura(180);
    }

    @Override
    public void pieczChleb() {
        setCzas(55);
        setTemperatura(185);
    }

    public int getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(int temperatura) {
        this.temperatura = temperatura;
    }

    public int getCzas() {
        return czas;
    }

    public void setCzas(int czas) {
        this.czas = czas;
    }
}