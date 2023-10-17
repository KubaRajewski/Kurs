package dalsze.podstawy.interfejsy.piekarnik;

public class PiekarnikElektryczny implements Piekarnik{
    private int temperatura;
    private int czas; // minuty

    @Override
    public void pieczWolowine() {
        setCzas(60);
        setTemperatura(210);
    }

    @Override
    public void pieczKurczaka() {
        setCzas(30);
        setTemperatura(180);
    }

    @Override
    public void pieczChleb() {
        setCzas(45);
        setTemperatura(15);
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
