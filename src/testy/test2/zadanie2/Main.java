package testy.test2.zadanie2;

//    Zadanie 02:
//    Dane są trzy pliki tekstowe o nazwach: lekarze.txt, pacjenci.txt, wizyty.txt.
//    Zawierają one informacje na temat lekarzy, pacjentów i odbytych wizyt domowych.
//    W każdym z plików dane w wierszu oddzielone są znakami tabulacji.
//    Plik o nazwie lekarze.txt zawiera informacje na temat lekarzy: numer identyfikacyjny
//    lekarza, jego nazwisko, imię, specjalność, datę urodzenia, numer NIP i numer PESEL.
//    Przykład:
//    23 Kadaj Monika pediatra 1965-03-16 879-122-69-94 65031687654
//    34 Nowak Anna nefrolog 1965-03-16 879-122-69-94 65031687654
//    Plik o nazwie pacjenci.txt zawiera dane na temat pacjentów: numer identyfikacyjny
//    pacjenta, jego nazwisko, imię, numer PESEL i datę urodzenia.
//    Przykład:
//    122 Nowakowska Joanna 73050512356 1973-05-05
//    124 Witkowski Hubert 88030422345 1988-03-04
//    Plik o nazwie wizyty.txt zawiera informacje na temat domowych wizyt lekarskich
//    przeprowadzonych przez lekarzy u pacjentów: numer identyfikacyjny lekarza, numer
//    identyfikacyjny pacjenta oraz datę wizyty lekarskiej przeprowadzonej przez lekarza
//    u pacjenta.
//    Przykład:
//    23 124 2006-12-13
//    34 122 2007-02-20
//
//    Wykorzystując informacje zawarte w plikach wykonaj następujące polecenia:
//    - znajdź lekarza ktory miał najwięcej wizyt
//    - znajdź pacjenta który miał najwięcej wizyt
//    - która specalizacja cieszy się największym powodzeniem?
//    - którego roku było najwięcej wizyt?
//    - wypisz top 5 najstarszych lekarzy
//    - wypisz top 5 lekarzy co mieli najwiecej wizyt
//    - zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
//    - zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta
//
//    UWAGA: w plikach mogą być dane złośliwe, należy je pominać, dane złośliwe to np: lekarz ze zduplikowanym numerem NIP (wtedy bierzemy pierwszego o takim numerze)
//    lub id pacjenta / id lekarza w wizyty.txt ktore nie istnieje w lekarze.txt lub pacjenci.txt

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File fileDoctors = new File("src/testy/test2/zadanie2/files/lekarze.txt");
        File filePatients = new File("src/testy/test2/zadanie2/files/pacjenci.txt");
        File fileVisits = new File("src/testy/test2/zadanie2/files/wizyty.txt");

        Doctor.readDoctors(fileDoctors);
        Patient.readPatients(filePatients);
        Visit.readVisits(fileVisits);

        //TODO - znajdź lekarza ktory miał najwięcej wizyt
        System.out.println("Lekarz ktory mial najwiecej wizyt: " + Doctor.busiestDoctor());

        //TODO - znajdź pacjenta który miał najwięcej wizyt
        System.out.println("\nPacjent ktory mial najwiecej wizyt: " + Patient.busiestPatient());

        //TODO - która specalizacja cieszy się największym powodzeniem?
        System.out.println("\nNajpopularniejsza specjalizacja: " + Doctor.mostPopularSpecialty());

        //TODO - którego roku było najwięcej wizyt?
        System.out.println("\nNajwiecej wizyt bylo w roku: " + Visit.busiestYear()+"\n");

        //TODO - wypisz top 5 najstarszych lekarzy
        System.out.println("x najstarszych lekarzy: ");
        Doctor.oldestDoctors(5).forEach(System.out::println);
        System.out.println();

        //TODO - wypisz top 5 lekarzy co mieli najwiecej wizyt
        System.out.println("5 lekarzy z najwieksza iloscia wizyt: ");
        Doctor.busiestDoctors(5).forEach(System.out::println);
        System.out.println();

        //TODO - zwroc pacientow ktorzy byli u minumum 5ciu roznych lekarzy
        System.out.println("Pacjenci ktorzy byli u 5 roznych lekarzy: ");
        Patient.patientsWithMinimumDoctors(5).forEach(System.out::println);
        System.out.println();

        //TODO - zwroc lekarzy ktorzy przyjeli tylko jednego pacjenta
        System.out.println("Lekarze z tylko jednym pacjentem: ");
        Doctor.doctorsWithCertainAmountOfPatients(1).forEach(System.out::println);
    }
}
