package obiektowosc.podstawy.szkola;

import java.util.Map;
import java.util.Random;

public class DaneTestowe {

    public static void dodajDaneTestowe() {
        Random rand = new Random();

        String[] imionaNauczycieli = {
                "Jan", "Anna", "Marek", "Ewa", "Piotr", "Katarzyna", "Tomasz", "Alicja", "Wojciech", "Magdalena",
                "Karol", "Izabela", "Andrzej", "Monika", "Łukasz", "Beata", "Marcin", "Joanna", "Krzysztof", "Aleksandra",
                "Michał", "Natalia", "Tadeusz", "Małgorzata", "Adam", "Justyna", "Robert", "Kamila", "Mateusz", "Agata",
                "Bartosz", "Olga", "Jakub", "Patrycja", "Szymon", "Dominika", "Daniel", "Kinga", "Filip", "Oliwia"
        };

        String[] nazwiskaNauczycieli = {
                "Nowak", "Kowalski", "Wiśniewski", "Dąbrowski", "Lewandowski", "Wójcik", "Kamiński", "Kowalczyk", "Zieliński", "Szymański",
                "Wojciechowski", "Kowalczyk", "Szymański", "Nowak", "Kamińska", "Jankowski", "Zielińska", "Lewandowski", "Dąbrowski", "Wiśniewska",
                "Kaczmarek", "Zając", "Piotrowski", "Król", "Witkowski", "Kaczmarczyk", "Adamczyk", "Pawlak", "Walczak", "Sikora",
                "Nowicki", "Krawczyk", "Wrona", "Lis", "Grabowski", "Zawisza", "Malinowski", "Włodarczyk", "Kubiak", "Pawłowski"
        };

        String[] imionaUczniow = {
                "Adam", "Kasia", "Mateusz", "Natalia", "Michał", "Karolina", "Łukasz", "Patrycja", "Bartosz", "Monika",
                "Jakub", "Oliwia", "Szymon", "Zofia", "Kamil", "Nina", "Wojtek", "Anna", "Dawid", "Julia",
                "Piotrek", "Marta", "Kacper", "Kinga", "Daniel", "Alicja", "Marcin", "Weronika", "Filip", "Magda",
                "Błażej", "Zuzanna", "Miłosz", "Agata", "Marc", "Hanna", "Wiktor", "Ewa", "Oskar", "Emilia"
        };

        String[] nazwiskaUczniow = {
                "Wojciechowski", "Kowalczyk", "Szymański", "Nowak", "Kamińska", "Jankowski", "Zielińska", "Lewandowski", "Dąbrowski", "Wiśniewska",
                "Kaczmarek", "Zając", "Piotrowski", "Król", "Witkowski", "Kaczmarczyk", "Adamczyk", "Pawlak", "Walczak", "Sikora",
                "Nowicki", "Krawczyk", "Wrona", "Lis", "Grabowski", "Zawisza", "Malinowski", "Włodarczyk", "Kubiak", "Pawłowski",
                "Kowalewska", "Szewczyk", "Przybylski", "Kaczmarczyk", "Michalak", "Nowicka", "Woźniak", "Krawczyk", "Kubiak", "Król"
        };


        // Dodaj 3 szkoły
        Szkola szkola1 = new Szkola(1990, "Szkoła Podstawowa nr 1", "Dobra Szkoła", 1);
        Szkola szkola2 = new Szkola(2000, "Gimnazjum nr 3", "Super Gimnazjum", 2);
        Szkola szkola3 = new Szkola(2010, "Liceum Ogólnokształcące nr 5", "Elite Liceum", 3);

        for (int i = 0; i < 50; i++) {
            String imie = imionaNauczycieli[rand.nextInt(imionaNauczycieli.length)];
            String nazwisko = nazwiskaNauczycieli[rand.nextInt(nazwiskaNauczycieli.length)];
            String przedmiot = "Przedmiot" + (i + 1);
            Nauczyciel nauczyciel = new Nauczyciel(imie, nazwisko, "Adres", przedmiot);

            // Przypisz nauczyciela do losowych szkół (może uczyć w kilku szkołach)
            for (int j = 0; j < 3; j++) {
                Szkola szkola = getRandomSchool();
                szkola.dodajNauczyciela(nauczyciel);
            }
        }

        for (int i = 0; i < 450; i++) {
            String imie = imionaUczniow[rand.nextInt(imionaUczniow.length)];
            String nazwisko = nazwiskaUczniow[rand.nextInt(nazwiskaUczniow.length)];
            String numerIndeksu = "U" + (i + 1);
            Uczen uczen = new Uczen(imie, nazwisko, "Adres", numerIndeksu);

            // Przypisz ucznia do losowej szkoły (nie więcej niż 150 uczniów w jednej szkole)
            Szkola szkola = getRandomSchool();
            if (szkola.getUczniowie().size() < Szkola.getMinLiczbaUczniow()) {
                szkola.dodajUcznia(uczen);
            } else {
                // Jeśli w danej szkole jest już 150 uczniów, wybierz inną szkołę
                for (int j = 0; j < 3; j++) {
                    szkola = getRandomSchool();
                    if (szkola.getUczniowie().size() < Szkola.getMinLiczbaUczniow()) {
                        szkola.dodajUcznia(uczen);
                        break;
                    }
                }
            }
        }
    }
    private static Szkola getRandomSchool() {
        // Losowo wybierz jedną ze szkół
        int randomIndex = (int) (Math.random() * Szkola.getEkstensja().size());
        return Szkola.getEkstensja().get(randomIndex);
    }

    public static void main(String[] args) {
        dodajDaneTestowe();
    }
}
