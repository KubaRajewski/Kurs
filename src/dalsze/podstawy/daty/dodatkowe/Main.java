package dalsze.podstawy.daty.dodatkowe;




import java.sql.Timestamp;
import java.text.DateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Main {
    // Obliczanie Różnicy Czasu: Napisz program, który oblicza różnicę czasu między dwoma datami i wyświetla ją w godzinach, minutach i sekundach, używając klasy Duration.
    public static String roznicaCzasu(LocalDateTime date1, LocalDateTime date2){
        Duration d = Duration.between(date1, date2);
        long sekundy = d.toSeconds();
        long minuty = d.toMinutes();
        long godziny = minuty/60;

        return "godziny: " + godziny + ", minuty: " + minuty + ", sekundy: " + sekundy;
    }

    // Okres Między Datami: Stwórz funkcję, która oblicza okres (ilość lat, miesięcy i dni) między dwoma datami, korzystając z klasy Period.
    public static String okres(LocalDate date1, LocalDate date2){
        int lata = Period.between(date1, date2).getYears();
        int miesiace = Period.between(date1, date2).getMonths();
        int dni = Period.between(date1, date2).getDays();

        return "Lata: " + lata + ", Miesiace: " + miesiace + ", Dni: " + dni;
    }

    // Formatowanie Daty i Czasu: Napisz program, który przyjmuje obiekt LocalDateTime i formatuje go jako łańcuch znaków w wybranym przez Ciebie formacie, używając DateTimeFormatter.
    public static String formatter(LocalDateTime date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return date.format(formatter);
    }

    // Tworzenie Daty na Podstawie Timestampu: Stwórz funkcję, która przyjmuje jako argument timestamp (liczbę milisekund od 1970-01-01T00:00:00Z) i konwertuje go na obiekt LocalDateTime lub Instant.
    public static LocalDate makeDate(Timestamp timestamp){
        return timestamp.toLocalDateTime().toLocalDate();
    }

    // Znajdowanie Następnego/Poprzedniego Dnia Roboczego: Napisz program, który znajduje następny lub poprzedni dzień roboczy (bez weekendów) na podstawie obecnej daty.
    public static LocalDate nastepnyDzienRoboczy(LocalDate data) {
        do {
            data = data.plusDays(1);
        } while (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY);

        return data;
    }

    public static LocalDate poprzedniDzienRoboczy(LocalDate data) {
        do {
            data = data.minusDays(1);
        } while (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY);

        return data;
    }

    // Przesuwanie Daty i Czasu na Inne Strefy Czasowe: Zaimplementuj funkcję, która przesuwa datę i czas z jednej strefy czasowej do innej, korzystając z ZoneId i ZonedDateTime.
    public static ZonedDateTime przesuniecieStrefyCzasowej(LocalDateTime lokalnaDataCzas, ZoneId staraStrefa, ZoneId nowaStrefa) {
        ZonedDateTime staraZonedDateTime = ZonedDateTime.of(lokalnaDataCzas, staraStrefa);
        return staraZonedDateTime.withZoneSameInstant(nowaStrefa);
    }


    public static void main(String[] args) {
        //TODO 1) Obliczanie Różnicy Czasu:
        System.out.println(roznicaCzasu(LocalDateTime.of(2003, 03, 28, 12, 36), LocalDateTime.now()) + "\n");

        //TODO 2) Okres Między Datami:
        System.out.println(okres(LocalDate.of(2003, 03, 28), LocalDate.now()) + "\n");

        //TODO 3) Formatowanie Daty i Czasu:
        System.out.println(formatter(LocalDateTime.now()) + '\n');

        //TODO 4) Obliczanie Czasu Wykonania Operacji
        Instant startTime = Instant.now();
        roznicaCzasu(LocalDateTime.of(2003, 03, 28, 12, 36), LocalDateTime.now());
        okres(LocalDate.of(2003, 03, 28), LocalDate.now());
        formatter(LocalDateTime.now());
        Instant endTime = Instant.now();

        System.out.println(Duration.between(startTime, endTime));

        //TODO 5) Tworzenie Daty na Podstawie Timestampu:
        System.out.println(makeDate(new Timestamp(123456789)) + "\n");

        //TODO 6) Znajdowanie Następnego/Poprzedniego Dnia Roboczego:
        System.out.println(nastepnyDzienRoboczy(LocalDate.now()));
        System.out.println(poprzedniDzienRoboczy(LocalDate.now()) + "\n");

        //TODO 7) Znajdowanie Dnia Tygodnia dla Danej Daty
        System.out.println(LocalDate.now().getDayOfWeek() + "\n");

        //TODO 8) Przesuwanie Daty i Czasu na Inne Strefy Czasowe:
        System.out.println(przesuniecieStrefyCzasowej(LocalDateTime.now(), ZoneId.of("Europe/Warsaw"), ZoneId.of("America/Panama")));
    }
}
