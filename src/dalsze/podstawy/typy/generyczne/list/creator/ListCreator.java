package dalsze.podstawy.typy.generyczne.list.creator;

import java.util.ArrayList;
import java.util.List;

public class ListCreator<T> {
    private List<T> list;

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public static <S> ListCreator<S> collectFrom(List<S> list){
        return new ListCreator<>(list);
    }

    public ListCreator<T> when(Selector<T> selector){
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if (selector.select(t)){
                newList.add(t);
            }
        }
        this.list = newList;
        return this;
    }

    public <S> List<S> mapEvery(Mapper<T, S> mapper) {
        List<S> resultList = new ArrayList<>();
        for (T item : list) {
            resultList.add(mapper.map(item));
        }
        return resultList;
    }
}

