package dalsze.podstawy.daty.dodatkowe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
    // Parser ze stringa na localdate
    public static LocalDate parsujDate(String str) {
        Pattern dataPattern = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})$");
        Matcher matcher = dataPattern.matcher(str);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Nie poprawny format daty");
        }

        int rok = Integer.parseInt(matcher.group("rok"));
        int miesiac = Integer.parseInt(matcher.group("miesiac"));
        int dzien = Integer.parseInt(matcher.group("dzien"));

        return LocalDate.of(rok, miesiac, dzien);
    }

    // Parser ze Stringa na localDateTime
    public static LocalDateTime parsujDateCzas(String str){
        Pattern dataPattern = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})\\s(?<godzina>[01][0-9]|2[0-3]):(?<minuta>[0-5][0-9])$");
        Matcher matcher = dataPattern.matcher(str);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Nie poprawny format daty");
        }

        int rok = Integer.parseInt(matcher.group("rok"));
        int miesiac = Integer.parseInt(matcher.group("miesiac"));
        int dzien = Integer.parseInt(matcher.group("dzien"));
        int godzina = Integer.parseInt(matcher.group("godzina"));
        int minuta = Integer.parseInt(matcher.group("minuta"));

        return LocalDateTime.of(rok, miesiac, dzien, godzina, minuta);
    }

    public static Object parseDate(String str) {
        Pattern dateTimePattern = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})\\s(?<godzina>[01][0-9]|2[0-3]):(?<minuta>[0-5][0-9])$");
        Pattern datePattern = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})$");

        Matcher dateTimeMatcher = dateTimePattern.matcher(str);
        Matcher dateMatcher = datePattern.matcher(str);

        if (dateTimeMatcher.matches()) {
            int rok = Integer.parseInt(dateTimeMatcher.group("rok"));
            int miesiac = Integer.parseInt(dateTimeMatcher.group("miesiac"));
            int dzien = Integer.parseInt(dateTimeMatcher.group("dzien"));
            int godzina = Integer.parseInt(dateTimeMatcher.group("godzina"));
            int minuta = Integer.parseInt(dateTimeMatcher.group("minuta"));

            return LocalDateTime.of(rok, miesiac, dzien, godzina, minuta);
        } else if (dateMatcher.matches()) {
            int rok = Integer.parseInt(dateMatcher.group("rok"));
            int miesiac = Integer.parseInt(dateMatcher.group("miesiac"));
            int dzien = Integer.parseInt(dateMatcher.group("dzien"));

            return LocalDate.of(rok, miesiac, dzien);
        } else {
            throw new IllegalArgumentException("Niepoprawny format daty");
        }
    }

    public static void main(String[] args) {
        System.out.println(parsujDate("28-03-2003").getYear());
        System.out.println(parsujDate("28-03-2003").getMonth());
        System.out.println(parsujDate("28-03-2003").getDayOfMonth() + "\n");

        System.out.println(parsujDateCzas("28-03-2003 12:36").getYear());
        System.out.println(parsujDateCzas("28-03-2003 12:36").getMonth());
        System.out.println(parsujDateCzas("28-03-2003 12:36").getDayOfMonth());
        System.out.println(parsujDateCzas("28-03-2003 12:36").getHour());
        System.out.println(parsujDateCzas("28-03-2003 12:36").getMinute() + "\n");

        String dateTimeString = "28-03-2003 12:36";
        String dateString = "28-03-2003";

        Object parsedDateTime = parseDate(dateTimeString);
        Object parsedDate = parseDate(dateString);

        if (parsedDateTime instanceof LocalDateTime) {
            LocalDateTime dateTime = (LocalDateTime) parsedDateTime;
            System.out.println("Parsed LocalDateTime: " + dateTime);
        } else if (parsedDate instanceof LocalDate) {
            LocalDate date = (LocalDate) parsedDate;
            System.out.println("Parsed LocalDate: " + date);
        }
    }
}
