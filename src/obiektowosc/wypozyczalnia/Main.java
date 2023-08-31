package obiektowosc.wypozyczalnia;

//                                              PD TODO:
// Stworz swoj biznesowy diagram klas - uml + kod, wszystkie rodzaje atrybutow, dziedizczenie oraz asocajcje

// https://lucid.app/lucidchart/a94d15bd-97c4-43e4-89bd-348f2b3b3e82/edit?beaconFlowId=8BD42868E77CBC8D&invitationId=inv_598609eb-bccb-4006-be23-66cb6aac8ae9&page=0_0#

public class Main {
    public static void main(String[] args) {

        Silnik s1 = new Silnik("benzyna", 2000, 200, 150);
        Silnik s2 = new Silnik("diesel", 2500, 300, 200);
        Silnik s3 = new Silnik("benzyna", 3000, 250, 180);
        Silnik s4 = new Silnik("diesel", 3500, 350, 250);
        Silnik s5 = new Silnik("benzyna", 4000, 300, 200);
        Silnik s6 = new Silnik("diesel", 4500, 400, 300);

        VanDostawczy vd1 = new VanDostawczy("FWS1923", "Volkswagen", "Transporter", 2012, 70, true, 400, 3, 12);
        VanDostawczy vd2 = new VanDostawczy("XYZ5678", "Ford", "Transit", 2015, 80, true, 450, 4, 14);
        VanDostawczy vd3 = new VanDostawczy("ABC1234", "Mercedes", "Sprinter", 2018, 90, true, 500, 3, 13);
        VanDostawczy vd4 = new VanDostawczy("PQR7890", "Renault", "Master", 2014, 75, true, 420, 2, 10);
        VanDostawczy vd5 = new VanDostawczy("MNO4567", "Peugeot", "Boxer", 2016, 85, true, 460, 4, 15);

        VanKempingowy vk1 = new VanKempingowy("ABC9876", "Fiat", "Ducato", 2010, 60, true, 300, 5, 5);
        VanKempingowy vk2 = new VanKempingowy("JKL5432", "Citroen", "Jumper", 2013, 65, true, 350, 4, 4);
        VanKempingowy vk3 = new VanKempingowy("DEF2468", "Iveco", "Daily", 2017, 70, true, 400, 3, 4);
        VanKempingowy vk4 = new VanKempingowy("HIG7890", "Nissan", "NV300", 2015, 75, true, 450, 2, 5);
        VanKempingowy vk5 = new VanKempingowy("UVW1234", "Toyota", "Proace", 2018, 80, true, 500, 4, 5);

        SamochodOsobowy so1 = new SamochodOsobowy("XYZ1234", "Opel", "Astra", 2010, 50, true, 200, 5, "Sedan", 5, 60);
        SamochodOsobowy so2 = new SamochodOsobowy("ABC5678", "Volkswagen", "Golf", 2015, 55, true, 220, 5, "Hatchback", 4, 65);
        SamochodOsobowy so3 = new SamochodOsobowy("DEF9012", "Ford", "Focus", 2018, 60, true, 240, 5, "Sedan", 5, 70);
        SamochodOsobowy so4 = new SamochodOsobowy("JKL3456", "Renault", "Clio", 2014, 45, true, 180, 4, "Hatchback", 4, 55);
        SamochodOsobowy so5 = new SamochodOsobowy("MNO7890", "Toyota", "Corolla", 2016, 55, true, 220, 5, "Sedan", 5, 65);
        SamochodOsobowy so6 = new SamochodOsobowy("PQR2345", "Kia", "Ceed", 2017, 50, true, 200, 5, "Hatchback", 4, 60);
        SamochodOsobowy so7 = new SamochodOsobowy("UVW6789", "Hyundai", "i30", 2019, 60, true, 240, 5, "Sedan", 5, 70);
        SamochodOsobowy so8 = new SamochodOsobowy("HIJ4567", "Peugeot", "308", 2013, 55, true, 220, 5, "Hatchback", 4, 65);
        SamochodOsobowy so9 = new SamochodOsobowy("KLM8901", "Nissan", "Qashqai", 2018, 60, true, 240, 5, "SUV", 5, 75);
        SamochodOsobowy so10 = new SamochodOsobowy("STU2345", "BMW", "3 Series", 2016, 55, true, 220, 5, "Sedan", 5, 70);
        SamochodOsobowy so11 = new SamochodOsobowy("VWX6789", "Mercedes", "C-Class", 2017, 60, true, 240, 5, "Sedan", 5, 75);
        SamochodOsobowy so12 = new SamochodOsobowy("YZA4567", "Audi", "A4", 2019, 55, true, 220, 5, "Sedan", 5, 70);
        SamochodOsobowy so13 = new SamochodOsobowy("BCD8901", "Honda", "Civic", 2015, 50, true, 200, 5, "Hatchback", 4, 65);
        SamochodOsobowy so14 = new SamochodOsobowy("EFG2345", "Mazda", "3", 2014, 45, true, 180, 4, "Hatchback", 4, 60);
        SamochodOsobowy so15 = new SamochodOsobowy("HIJ6789", "Subaru", "Impreza", 2018, 55, true, 220, 5, "Sedan", 5, 65);

        Motocykl m1 = new Motocykl("ABC123", "Honda", "CBR", 2010, 30, true, 150, true);
        Motocykl m2 = new Motocykl("DEF456", "Kawasaki", "Ninja", 2015, 35, true, 160, false);
        Motocykl m3 = new Motocykl("GHI789", "Yamaha", "YZF", 2018, 40, true, 170, true);
        Motocykl m4 = new Motocykl("JKL012", "Suzuki", "GSX", 2014, 32, true, 155, true);
        Motocykl m5 = new Motocykl("MNO345", "Ducati", "Panigale", 2016, 38, true, 165, false);

        vd1.dodajSilnik(s1);
        vd2.dodajSilnik(s2);
        vd3.dodajSilnik(s3);
        vd4.dodajSilnik(s3);
        vd5.dodajSilnik(s5);

        vk1.dodajSilnik(s1);
        vk2.dodajSilnik(s2);
        vk3.dodajSilnik(s3);
        vk4.dodajSilnik(s3);
        vk5.dodajSilnik(s5);

        so1.dodajSilnik(s1);
        so2.dodajSilnik(s2);
        so3.dodajSilnik(s3);
        so4.dodajSilnik(s3);
        so5.dodajSilnik(s5);
        so6.dodajSilnik(s1);
        so7.dodajSilnik(s2);
        so8.dodajSilnik(s3);
        so9.dodajSilnik(s5);
        so10.dodajSilnik(s4);
        so11.dodajSilnik(s1);
        so12.dodajSilnik(s2);
        so13.dodajSilnik(s3);
        so14.dodajSilnik(s3);
        so15.dodajSilnik(s5);

        m1.dodajSilnik(s1);
        m2.dodajSilnik(s2);
        m3.dodajSilnik(s3);
        m4.dodajSilnik(s5);
        m5.dodajSilnik(s4);

        // pokaz pojazdy z danym silnikiem
        System.out.println("Pojazdy z danym silnikiem");
        System.out.println(Silnik.pojazdyZDanymSilnikiem(s1) + "\n");

        // wyswietl silnik w danym pojezdzie
        System.out.println("wyswietl silnik w danym pojezdzie");
        System.out.println(m4.getSilnik() + "\n");

        // wyswietl motocykle ktore mozna wypozyczyc na kat b
        System.out.println("Wyswielt motocykle ktore mozna wypozyczyc na kat b");
        System.out.println(Motocykl.motocykleNaB(Motocykl.getEkstensjaMotocykl()) + "\n");

        // wyswietl wszystkie pojazdy z moca wiecej niz 200 koni
        System.out.println("Pojazdy z moca wieksza niz x koni");
        System.out.println(Pojazd.pojazdyMocniejszeNiz(Pojazd.getEkstensja(), 200) + "\n");

        // wyswietl vany z dlugoscia paki wiekszej niz 3m
        System.out.println("Vany z dlugoscia wieksza niz x");
        System.out.println(Van.vanyZPakaDluzszaNiz(Van.getEkstensjaVan(), 3) + "\n");


        Klient k1 = new Klient("Jan", "Kowalski", "ul. Prosta 5", "JK12345", true);
        Klient k2 = new Klient("Magdalena", "Nowak", "ul. Kwiatowa 10", "MN67890", false);
        Klient k3 = new Klient("Karol", "Lewandowski", "ul. Mickiewicza 15", "KL24680", true);
        Klient k4 = new Klient("Alicja", "Dąbrowska", "ul. Leśna 20", "AD13579", false);
        Klient k5 = new Klient("Piotr", "Jankowski", "ul. Słoneczna 25", "PJ97531", true);
        Klient k6 = new Klient("Ewa", "Wójcik", "ul. Spacerowa 30", "EW86420", false);
        Klient k7 = new Klient("Michał", "Kaczmarek", "ul. Polna 35", "MK75319", true);
        Klient k8 = new Klient("Joanna", "Zielińska", "ul. Krótka 40", "JZ46802", false);
        Klient k9 = new Klient("Krzysztof", "Szymański", "ul. Wąska 45", "KS15973", false);
        Klient k10 = new Klient("Aleksandra", "Woźniak", "ul. Wiosenna 50", "AW24689", false);
        Klient k11 = new Klient("Bartosz", "Lis", "ul. Ogrodowa 55", "BL87531", false);
        Klient k12 = new Klient("Natalia", "Pawlak", "ul. Plażowa 60", "NP36482", false);
        Klient k13 = new Klient("Grzegorz", "Nowicki", "ul. Złota 65", "GN59273", true);
        Klient k14 = new Klient("Weronika", "Kowalczyk", "ul. Morska 70", "WK71829", false);
        Klient k15 = new Klient("Tomasz", "Michalski", "ul. Długa 75", "TM93758", true);
        Klient k16 = new Klient("Izabela", "Sikora", "ul. Jasna 80", "IS84629", false);
        Klient k17 = new Klient("Marcin", "Zawadzki", "ul. Górska 85", "MZ35982", false);
        Klient k18 = new Klient("Agata", "Kubiak", "ul. Stokrotki 90", "AK62471", false);
        Klient k19 = new Klient("Łukasz", "Witkowski", "ul. Malinowa 95", "ŁW14389", false);
        Klient k20 = new Klient("Monika", "Adamczyk", "ul. Lipowa 100", "MA87651", false);


        PracownikBiurowy pb1 = new PracownikBiurowy("Karolina", "Nowak", "ul. Zielona 5", "KN12345", 2800, "Umowa o pracę", "Księgowa");
        PracownikBiurowy pb2 = new PracownikBiurowy("Tomasz", "Kowalski", "ul. Kwiatowa 10", "TK67890", 3000, "Umowa o pracę", "Specjalista ds. administracji");
        PracownikBiurowy pb3 = new PracownikBiurowy("Anna", "Wiśniewska", "ul. Słoneczna 15", "AW24680", 2600, "Umowa o pracę", "Asystentka biura");
        PracownikBiurowy pb4 = new PracownikBiurowy("Piotr", "Jankowski", "ul. Polna 20", "PJ13579", 3200, "Umowa o pracę", "Sprzedawca", 0.15);
        PracownikBiurowy pb5 = new PracownikBiurowy("Magdalena", "Kaczmarek", "ul. Leśna 25", "MK97531", 2900, "Umowa o pracę", "Sprzedawca", 0.10);
        PracownikBiurowy pb6 = new PracownikBiurowy("Krzysztof", "Lis", "ul. Morska 30", "KL86420", 27000, "Umowa o pracę", "Specjalista ds. marketingu");
        PracownikBiurowy pb7 = new PracownikBiurowy("Natalia", "Pawlak", "ul. Ogrodowa 35", "NP75319", 3100, "Umowa o pracę", "Sprzedawca", 0.09);
        PracownikBiurowy pb8 = new PracownikBiurowy("Marcin", "Zawadzki", "ul. Jasna 40", "MZ46802", 2800, "Umowa o pracę", "Analityk finansowy");
        PracownikBiurowy pb9 = new PracownikBiurowy("Ewa", "Szymańska", "ul. Malinowa 45", "ES15973", 3000, "Umowa o pracę", "Specjalista ds. HR");
        PracownikBiurowy pb10 = new PracownikBiurowy("Bartosz", "Wójcik", "ul. Długa 50", "BW24689", 2600, "Umowa o pracę", "Recepcjonista");

        Mechanik me1 = new Mechanik("Kamil", "Kowalski", "ul. Warszawska 5", "KK12345", 3800, "Umowa o pracę", "Systemy wydechowe");
        Mechanik me2 = new Mechanik("Aleksandra", "Nowak", "ul. Słoneczna 10", "AN67890", 3600, "Umowa o pracę", "Zawieszenie");
        Mechanik me3 = new Mechanik("Patryk", "Lewandowski", "ul. Krakowska 15", "PL24680", 4500, "Umowa o pracę", "Układ hamulcowy");
        Mechanik me4 = new Mechanik("Monika", "Wiśniewska", "ul. Leśna 20", "MW13579", 3700, "Umowa o pracę", "Skrzynia biegów");
        Mechanik me5 = new Mechanik("Grzegorz", "Jankowski", "ul. Polna 25", "GJ97531", 3900, "Umowa o pracę", "Naprawy elektryczne");

        // Wszyscy klienci z karta lojalnosciowa
        System.out.println("Klienci z karta lojalnosciowa");
        System.out.println(Klient.klienciZKarta(Klient.getEkstensjaKlient()) + "\n");

        // pracownicy zarabiajacy wiecej niz x
        System.out.println("Pracownicy zarabiajacy wiecej niz x ");
        System.out.println(Pracownik.zarabiajacyWiecejNiz(Pracownik.getEkstensjaPracownik(), 4000) + "\n");

        // pracownicy z umowa o prace
        System.out.println("Pracownicy z umowa o prace");
        System.out.println(Pracownik.pracownicyZDanaUmowa(Pracownik.getEkstensjaPracownik(), "Umowa o pracę") + "\n");


        // Wypozyczenia
        Wypozyczenie w1 = new Wypozyczenie("2019-01-01", "2019-01-02", 2000, vd1, k1, pb1);
        Wypozyczenie w2 = new Wypozyczenie("2019-01-03", "2019-01-04", 2000, vd2, k2, pb2);
        Wypozyczenie w3 = new Wypozyczenie("2019-01-05", "2019-01-06", 2000, vd3, k3, pb3);

        System.out.println(vd3.getWypozyczenia());
    }
}
