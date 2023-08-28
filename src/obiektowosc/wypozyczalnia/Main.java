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
        vd4.dodajSilnik(s4);
        vd5.dodajSilnik(s5);

        vk1.dodajSilnik(s1);
        vk2.dodajSilnik(s2);
        vk3.dodajSilnik(s3);
        vk4.dodajSilnik(s4);
        vk5.dodajSilnik(s5);

        so1.dodajSilnik(s1);
        so2.dodajSilnik(s2);
        so3.dodajSilnik(s3);
        so4.dodajSilnik(s4);
        so5.dodajSilnik(s5);
        so6.dodajSilnik(s1);
        so7.dodajSilnik(s2);
        so8.dodajSilnik(s3);
        so9.dodajSilnik(s4);
        so10.dodajSilnik(s5);
        so11.dodajSilnik(s1);
        so12.dodajSilnik(s2);
        so13.dodajSilnik(s3);
        so14.dodajSilnik(s4);
        so15.dodajSilnik(s5);

        m1.dodajSilnik(s1);
        m2.dodajSilnik(s2);
        m3.dodajSilnik(s3);
        m4.dodajSilnik(s4);
        m5.dodajSilnik(s5);

        // pokaz pojazdy z danym silnikiem
        System.out.println(Silnik.pojazdyZDanymSilnikiem(s1));


    }
}
