package LuthfiMisbachulMunirJSleepFN;

import javax.lang.model.type.NullType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Algorithm {
    public static <T> int count(Iterator<T> iterate, T data){
        int loop = 0;
        while (iterate.hasNext()){
            if (iterate.next().equals(data)){
                loop++;
            }
        }
        return loop;
    }

    public static <T> int count(T[] arr, T data){
        return count(Arrays.asList(arr).iterator(), data);
    }

    public static <T> int count(Iterable<T> iterate, Predicate<T> predicate){
        int loop = 0;
        for (T t:iterate){
            if(predicate.predicate(t)){
                loop++;
            }
        }
        return loop;
    }

    public static <T> int count(T[] arr, Predicate<T> pred){
        return count(Arrays.asList(arr).iterator(), pred);
    }

    public static <T> int count(Iterator<T> iterate, Predicate <T> pred){
        int loop = 0;
        while (iterate.hasNext()){
            if (pred.predicate(iterate.next())){
                loop++;
            }
        }
        return loop;
    }

    public static <T> int count(Iterable<T> iterate, T val){
        return count(iterate.iterator(), val);
    }

    public static <T> boolean exist(Iterable<T> iterate, T val){
        final Iterator<T> key = iterate.iterator();
        return exist(key, val);
    }

    public static <T> boolean exist(Iterable<T> iterate, Predicate<T> temp){
        final Iterator<T> key = iterate.iterator();
        return exist(key, temp);
    }

    public static <T> boolean exist(T[] arr, Predicate<T> temp){
        final Iterator<T> key = Arrays.stream(arr).iterator();
        return exist(key, temp);
    }

    public static <T> boolean exist(T[] arr, T val){
        final Iterator<T> key = Arrays.stream(arr).iterator();
        return exist(key, val);
    }

    public static <T> boolean exist(Iterator<T> iterate, T pred){
        final Predicate<T> temp = pred::equals;
        return exist(iterate, temp);
    }

    public static <T> boolean exist(Iterator<T> iterate, Predicate<T> pred){
        while(iterate.hasNext()){
            T temp = iterate.next();
            if(pred.predicate(temp)){
                return true;
            }
        }
        return false;
    }

    public static <T> T find(T[] arr, Predicate<T> temp){
        for (T t : arr) {
            if(temp.predicate(t)){
                return t;
            }
        }
        return null;
    }

    public static <T> T find(Iterator<T> iterate, Predicate<T> tPredicate){
        while (iterate.hasNext()){
            T temp = iterate.next();
            if(tPredicate.predicate(temp)) {
                return temp;
            }
        }
        return null;
    }

    public static <T> T find(T[] arr, T val){
        final Predicate<T> temp = val::equals;
        return find(arr, temp);
    }

    public static <T> T find(Iterable<T> iterate, T data){
        final Iterator<T> temp = iterate.iterator();
        return find(temp, data);
    }

    public static <T> T find(Iterator<T> iterate, T data){
        final Predicate<T> temp =data::equals;
        return find(iterate,temp);
    }

    public static <T> T find(Iterable<T> iterate, Predicate<T> data){
        final Iterator<T> temp = iterate.iterator();
        return find(temp,data);
    }

    public static <T> List<T> collect(Iterable<T> iterate, T data){
        final Iterable<T> temp = (Iterable<T>) iterate.iterator();
        return collect(temp, data);
    }

    public static <T> List<T> collect(Iterable<T> iterate, Predicate<T> data){
        final Iterable<T> temp = (Iterable<T>) iterate.iterator();
        return collect(temp, data);
    }

    public static <T> List<T> collect(T[] arr, T data){
        final Iterator<T> temp = Arrays.stream(arr).iterator();
        return collect(temp, data);
    }

    public static <T> List<T> collect(Iterator<T> iterate, T data){
        final Predicate<T> pred = data::equals;
        return collect(iterate, data);
    }

    public static <T> List<T> collect(T[] arr, Predicate<T> data){
        final Iterator<T> temp = Arrays.stream(arr).iterator();
        return collect(temp, data);
    }

    public static <T> List<T> collect(Iterator<T> iterate, Predicate<T> data){
        int num = 0;
        while(iterate.hasNext()){
            num++;
        }
        final Predicate<T> pred = data::equals;
        return collect(iterate, data);
    }

    public static <T> List<T> paginate(T[] arr, int page, int pageSize, Predicate<T> data){
        int i = 0;
        int occur = 0;
        int first = page * pageSize;
        List<T> List = new ArrayList<>(pageSize);

        for (; i < arr.length && occur < first; ++i) {
            if (data.predicate(arr[i])) {
                ++occur;
            }
        }
        for (int j = 0; j < arr.length && List.size() < pageSize; ++j) {
            if (data.predicate(arr[j])) {
                List.add(arr[j]);
            }
        }
        return List;
    }

    public static <T> List<T> paginate(Iterator<T> iterate, int page, int pageSize, Predicate<T> data){
        int first = page * pageSize;
        int last = pageSize * (page + 1) - 1;
        int loop = 0;

        List<T> list = new ArrayList<>();

        while (iterate.hasNext() == true) {
            T going = iterate.next();
            if ((loop >= first) && (data.predicate(going)) && (loop <= last)) {
                list.add(going);
            }
            loop++;
        }
        return list;
    }

    public static <T> List<T> paginate(Iterable<T> iterate, int page, int pageSize, Predicate<T> data){
        final Iterator<T> temp = iterate.iterator();
        return paginate(temp, page, pageSize, data);
    }
}


