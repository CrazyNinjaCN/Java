import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
       
        TList list = new TList();
        list.add(1);
        list.add(2);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.size());
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(Arrays.toString(list.toArray()));

        ArrayList<Object> cl = new ArrayList<Object>();
        cl.add(4);cl.add(5);cl.add(6);cl.add(7);
        list.addAll(cl);
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(1);
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("l1"+list.get(0));
        System.out.println("l2"+list.get(1));
        System.out.println("l3"+list.get(2));
        System.out.println("l4"+list.get(3));




        System.out.println(list.size());
        list.clear();
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));

        list.add(1);
        list.add(2);
        list.addAll(cl);

        System.out.println(Arrays.toString(list.toArray()));

        TList sb = list.subList(5,8);

        System.out.println(Arrays.toString(sb.toArray()));



            for (Object f: list) {
                System.out.println(f);
            }

    }
}