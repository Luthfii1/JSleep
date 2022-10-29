package LuthfiMisbachulMunirJSleepFN;

import java.util.HashMap;

public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable() {
        Integer counter = mapCounter.get(getClass());
        if (counter == null){
            counter =  0;
        }
        else{
            counter +=1;
        }
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public static <T extends Serializable> Integer setClosingId(Class<T> clazz, int id) { return mapCounter.put(clazz, id); }

    public static <T extends Serializable> Integer getClosingId(Class<T> clazz) { return mapCounter.get(clazz); }

    public boolean equals(Object other)
    {
        return other instanceof Serializable && ((Serializable) other).id == id;
    }

    public boolean equals(Serializable other)
    {
        return other.id == id;
    }

    public int compareTo(Serializable other)
    {
        return Integer.compare(this.id, other.id);
    }
}
/*
public class Serializable
{
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<Class<?>, Integer>();

    protected Serializable()
    {
        Integer sum;
        if (mapCounter.containsKey(this.getClass())){
            sum = mapCounter.get(this.getClass());
            sum++;
        } else {
            sum = mapCounter.get(this.getClass());
            sum = 0;
        }
        this.id = sum;
        mapCounter.put(this.getClass(), this.id);
    }

    public int compareTo(Serializable save){
        return ((Integer)this.id).compareTo(save.id);
    }

    public boolean equals(Object saveObj){
        if (saveObj instanceof Serializable && ((Serializable) saveObj).id == this.id){
            return true;
        } else
            return false;
    }

    public boolean equals(Serializable saveObj){
        if(this.id == saveObj.id){
            return true;
        } else
            return false;
    }

    public static <T extends Serializable> Integer getClosingId(Class<T> key){
        return mapCounter.get(key);
    }

    public static  <T extends Serializable> Integer setClosingId(Class<T> key, int angka) {
        return mapCounter.replace(key, angka);
    }
}
*/
