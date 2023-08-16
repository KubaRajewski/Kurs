package obiektowosc.podstawy.muzyka;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Muzyka.dodaj20piosenek();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Muzyka \n");
        System.out.println("Zakończ program - Wprowadź napis koniec");
        System.out.println("Wyświetl wszystkie utwory - Wprowadź napis wszystko");
        System.out.println("Wyświetl utwory w ulubionych - Wprowadź napis ulubione ");
        System.out.println("Dodaj nowy utwór - wprowadź napis dodaj");
        System.out.println("Usuń utwór - wprowadź napis usun");
        System.out.println("Wyświetl utwory danego autora - wprowadź napis autor");
        System.out.println("Wyświetl utwory danego gatunku - wprowadź napis gatunek");
        System.out.println("Wyświetl utwory krótsze niż X minut - wprowadź napis krotsze");
        System.out.println("Wyświetl utwory dłuższe niż X minut - wprowadź napis dluzsze");
        System.out.println("Wyświetl utwory wydane po dacie X - wprowadź napis mlodsze");
        System.out.println("Wyświetl utwory wydane przed datą X - wprowadź napis starsze");


        while (true) {
            System.out.println("Wybierz opcję koniec/wszystko/ulubione/dodaj/usun/autor/gatunek/krotsze/dluzsze/mlodsze/starsze: ");
            String wybor = scanner.nextLine();
            wybor = wybor.toLowerCase();

            switch (wybor) {
                case "wszystko":
                    Muzyka.wyswietlEkstensje();
                    break;
                case "koniec":
                    System.out.println("Koniec programu");
                    return;
                case "ulubione":
                    Muzyka.wyswietlEkstensje();
                    break;
                case "dodaj":
                    System.out.println("Podaj tytuł utworu: ");
                    String tytul = scanner.nextLine();

                    System.out.println("Podaj autora utworu: ");
                    String autor = scanner.nextLine();

                    System.out.println("Podaj gatunek utworu: ");
                    String gatunek = scanner.nextLine();

                    System.out.println("Podaj czas trwania utworu: ");
                    int czasTrwania = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Podaj datę wydania utworu: ");
                    String dataWydania = scanner.nextLine();

                    System.out.println("Czy utwór jest w ulubionych? (tak/nie)");
                    String czyWUlubionych = scanner.nextLine();
                    czyWUlubionych.toLowerCase();
                    boolean ulubione = false;
                    if (czyWUlubionych.equals("tak")) {
                        ulubione = true;
                    } else if (czyWUlubionych.equals("nie")) {
                        ulubione = false;
                    } else {
                        System.out.println("Niepoprawny wybór, spróbuj ponownie");
                    }
                    Muzyka.dodajUtwor(tytul, autor, gatunek, czasTrwania, LocalDate.parse(dataWydania), ulubione);
                    System.out.println("Utwór został dodany");
                        break;
                    case "usun":
                        System.out.println("Podaj tytuł utworu: ");
                        String tytul2 = scanner.nextLine();
                        System.out.println("Podaj autora utworu: ");
                        String autor2 = scanner.nextLine();
                        Muzyka.usunUtwor(tytul2, autor2);
                        break;
                    case "autor":
                        System.out.println("Podaj autora: ");
                        String autor3 = scanner.nextLine();
                        System.out.println(Muzyka.utworyAutora(Muzyka.ekstensja, autor3));
                        break;
                    case "gatunek":
                        System.out.println("Podaj gatunek: ");
                        String gatunek2 = scanner.nextLine();
                        System.out.println(Muzyka.utworyGatunku(Muzyka.ekstensja, gatunek2));
                        break;
                    case "krótsze":
                        System.out.println("Podaj górny limit trwania utworu: ");
                        int czas = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(Muzyka.utworyKrotszeNiz(Muzyka.ekstensja, czas));
                        break;
                    case "dluzsze":
                        System.out.println("Podaj dolny limit trwania utworu: ");
                        int czas2 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println(Muzyka.utworyDluzszeNiz(Muzyka.ekstensja, czas2));
                        break;
                    case "starsze":
                        System.out.println("Podaj wiek utworu (w latach): ");
                        int wiek = scanner.nextInt();
                        scanner.nextLine();
                        Muzyka.wyswietlUtworyStarszeNiz(Muzyka.ekstensja, wiek);
                        break;

                    case "mlodsze":
                        System.out.println("Podaj wiek utworu (w latach): ");
                        int wiekMlodsze = scanner.nextInt();
                        scanner.nextLine();
                        Muzyka.wyswietlUtworyMlodszeNiz(Muzyka.ekstensja, wiekMlodsze);
                        break;
                    default:
                        System.out.println("Niepoprawny wybór, spróbuj ponownie");
            }
        }
    }
}
