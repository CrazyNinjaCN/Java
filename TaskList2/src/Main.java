import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        ArrayList<Object> cl = new ArrayList<Object>();
        cl.add(4);cl.add(5);cl.add(6);cl.add(7);
        list.addAll(cl);
        list.add("str");
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(2);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.isEmpty());
        System.out.println(list.contains("str"));
        MyLinkedList sb = list.subList(1,3);
        System.out.println(Arrays.toString(sb.toArray()));
        list.clear();
        System.out.println(Arrays.toString(list.toArray()));
    }
}