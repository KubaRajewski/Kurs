package dalsze.podstawy.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Pattern compiledPattern = Pattern.compile("Tomek");

        Matcher matcher = compiledPattern.matcher("Tomek ma dlugie wlosy");
        System.out.println(matcher.find());
        System.out.println(matcher.matches());

        // znak ? - element bezposrednio przed nim jest opcjonalny
        Pattern pattern = Pattern.compile("Tom?ek");
        System.out.println(pattern.matcher("Tomek").matches());
        System.out.println(pattern.matcher("Toek").matches());
        System.out.println(pattern.matcher("Tomekk").matches());
        System.out.println();

        // znak * - zero lub wiecej razy
        Pattern pattern1 = Pattern.compile("Tome*k");
        System.out.println(pattern1.matcher("Tomeeeeeek").matches());
        System.out.println(pattern1.matcher("Tomk").matches());
        System.out.println();

        // Znak + jeden lub wiecej razy
        Pattern pattern2 = Pattern.compile("Tome+k");
        System.out.println(pattern2.matcher("Tomeeeeeek").matches());
        System.out.println(pattern2.matcher("Tomk").matches());
        System.out.println();

        // znak . wymienia sie na dowolny symbol
        Pattern pattern3 = Pattern.compile("Tome.k");
        System.out.println(pattern3.matcher("Tomlk").matches());
        System.out.println(pattern3.matcher("Tom/k").matches());

        Pattern pattern4 = Pattern.compile("gmail\\.com");
        System.out.println(pattern4.matcher("gmail#com").matches());

        //{x} – oznacza że element poprzedzający musi wystąpić dokładnie x razy
        Pattern pattern5 = Pattern.compile("Tome{4}k");
        System.out.println(pattern5.matcher("Tomeeeek").matches());
        System.out.println(pattern5.matcher("Tom/k").matches());

        //{x,} – oznacza, że element poprzedzający musi wystąpić co najmniej x razy

        //{x,y} – oznacza, że element poprzedzający musi wystąpić od x do y razy


		   /*
        klasy - grupy symboli, oznaczane za pomoca nawiasow [ ]
        [A-E] - jakakolwiek wielka litera od A do E
        [h-u] - jakakolwiek mala literka od h do u
        [A-Cg-z] - jakakolwiek wielka litera od A do C lub mala od go do z
        [H-g] - jajakolwiek wielka litera od H do Z lub od a do g
        [3-8] - jakakolwiek licba od 3 do 8
        [^a-c] - cokolwiek poza przedzialem od a do c
     */
        Pattern pattern6 = Pattern.compile("[a-f]+");
        System.out.println(pattern6.matcher("abfdac").matches());

        /* klasy predefiniowane
         *
         * \d - jakakolwiek cyfra
         * \D - zaprzeczenie grupy \d
         * \w - znaki uzywane w slowach [A-z0-9_]
         * \W - zaprzeczenie grupy \w
         * \s - whitespacy
         * \S - zaprzeczenie \s
         */
        Pattern pattern7 = Pattern.compile("\\d+");
        System.out.println(pattern7.matcher("4527982347").matches());

        //grupy oznaczamy ( ) i tworzymy je po to aby moc sie latwo odwolywac do przechwyconcyh wartosci
        // | - alternatywa
        // a|b a lub b
        // nazywanie grup (?<nazwa>...)
        Pattern pattern8 = Pattern.compile("(?<imie>Ala|Ola) ma (?<zwierze>kota|psa)");
        Matcher matcher8 = pattern8.matcher("Ola ma psa");
        matcher8.matches();
        System.out.println(matcher8.group(1));
        System.out.println(matcher8.group(2));

        System.out.println(matcher8.group("imie"));
        System.out.println(matcher8.group("zwierze"));

        // stwórz pattern na imie
        // Tomek
        // Tomek Bartek
        Pattern imie = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)?$");
        System.out.println(imie.matcher("Tomek").matches());
        System.out.println(imie.matcher("Tomek Bartek").matches());
        System.out.println();

        // stwórz pattern na imie i nazwisko
        // Tomek Kowalski
        // Tomek Kowalski-Jankowski
        // Tomek Kowalski Jankowski
        Pattern imieINazwisko = Pattern.compile("^[A-Z][a-z]+( [A-Z][a-z]+)?( |-)[A-Z][a-z]+$");
        System.out.println(imieINazwisko.matcher("Tomek Kowalski").matches());
        System.out.println(imieINazwisko.matcher("Tomek Kowalski-Jankowski").matches());
        System.out.println(imieINazwisko.matcher("Tomek Kowalski Jankowski").matches());
        System.out.println();

        //napisz pattern na datę w postaci xx-xx-xxxx
        Pattern data = Pattern.compile("^(0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-(\\d{4})$");
        System.out.println(data.matcher("12-12-2019").matches());
        System.out.println(data.matcher("12-13-2039").matches());
        System.out.println();

        //napisz pattern na maila
        Pattern mail = Pattern.compile("^[a-zA-Z0-9]+([_.-]?[a-zA-Z0-9]+)*@[a-zA-Z0-9]+([_.-][a-zA-Z0-9]+)*\\.[a-zA-Z0-9]+([_.-][a-zA-Z0-9]+)*$");

        System.out.println(mail.matcher("kuba.rajewski0@gmail.com").matches());
        System.out.println(mail.matcher("kuba.rajewski..$@gmail.com").matches());
        System.out.println(mail.matcher("gmail.com").matches());
        System.out.println(mail.matcher("gmail.com@gmail.com").matches());
        System.out.println();

        /*
         * Sprawdz czy liczba  podana przez użytkownika ma poprawny format. Na przykład liczba 123,2341515132135 czy
         * -10 są poprawne ale 18-12 czy 123, już nie,
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe: ");
        String liczba = scanner.nextLine();
        Pattern liczbaPattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        System.out.println(liczbaPattern.matcher(liczba).matches());
        System.out.println();

        /*
         * sprawdz czy numer domu jest w formacie numer\numer.
         * Poprawnym numerem jest 123\2A, 24B\3 czy 12\5, ale już numer abc\cba nie,
         */
        Pattern numerDomu= Pattern.compile("^\\d+[A-Z]?\\\\\\d+[A-Z]?$");
        System.out.println(numerDomu.matcher("123\\2A").matches());
        System.out.println(numerDomu.matcher("24B\\3").matches());
        System.out.println(numerDomu.matcher("12\\5").matches());
        System.out.println(numerDomu.matcher("abc\\cba").matches());
        System.out.println();


        //napisz pattern na miasto np Warszawa, Bielsko-Biala, Zielona Gora
        Pattern miasto = Pattern.compile("[A-Z][a-z]+(( |-)[A-Z][a-z]*)?");
        System.out.println(miasto.matcher("Warszawa").matches());
        System.out.println(miasto.matcher("Bielsko-Biala").matches());
        System.out.println(miasto.matcher("Zielona Gora").matches());
        System.out.println();


        //stworz pattern na date z nazwami uzywjaac grup + nazywajac je

        Pattern data2 = Pattern.compile("^(?<dzien>0[1-9]|[12][0-9]|3[01])-(?<miesiac>0[1-9]|1[0-2])-(?<rok>\\d{4})$");
        Matcher matcher9 = data2.matcher("12-12-2019");
        matcher9.matches();
        System.out.println(matcher9.group("dzien"));
        System.out.println(matcher9.group("miesiac"));
        System.out.println(matcher9.group("rok"));



        //napisz metode zamien(int ilosc, String waluta) ktora działa jak kantor, pokazuje ile mozesz kupic danej waluty za podana liczbe euro
        //czyli np zamien(100, "PLN") powinno wypluc 439,79

        String kursy = "{\"rates\":{\"CAD\":1.5563,\"HKD\":9.1212,\"ISK\":162.6,\"PHP\":57.324,\"DKK\":7.4441,\"HUF\":350.68,\"CZK\":26.083,\"AUD\":1.6442,"
                + "\"RON\":4.8405,\"SEK\":10.363,\"IDR\":17383.99,\"INR\":88.198,\"BRL\":6.5908,\"RUB\":87.735,\"HRK\":7.5243,\"JPY\":124.53,\"THB\":37.161,"
                + "\"CHF\":1.0744,\"SGD\":1.6131,\"PLN\":4.3979,\"BGN\":1.9558,\"TRY\":8.5925,\"CNY\":8.1483,\"NOK\":10.5913,\"NZD\":1.8045,\"ZAR\":20.2977,"
                + "\"USD\":1.1769,\"MXN\":26.066,\"ILS\":4.0029,\"GBP\":0.89755,\"KRW\":1403.15,\"MYR\":4.9194},\"base\":\"EUR\",\"date\":\"2020-08-21\"}";
    }
}
