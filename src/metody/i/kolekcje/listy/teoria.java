package metody.i.kolekcje.listy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class teoria {
    public static void main(String[] args) {
        /*
		 * ArrayList
		 * 1) Przechowuje elementy w dynamicznej tablicy - nie podajemy jej rozmiaru
		 * 2) Dane zapisywane w pamieci znajduja sie obok siebie
		   3) Operacja wyjecia jest szybsza niz na LinkedList, ale usuniecie jest wolniejsze
		 */

        /*LinkedList
         * 1) Przechowuje wewnetrznie elementy opakowane w obiekty wskazujace na element poprzedni i nastepny
         * 2) Dane w pamieci jej sa zapisywane rozstrzelone
         * 3) Patrz punkt 3 przy ArrayList

         */

        // tego nie uzywamy
        List niegeneryczna = new ArrayList();
        niegeneryczna.add("str");
        niegeneryczna.add(1);
        niegeneryczna.add(true);


        System.out.println("Niegeneryczna lista: ");
        System.out.println(niegeneryczna);
        System.out.println();

        List<String> imiona = new ArrayList<>();


        System.out.println("add");
        // metoda add() - metoda ktora dodaje cos do kolekcji
        imiona.add("Tomek");
        imiona.add("Karolina");
        imiona.add("Piotr");

        System.out.println(imiona);
        System.out.println();

        System.out.println("addAll");
        // metoda addAll() - metoda ktora dodaje kolekcje do kolekcji
        // Arrays.asList() tworzy z elementow oddzielonych przecinkami kolekcję
        imiona.addAll(Arrays.asList("Grzegorz", "Ania", "Tomek"));
        System.out.println(imiona);
        System.out.println();

        // metoda size() - rozmiar kolekcji
        System.out.println("size");
        System.out.println("Rozmiar kolekcji: " + imiona.size());
        System.out.println();

        // metoda get(i) - zwraca element o indeksie i
        System.out.println("get");
        System.out.println("Element pierwszy: " + imiona.get(0));
        System.out.println();

        // wypisanie kolekcji za pomoca zwyklej petli
        System.out.println("for");
        for (int i = 0; i < imiona.size(); i++) {
            System.out.print(imiona.get(i) + " ");
        }

        System.out.println();
        System.out.println();

        // wypisanie kolekcji za pomoca for eacha
        System.out.println("for each");
        for (String imie : imiona) {
            System.out.print(imie + " ");
        }
        System.out.println();
        System.out.println();

        // metoda remove(x) - usuniecie z kolekcji elementu x badz indeksu x
        System.out.println("remove");
        imiona.remove(0);
        System.out.println(imiona);

        imiona.remove("Piotr");
        System.out.println(imiona);
        //	list.remove(Integer.valueOf(2));
        System.out.println();

        System.out.println("removeAll");
        // metode removeAll() - usuniecie z kolekcji innej kolekcji
        imiona.removeAll(Arrays.asList("Ania", "Tomek"));
        System.out.println(imiona);

        imiona.addAll(Arrays.asList("Piotr", "Ania", "Karolina", "Tomek"));

        System.out.println(imiona);
        System.out.println();

        System.out.println("contains");
        // metoda contains(x) - zwraca true jesli element x znajduje sie w kolekcji
        System.out.println("Czy Klaudia jest w kolekcji? " + imiona.contains("Klaudia"));
        System.out.println("Czy Tomek jest w kolekcji? " + imiona.contains("Tomek"));

        System.out.println(imiona);
        System.out.println();


        System.out.println("isEmpty");
        // metoda isEmpty() - zwraca true jesli kolekcja jest pusta
        System.out.println("Czy kolekcja jest pusta? " + imiona.isEmpty());
        System.out.println();

        System.out.println("indexOf");
        // metoda indexOf(x) - zwraca indeks pierwszego wystapienia elementu x
        // jesli elementu x nie ma w kolekcji to zwraca -1
        System.out.println("Indeks pierwszego wystapienia Tomka: " + imiona.indexOf("Tomek"));
        System.out.println();


        System.out.println("lastIndexOf");
        // metoda lastIndexOf(x) - zwraca indeks ostatniego wystapienia elementu x
        // jesli elementu nie ma w kolekcji to zwraca -1
        System.out.println("Indeks ostatniego wystapienia Tomka: " + imiona.lastIndexOf("Tomek"));
        System.out.println();

        System.out.println("set");
        // metoda set(indeks, element) - zastepuje element po podanym indeksie innym
        // elementem
        imiona.set(5, "Monikaaaaaaaa");
        System.out.println(imiona);
        System.out.println();


        System.out.println("subList");
        // metoda sublist(x,y) zwraca podliste od indeksu podanego jako pierwszy
        // parametr uwzgledniajac go
        // do indeksu drugiego podanego jako parametr nieuwzgledniajac go
        System.out.println(imiona.subList(1, 4));
        System.out.println();


        System.out.println("clear");
        // clear() - metoda czyszczaca kolekcje
        // listaImion.clear();
        System.out.println(imiona);
        System.out.println();
    }
}
