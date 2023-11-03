package dalsze.podstawy.typy.generyczne.list.creator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://sdkp.pjwstk.edu.pl/html/staskshtml/S_GENERICS/S_GENERICS.html

//	napisz metode ktora jako argument pobiera liste obiektow typu A, jakis mapper i zwraca liste obiektow typu B
//	przykladowe uzycie:
//
//	List<LocalDate> dates = transform(Arrays.asList("2020-01-01", "2015-05-05"), tu jakis mapper);
//	albo
//	List<Integer> numbers = transform(Arrays.asList("1","2","3"), tu jakis mapper);

public class Main {
    public Main() {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
        System.out.println(test1(src1));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");
        System.out.println(test2(src2) + "\n");

        List<java.time.LocalDate> dates = transform(
                Arrays.asList("2020-01-01", "2015-05-05"),
                date -> java.time.LocalDate.parse(date)
        );
        System.out.println(dates);

        List<Integer> numbers = transform(
                Arrays.asList("1", "2", "3"),
                Integer::parseInt
        );
        System.out.println(numbers);
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = item -> item < 10;  // wybiera liczby parzyste
        Mapper<Integer, Integer> map = item -> item + 10;  // dodaje 10 do każdego elementu

        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public List<Integer> test2(List<String> src) {
        Selector<String> sel = item -> item.length() > 3;
        Mapper<String, Integer> map = item -> item.length() + 10;

        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public static <T, S> List<S> transform(List<T> sourceList, Mapper<T, S> mapper) {
        List<S> resultList = new ArrayList<>();
        for (T item : sourceList) {
            resultList.add(mapper.map(item));
        }
        return resultList;
    }

    public static void main(String[] args) {
        new Main();
    }
}

