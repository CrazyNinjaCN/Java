public class Alpinist {
    public static int _id;
    public  int id;

    public int UP;
    public int DOWN;
    public int SIZE;

    public boolean Win = true;
    public Alpinist(int up, int down, int size){
        _id++;
        id = _id;
        UP = up;
        DOWN = down;
        SIZE = size;
    }
}
