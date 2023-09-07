//package obiektowosc.przedszkole;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public abstract class DzieckoPoprawione extends Osoba {
//    private Grupa grupa;
//
//    public static List<Dziecko> ekstensja = new ArrayList<>();
//
//    public Dziecko(String imie, String nazwisko, String dataUrodzenia) {
//        super(imie, nazwisko, dataUrodzenia);
//
//        ekstensja.add(this);
//    }
//
//    public Grupa getGrupa() {
//        return grupa;
//    }
//
//    public void setGrupa(Grupa grupa) {
//        this.grupa = grupa;
//    }
//
//    public static List<Dziecko> getEkstensjaDziecko() {
//        return ekstensja;
//    }
//}