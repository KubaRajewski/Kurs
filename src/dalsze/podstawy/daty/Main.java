package dalsze.podstawy.daty;

import java.time.LocalDate;
import java.time.Period;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalDate date1 = LocalDate.of(2003, 3, 28);

        Period period = Period.between(date1, date);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();

        System.out.println(years + " lat, " + months + " miesięcy, " + days + " dni");
    }

    public void parser(String date) {

        String[] parts = date.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int day = Integer.parseInt(parts[2]);

        LocalDate localDate = LocalDate.of(year, month, day);
    }
}
