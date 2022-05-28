

import java.util.Collection;
import java.util.Iterator;

public class TList implements TaskList {

    public Object Value;
    public int Index;
    public int Count;
    private TList Next;
    private TList _head;
    private TList _tail;

    int ic;
    public TList()
    {

    }

    public TList(Object value)
    {
        Value = value;
    }

    @Override
    public void add(Object o) {
        TList node = new TList(o);
        node.Index = Count;
        if (_head == null)
        {
            _head = node;
            _tail = node;
        }
        else
        {
            _tail.Next = node;
            _tail = node;
        }

        Count++;
    }

    @Override
    public void addAll(Collection collection) {
        Object[] obj = new Object[collection.size()];
        obj = collection.toArray();
        for(int i=0;i< obj.length;i++){
            add(obj[i]);
        }
    }

    @Override
    public void clear() {
        TList previous = null;
        TList current = _head;
        while (current != null){
            remove(0);
            previous = current;
            current = current.Next;
        }
    }

    @Override
    public Object get(int index) {
        TList previous = null;
        TList current = _head;
        while (current != null){
            if(current.Index == index){
                return current.Value;
            }
            previous = current;
            current = current.Next;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        TList previous = null;
        TList current = _head;
        while (current != null){
            if(current.Value == null){
                return false;
            }
            previous = current;
            current = current.Next;
        }
        return true;
    }

    @Override
    public boolean contains(Object value) {
        TList previous = null;
        TList current = _head;
        while (current != null){
            if(current.Value == value){
                return true;
            }
            previous = current;
            current = current.Next;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        boolean find = false;
        TList previous = null;
        TList current = _head;
        while (current != null)
        {
            if (current.Index == index)
            {
                if (previous != null)
                {
                    previous.Next = current.Next;

                    if (current.Next == null)
                    {
                        _tail = previous;
                    }
                }
                else
                {
                    _head = _head.Next;
                    if (_head == null)
                    {
                        _tail = null;
                    }
                }
                Count--;
                find = true;
            }
            if (current.Index > index-1)
            {
                current.Index -= 1;
            }
            previous = current;
            current = current.Next;
        }

        if(find){
            return true;
        }

        return null;
    }

    @Override
    public int size() {
        return Count;
    }

    @Override
    public TList subList(int fromIndex, int toIndex) {

        Object[] ls = new Object[Count];
        ls = toArray();
        TList sublist = new TList();
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

    @Override
    public Object[] toArray() {
        TList previous = null;
        TList current = _head;
        Object[] obj = new Object[Count];
        int i = 0;
        while (current != null){
            obj[i] = current.Value;
            i++;
            previous = current;
            current = current.Next;
        }
        return obj;
    }

    @Override
    public Iterator iterator() {


        return new Iterator() {


                //private int currentIndex = 0;
                private TList current = _head;
                private  TList tl = new TList();
                @Override
                public boolean hasNext () {
                    if(current == null){
                        return false;
                    }else {
                        return true;
                    }

                }

                @Override
                public Object next () {
                    TList  tl = current;
                    current = current.Next;
                    return tl.Value;
                }
        } ;


    }
}
