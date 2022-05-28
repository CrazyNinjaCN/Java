import java.util.Collection;

public interface TaskList<E> extends Iterable<E> {

    /**
     * Метод добавляет в конец списка новый элемент
     *
     * @param  e  Добавляемый в список элемент
     */
    void add(E e);

    /**
     * Метод добавляет в конец списка элементы из переданной коллекции
     *
     * @param  collection  Добавляемый список
     */
    void addAll(Collection<? extends E> collection);

    /**
     * Удаление из списка всех значений
     *
     */
    void clear();

    /**
     * Получение элемента списка по индексу
     * @param  index  Индекс элемента
     * @return Элемент расположенный по индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    E get(int index);

    /**
     * Проверка на заполненность списка
     * @return true если список пуст
     */
    boolean isEmpty();

    /**
     * Проверка на принодлежность элемента списку
     * @param  value  Элемент для проверки
     * @return true если элемент принадлежит
     */
    boolean contains(E value);

    /**
     * Удаление элемента списка по индексу
     * @param  index  Индекс элемента
     * @return Элемент расположенный по индексу
     * @throws IndexOutOfBoundsException если индекс выходит за пределы списка
     */
    E remove(int index);

    /**
     * Получение длинны списка
     * @return длинна списка
     */
    int size();

    /**
     * Удаление элемента списка по индексу
     * @param  fromIndex  Индекс начала подсписка
     * @param  toIndex  Индекс конца подсписка
     * @return Подсписок
     * @throws IndexOutOfBoundsException если индексы выходит за пределы списка
     */
    TaskList<E> subList(int fromIndex, int toIndex);

    /**
     * Превращение списка в массив
     * @return Массив с элементами списка
     */
    Object[] toArray();

}