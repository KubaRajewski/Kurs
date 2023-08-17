package obiektowosc.podstawy.muzyka;

import java.time.LocalDate;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Muzyka.dodajMuzykeDoTestow();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Zakończ program - Wprowadź napis koniec");
        System.out.println("Wyświetl wszystkie utwory - Wprowadź napis wszystko");
        System.out.println("Wyświetl konkretny utwor - Wprowadź napis konkretny");
        System.out.println("Wyświetl utwory w ulubionych - Wprowadź napis ulubione ");
        System.out.println("Dodaj nowy utwór - wprowadź napis dodaj");
        System.out.println("Usuń utwór - wprowadź napis usun");
        System.out.println("Wyświetl utwory danego autora - wprowadź napis autor");
        System.out.println("Wyświetl utwory danego gatunku - wprowadź napis gatunek");
        System.out.println("Wyświetl utwory krótsze niż X minut - wprowadź napis krotsze");
        System.out.println("Wyświetl utwory dłuższe niż X minut - wprowadź napis dluzsze");
        System.out.println("Wyświetl utwory wydane po dacie X - wprowadź napis mlodsze");
        System.out.println("Wyświetl utwory wydane przed datą X - wprowadź napis starsze");
        System.out.println();

        while (true) {
            System.out.println("Wybierz opcję: koniec/wszystko/konkretny/ulubione/dodaj/usun/autor/gatunek/krotsze/dluzsze/mlodsze/starsze: ");
            String wybor = scanner.nextLine();
            wybor = wybor.toLowerCase();

            switch (wybor) {
                case "koniec":
                    System.out.println("Koniec programu");
                    break;
                case "wszystko":
                    Muzyka.wyswietlEkstensje();
                    break;
                case "konkretny":
                    System.out.println("Podaj tytuł utworu: ");
                    String tytul = scanner.nextLine();

                    if (Muzyka.konkretnyUtwor(Muzyka.ekstensja, tytul) == null) {
                        System.out.println("Nie znaleziono utworu");
                    } else {
                        System.out.println(Muzyka.konkretnyUtwor(Muzyka.ekstensja, tytul));
                    }
                    break;
                case "ulubione":
                    System.out.println(Muzyka.utworyWUlubionych(Muzyka.ekstensja));
                    break;
                case "dodaj":
                    System.out.println("Podaj tytuł utworu: ");
                    String tytulDoDodania = scanner.nextLine();

                    System.out.println("Podaj autora utworu: ");
                    String autorDoDodania = scanner.nextLine();

                    System.out.println("Podaj gatunek utworu: ");
                    String gatunekDoDodania = scanner.nextLine();

                    System.out.println("Podaj czas trwania utworu: ");
                    int czasTrwaniaDoDodania = scanner.nextInt();
                    scanner.nextLine();

                    System.out.println("Podaj datę wydania utworu: ");
                    String dataWydaniaDoDodania = scanner.nextLine();

                    System.out.println("Czy utwór jest w ulubionych? (tak/nie)");
                    String czyWUlubionych = scanner.nextLine();
                    czyWUlubionych.toLowerCase();
                    boolean ulubioneDoDodania = false;
                    if (czyWUlubionych.equals("tak")) {
                        ulubioneDoDodania = true;
                    } else if (czyWUlubionych.equals("nie")) {
                        ulubioneDoDodania = false;
                    } else {
                        System.out.println("Niepoprawny wybór, spróbuj ponownie");
                    }
                    Muzyka.dodajUtwor(tytulDoDodania, autorDoDodania, gatunekDoDodania, czasTrwaniaDoDodania, LocalDate.parse(dataWydaniaDoDodania), ulubioneDoDodania);
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
                case "krotsze":
                    System.out.println("Podaj górny limit trwania utworu (w minutach): ");
                    double czasGornyLimit = scanner.nextDouble();
                    scanner.nextLine();
                    if (Muzyka.utworyKrotszeNiz(Muzyka.ekstensja, czasGornyLimit).isEmpty()) {
                        System.out.println("Nie znaleziono utworu");
                    } else {
                        System.out.println("utwory krótsze niż " + czasGornyLimit + "minuty");
                        System.out.println(Muzyka.utworyKrotszeNiz(Muzyka.ekstensja, czasGornyLimit));
                    }
                    break;
                case "dluzsze":
                    System.out.println("Podaj dolny limit trwania utworu (w minutach): ");
                    double czasDolnyLimit = scanner.nextDouble();
                    scanner.nextLine();
                    if (Muzyka.utworyDluzszeNiz(Muzyka.ekstensja, czasDolnyLimit).isEmpty()) {
                        System.out.println("Nie znaleziono utworów");
                    } else {
                        System.out.println("utwory dłuższe niż " + czasDolnyLimit + "minuty");
                        System.out.println(Muzyka.utworyDluzszeNiz(Muzyka.ekstensja, czasDolnyLimit));
                    }
                    break;
                case "starsze":
                    System.out.println("Podaj wiek utworu (w latach): ");
                    int wiekStarsze = scanner.nextInt();
                    scanner.nextLine();
                    if (Muzyka.wyswietlUtworyStarszeNiz(Muzyka.ekstensja, wiekStarsze).isEmpty()){
                        System.out.println("Nie znaleziono utworow");
                    } else {
                        System.out.println("Utwory starsze niż " + wiekStarsze + " lat:");
                        System.out.println(Muzyka.wyswietlUtworyStarszeNiz(Muzyka.ekstensja, wiekStarsze));
                    }
                    break;
                case "mlodsze":
                    System.out.println("Podaj wiek utworu (w latach): ");
                    int wiekMlodsze = scanner.nextInt();
                    scanner.nextLine();
                    if (Muzyka.wyswietlUtworyMlodszeNiz(Muzyka.ekstensja, wiekMlodsze).isEmpty()) {
                        System.out.println("Nie znaleziono utworów");
                    } else {
                        System.out.println("Utwory młodsze niż " + wiekMlodsze + " lat:");
                        System.out.println(Muzyka.wyswietlUtworyMlodszeNiz(Muzyka.ekstensja, wiekMlodsze));
                    }
                    break;
                default:
                    System.out.println("Niepoprawny wybór, spróbuj ponownie");
            }
        }
    }
}
