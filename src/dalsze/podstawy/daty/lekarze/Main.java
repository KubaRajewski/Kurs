package dalsze.podstawy.daty.lekarze;

import java.io.File;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        //TODO dodatek z dat do lekarzy

        File fileDoctors = new File("src/dalsze/podstawy/daty/lekarze/files/lekarze.txt");
        File filePatients = new File("src/dalsze/podstawy/daty/lekarze/files/pacjenci.txt");
        File fileVisits = new File("src/dalsze/podstawy/daty/lekarze/files/wizyty.txt");

        Doctor.readDoctors(fileDoctors);
        Patient.readPatients(filePatients);
        Visit.readVisits(fileVisits);

        // TODO Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku
        System.out.println("\nPacjenci ktorzy mieli wizyty od 2000 roku: " + Patient.patientsWithVisitsAfterCertainYear(Patient.getExtension(), Year.of(2000)));

        // TODO Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
        System.out.println("\nLekarze ktorzy mieli wizyty w marcu, czerwcu i grudniu 2007: " + Doctor.doctorsWithVisitsInGivenMonths(Year.of(2007), new ArrayList<>(List.of(Month.MARCH, Month.JUNE, Month.DECEMBER))));

        // TODO Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
        System.out.println("\nLekarz ktory mial najwiecej wizyt w okresie podanym jako parametr: " + Doctor.busiestDoctorInPeriod(Year.of(2006).atMonth(Month.JANUARY).atDay(1), Year.of(2007).atMonth(Month.DECEMBER).atDay(31)));
    }
}


