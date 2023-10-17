package dalsze.podstawy.interfejsy.piekarnik;

public class PiekarnikGazowy implements Piekarnik{
    private int temperatura;
    private int czas; // minuty

    @Override
    public void pieczWolowine() {
        setCzas(65);
        setTemperatura(220);
    }

    @Override
    public void pieczKurczaka() {
        setCzas(45);
        setTemperatura(180);
    }

    @Override
    public void pieczChleb() {
        setCzas(60);
        setTemperatura(180);
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