package dalsze.podstawy.typy.generyczne.min.max;

// Stworz klase MinMax<T extends Comparable> ktora jako pola klasy pobiera instancje T max oraz T min
// Nastepnie stworz klase MinMaxService ktora bedzie miala statyczna metode MinMax<cos tutaj> getMinAndMax(List<cos tutaj> elements) zadaniem tej metody jest
// zwracanie mina i maxa z listy w tym jednym obiekcie wg naturalnego porządku jaki gwarantuje komparator, klasa MinMax powinna byc generyczna i metody getMin oraz
// getMax powinny zwraca instancje tego co bedzie na liscie elements, czyli jak przekazemy liste stringow to getMax ma zwraca String, getMin tez stringa a jak damy
// liste osob to ma getMax zwraca osobe, itp itd.

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> strings = List.of("B", "a", "c");
        MinMax<String> stringMinMax = MinMaxService.getMinAndMax(strings);
        System.out.println("String Min: " + stringMinMax.getMin());
        System.out.println("String Max: " + stringMinMax.getMax());

        List<Integer> numbers = List.of(2, 3, 1);
        MinMax<Integer> numberMinMax = MinMaxService.getMinAndMax(numbers);
        System.out.println("Number Min: " + numberMinMax.getMin());
        System.out.println("Number Max: " + numberMinMax.getMax());

        List<Oso>
    }
}
