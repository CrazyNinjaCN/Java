public interface Deque <T> {

    boolean isEmpty();
    boolean isFull();

    void pushBack(T value);

    T popBack();
    T peekBack();

    void pushFront(T value);
    T popFront();
    T peekFront();

}