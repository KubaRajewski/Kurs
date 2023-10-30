package dalsze.podstawy.typy.generyczne.list.creator;

import java.util.Arrays;
import java.util.List;
import dalsze.podstawy.typy.generyczne.list.creator.ListCreator;
import dalsze.podstawy.typy.generyczne.list.creator.Selector;
import dalsze.podstawy.typy.generyczne.list.creator.Mapper;

import static dalsze.podstawy.typy.generyczne.list.creator.ListCreator.collectFrom;

// https://sdkp.pjwstk.edu.pl/html/staskshtml/S_GENERICS/S_GENERICS.html

//	napisz metode ktora jako argument pobiera liste obiektow typu A, jakis mapper i zwraca liste obiektow typu B
//	przykladowe uzycie:
//
//	List<LocalDate> dates = transform(Arrays.asList("2020-01-01", "2015-05-05"), tu jakis mapper);
//	albo
//	List<Integer> numbers = transform(Arrays.asList("1","2","3"), tu jakis mapper);

//  collectFrom(list1).when(selektor).mapEvery(mapper)

public class Main {
    public Main() {
        List<Integer> src1 = Arrays.asList(1, 7, 9, 11, 12);
        System.out.println(test1(src1));

        List<String> src2 = Arrays.asList("a", "zzzz", "vvvvvvv");
        System.out.println(test2(src2));
    }

    public List<Integer> test1(List<Integer> src) {
        Selector<Integer> sel = new Selector<Integer>() {
            @Override
            public boolean select(Integer item) {
                return item < 10;
            }
        };

        Mapper<Integer, Integer> map = new Mapper<Integer, Integer>() {
            @Override
            public Integer map(Integer item) {
                return item + 10;
            }
        };

        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public List<Integer> test2(List<String> src) {
        Selector<String> sel = new Selector<String>() {
            @Override
            public boolean select(String item) {
                return item.length() > 3;
            }
        };

        Mapper<String, Integer> map = new Mapper<String, Integer>() {
            @Override
            public Integer map(String item) {
                return item.length() + 10;
            }
        };

        return ListCreator.collectFrom(src).when(sel).mapEvery(map);
    }

    public static void main(String[] args) {
        new Main();
    }
}

