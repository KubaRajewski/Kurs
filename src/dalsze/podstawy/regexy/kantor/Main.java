package dalsze.podstawy.regexy.kantor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        //napisz metode zamien(int ilosc, String waluta) ktora działa jak kantor, pokazuje ile mozesz kupic danej waluty za podana liczbe euro
        //czyli np zamien(100, "PLN") powinno wypluc 439,79

        String kursy = "{\"rates\":{\"CAD\":1.5563,\"HKD\":9.1212,\"ISK\":162.6,\"PHP\":57.324,\"DKK\":7.4441,\"HUF\":350.68,\"CZK\":26.083,\"AUD\":1.6442,"
                + "\"RON\":4.8405,\"SEK\":10.363,\"IDR\":17383.99,\"INR\":88.198,\"BRL\":6.5908,\"RUB\":87.735,\"HRK\":7.5243,\"JPY\":124.53,\"THB\":37.161,"
                + "\"CHF\":1.0744,\"SGD\":1.6131,\"PLN\":4.3979,\"BGN\":1.9558,\"TRY\":8.5925,\"CNY\":8.1483,\"NOK\":10.5913,\"NZD\":1.8045,\"ZAR\":20.2977,"
                + "\"USD\":1.1769,\"MXN\":26.066,\"ILS\":4.0029,\"GBP\":0.89755,\"KRW\":1403.15,\"MYR\":4.9194},\"base\":\"EUR\",\"date\":\"2020-08-21\"}";

        System.out.println(zamien(100, "PLN", kursy));
    }

    public static double zamien(int ilosc, String waluta, String kursy) {
        if (ilosc < 0) {
            throw new IllegalArgumentException("ilość nie może być ujemna");
        } else if (kursy.isEmpty()){
            throw new IllegalArgumentException("Brak kursów do porówanania");
        }

        Pattern pattern = Pattern.compile("\"" + waluta + "\":(?<wartosc>\\d+\\.\\d+)");
        Matcher matcher = pattern.matcher(kursy);

        if (matcher.find()) {
            double kursWymiany = Double.parseDouble(matcher.group("wartosc"));
            double wynik = ilosc * kursWymiany;
            return Math.round(wynik * 100) / 100.0;
        } else {
            throw new IllegalArgumentException("nie znaleziono waluty do wymiany");
        }
    }
}
