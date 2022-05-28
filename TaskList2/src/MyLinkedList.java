import java.util.*;

public class MyLinkedList implements TaskList {

    private String msgException = "The element is not found...";


    private int size;


    private Node first;


    private Node last;


    MyLinkedList() {

    }


    MyLinkedList(Collection collection) {
        this.addAll(collection);
    }



    public int size() {
        return this.size;
    }

    @Override
    public MyLinkedList subList(int fromIndex, int toIndex) {
        Object[] ls = new Object[size()];
        ls = toArray();
        MyLinkedList sublist = new MyLinkedList();
        for(int i=0;i<ls.length;i++){
            if(i >= fromIndex && i <= toIndex){
                sublist.add(ls[i]);
            }
        }
        if(sublist == null) {
            return null;
        }else{
            return sublist;
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object value) {
        Object obj[] = this.toArray();
        for(int i=0;i<obj.length;i++) {
            if (obj[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        boolean result = checkIndexToRange(index);
        if (result) {
            result = remove(getLinkByIndex(index));
        }
        return result;
    }

    @Override
    public void add(Object o) {
        if (this.first == null) {
            first = new Node(null, null, o);
        } else {
            Node prevElement = this.last == null ? this.first : this.last;
            this.last = new Node(prevElement, null, o);
            prevElement.next = this.last;
        }
        this.size++;
    }

    @Override
    public void addAll(Collection collection) {
        Object obj[] = collection.toArray();
        for(int i = 0; i < obj.length; i++)
        {
            add(obj[i]);
        }
    }

    public void clear() {
        this.size = 0;
        this.first = null;
        this.last = null;
    }


    public Object[] toArray() {
        Object[] resultArray = new Object[this.size];
        int index = 0;
        for (Node link = this.first; link != null; link = link.next) {
            resultArray[index++] = link.value;
        }
        return resultArray;
    }


    private boolean checkIndexToRange(int index) {
        return index >= 0 && index < this.size;
    }


    private Node getLinkByIndex(int index) {
        Node result;
        if (this.size >> 1 >= index) {
            result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        } else {
            result = this.last;
            for (int i = this.size - 1; i > index; i--) {
                result = result.prev;
            }
        }
        return result;
    }


    public Object get(int index) {
        Object result;
        if (checkIndexToRange(index)) {
            result = getLinkByIndex(index).value;
        } else {
            throw new NoSuchElementException(this.msgException);
        }
        return result;
    }


    private boolean remove(Node node) {
        boolean result = node != null;
        if (result) {
            if (node.next == null && node.prev == null) {
                first = null;
                last = null;
            } else if (node.prev == null) {
                first = node.next;
                first.prev = null;
            } else if (node.next == null) {
                last = node.prev;
                last.next = null;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        return result;
    }


    @Override
    public Iterator<String> iterator() {
        return new IteratorLinked();
    }


    private class Node {

        private Node prev;


        private Node next;


        private Object value;


        Node(Node prev, Node next, Object value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }


    private class IteratorLinked implements Iterator<String> {

        private Node cursor = first;


        @Override
        public boolean hasNext() {
            return this.cursor != null;
        }


        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException(msgException);
            }
            String result = (String) cursor.value;
            this.cursor = this.cursor.next;
            return result;
        }
    }
}

