import java.util.LinkedList;

public class Dec implements Deque{

    LinkedList _items = new LinkedList();

    public int Count;


    @Override
    public boolean isEmpty() {
        if(_items.contains(null)){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isFull() {
        if(!_items.contains(null)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void pushBack(Object value) {
        _items.addFirst(value);
        Count++;
    }

    @Override
    public Object popBack() {
        Count--;
        Object result = _items.peekFirst();
        _items.removeFirst();
        return result;
    }

    @Override
    public Object peekBack() {
        Object result = _items.peekFirst();
        return result;
    }

    @Override
    public void pushFront(Object value) {
        _items.addLast(value);
        Count++;
    }

    @Override
    public Object popFront() {
        Count--;
        Object result = _items.peekLast();
        _items.removeLast();
        return result;
    }

    @Override
    public Object peekFront() {
        Object result = _items.peekLast();
        return result;
    }
}
