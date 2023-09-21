package dalsze.podstawy.regex.osoba;

public class Main {
    public static void main(String[] args) {
        Osoba o1 = new Osoba("Jan", "Kowalski", "03232801654", Plec.MEZCZYZNA);
        Osoba o2 = new Osoba("Malgorzata", "Nowak", "04221106268", Plec.KOBIETA);

        System.out.println(o1.getformatLocalDate(o1.getDataUrodzenia()));
        System.out.println(o2.getformatLocalDate(o2.getDataUrodzenia()));
    }
}
