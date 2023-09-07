//package obiektowosc.turniej;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class TurniejPoprawiony {
//    private String nazwa;
//    private String miesiac;
//
//    private List<Wynik> wyniki = new ArrayList<>();
//
//    private static List<TurniejPoprawiony> ekstensja = new ArrayList<>();
//
//    public TurniejPoprawiony(String nazwa, String miesiac) {
//        this.nazwa = nazwa;
//        this.miesiac = miesiac;
//
//        ekstensja.add(this);
//    }
//
//    public String getNazwa () {
//        return nazwa;
//    }
//
//    public void setNazwa (String nazwa){
//        this.nazwa = nazwa;
//    }
//
//    public String getMiesiac () {
//        return miesiac;
//    }
//
//    public void setMiesiac (String miesiac){
//        this.miesiac = miesiac;
//    }
//
//
//    public List<Wynik> getWyniki() {
//        return wyniki;
//    }
//
//    public void setWyniki(List<Wynik> wyniki) {
//        this.wyniki = wyniki;
//    }
//
//    public static List<TurniejPoprawiony> getEkstensja () {
//        return ekstensja;
//    }
//
//    public static void setEkstensja (List <TurniejPoprawiony> ekstensja) {
//        TurniejPoprawiony.ekstensja = ekstensja;
//    }
//
//    @Override
//    public String toString() {
//        return nazwa + " " + miesiac;
//    }
//
//
//}
//
