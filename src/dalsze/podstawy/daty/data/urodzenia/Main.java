package dalsze.podstawy.daty.data.urodzenia;

//Poproś program aby zapytal Cię o datę Twojego urodzenia
//- jeśli podałeś datę późniejszą niż dziś to niech program rzuci
//   błędem: InvalidBirthDateException
//- program wypisuje ile dni żyjesz już
//- program wypisuje ile już miesiecy żyjesz
//- program wypisuje już ile lat żyjesz
//- program wypisuje w który dzień tygodnia się urodziłeś

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) {

        String data = "14-10-199d5";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = null;
        try {
            birthDate = LocalDate.parse(data, dtf);
            czyDataJestWPrzyszlosci(birthDate);

            System.out.println(ileDniZyje(birthDate));
            System.out.println(ileMiesiecyZyje(birthDate));
            System.out.println(wJakimDniuSieUrodzil(birthDate));
        } catch (DateTimeParseException e) {
            System.out.println(e.getMessage());
            System.out.println("Nie  mozna sparsowac daty");
        } catch (InvalidBirthDateException e) {
            System.out.println(e.getMessage());
            System.out.println("Nie mozesz podac daty w przyszlosci");
        }
    }

    public static void czyDataJestWPrzyszlosci(LocalDate date) {
        if (date.isAfter(LocalDate.now())) {
            throw new InvalidBirthDateException("data nie moze byc pozniejsza niz dzisiaj");

        }
    }

    public static long ileDniZyje(LocalDate date) {
        return ChronoUnit.DAYS.between(LocalDate.now(), date);
    }

    public static long ileMiesiecyZyje(LocalDate date) {
        return ChronoUnit.MONTHS.between(LocalDate.now(), date);
    }

    public static long ileLatZyje(LocalDate date) {
        return ChronoUnit.YEARS.between(LocalDate.now(), date);
    }

    public static DayOfWeek wJakimDniuSieUrodzil(LocalDate date) {
        return date.getDayOfWeek();
    }

}
