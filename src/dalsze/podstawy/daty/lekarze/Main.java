package dalsze.podstawy.daty.lekarze;

import java.io.File;
import java.time.LocalDate;
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

        // TODO 1) Wypisz wszystkich pacjentów którzy mieli wizyty od 2000 roku
        // wzgledem oryginalnych danych zmienilismy ostatnia wartosc w wizytach na 2008 zeby sprawdzicz czy metoda dziala
        System.out.println("\nPacjenci ktorzy mieli wizyty od 2008 roku: " + Patient.patientsWithVisitsAfterCertainYear(Patient.getExtension(), Year.of(2008)));

        // TODO 2) Wypisz wszystkich lekarzy którzy mieli wizyty w marcu, czerwcu i grudniu 2007
        System.out.println("\nLekarze ktorzy mieli wizyty w marcu, czerwcu i grudniu 2007: " + Doctor.doctorsWithVisitsInGivenMonths(Doctor.getExtension(), new ArrayList<>(List.of(Month.MARCH, Month.JUNE, Month.DECEMBER)), 2007));

        // TODO 3) Wypisz lekarza ktory miał najwiecej wizyt w okresie podanym jako parametr
        System.out.println("\nLekarz ktory mial najwiecej wizyt w okresie podanym jako parametr: " + Doctor.busiestDoctorInPeriod(Doctor.getExtension(), LocalDate.of(2005, 1, 1), LocalDate.of(2009, 12, 31)));
    }
}


