package dalsze.podstawy.typy.generyczne.list.creator;

import java.util.ArrayList;
import java.util.List;

//  collectFrom(list1).when(selektor).mapEvery(mapper)

public class ListCreator<T> {
    private List<T> list = new ArrayList<>();

    public ListCreator(List<T> list) {
        this.list = list;
    }

    public List<T> getList() {
        return list;
    }

    public static <S> ListCreator<S> collectFrom(List<S> list){
        return new ListCreator<>(list);
    }
}
