package testy.test2.zadanie3;

//    Zadanie 03:
//    Stworz klase Osoba (imie, nazwisko, pesel, miasto)
//    klase Student (grupa, stypendium)
//    oraz Pracownik (stanowisko, pensja)
//    stworz tablice Osob w ktorej beda zarowno studenci jak i pracownicy
//    - znajdz osobe z najwiekszym dochodem (dochod dla studenta to jego stypendium a dla pracownika jego pensja)
//    - policz ile jest kobiet w tablicy (osoba powinna miec metode getPlec() ktora oblicza plec na bazie nr pesel)

public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Jan", "Kowalski", "03232801654", "Wroclaw", "g1", 1000);
        Student s2 = new Student("Anna", "Nowak", "01234567880", "Krakow", "g2", 1200);
        Student s3 = new Student("Piotr", "Wisniewski", "98765432111", "Warszawa", "g1", 950);
        Student s4 = new Student("Alicja", "Dabrowska", "12345678901", "Gdansk", "g3", 1100);
        Student s5 = new Student("Marek", "Lis", "23456789012", "Poznan", "g2", 1050);
        Student s6 = new Student("Katarzyna", "Zielinska", "34567890123", "Lodz", "g4", 1300);
        Student s7 = new Student("Tomasz", "Wojcik", "45678901234", "Szczecin", "g3", 1150);
        Student s8 = new Student("Monika", "Kaczmarek", "56789012345", "Katowice", "g1", 980);
        Student s9 = new Student("Grzegorz", "Kowalczyk", "67890123456", "Bydgoszcz", "g4", 1250);
        Student s10 = new Student("Ewa", "Nowicka", "78901234567", "Rzeszow", "g2", 1120);

        Pracownik p1 = new Pracownik("Anna", "Nowaczyk", "04232801664", "Warszawa", "Ksiegowa", 3000);
        Pracownik p2 = new Pracownik("Piotr", "Kowalski", "12345678911", "Krakow", "Informatyk", 4000);
        Pracownik p3 = new Pracownik("Alicja", "Wisniewska", "23456789022", "Wroclaw", "Manager", 5000);
        Pracownik p4 = new Pracownik("Marek", "Dabrowski", "34567890113", "Gdansk", "Sprzedawca", 2500);
        Pracownik p5 = new Pracownik("Katarzyna", "Lis", "45678901244", "Poznan", "Analityk", 4200);
        Pracownik p6 = new Pracownik("Tomasz", "Zielinski", "56789012355", "Lodz", "Inzynier", 3800);
        Pracownik p7 = new Pracownik("Monika", "Wojcik", "67890123466", "Szczecin", "Recepcjonistka", 2800);
        Pracownik p8 = new Pracownik("Grzegorz", "Kaczmarek", "78901234577", "Katowice", "Magazynier", 3200);
        Pracownik p9 = new Pracownik("Ewa", "Kowalczyk", "89012345648", "Bydgoszcz", "Serwisant", 3600);
        Pracownik p10 = new Pracownik("Jan", "Nowicki", "90123456799", "Rzeszow", "Kierowca", 2700);

        Osoba[] osoby = new Osoba[Osoba.getEkstensja().size()];

        for (int i = 0; i < Osoba.getEkstensja().size(); i++) {
            osoby[i] = Osoba.getEkstensja().get(i);
        }

        System.out.println("Kto zarabia najwiecej: " + obliczOsobeZNajwiekszymDochodem(osoby));

        System.out.println("Ile jest kobiet w tablicy: " + ileKobietJestWtablicy(osoby));

    }

    public static Osoba obliczOsobeZNajwiekszymDochodem(Osoba[] osoby) {
        Osoba najbogatsza = osoby[1];

        for (Osoba o : osoby) {
            if (o.obliczDochod() > najbogatsza.obliczDochod()) {
                najbogatsza = o;
            }
        }
        return najbogatsza;
    }

    public static int ileKobietJestWtablicy(Osoba[] osoby) {
        int iloscKobietWTablicy = 0;

        for (Osoba o : osoby) {
            if (o.getPlec().equals("Kobieta")) {
                iloscKobietWTablicy++;
            }
        }

        return iloscKobietWTablicy;
    }


}