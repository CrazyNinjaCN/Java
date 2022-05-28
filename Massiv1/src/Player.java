public class Player {
    public static int _id;
    public int id;
    public PlayingCard[] cards = new PlayingCard[5];

    public Player(){
        _id++;
        id = _id;
    }
    public void AddCard(PlayingCard pc){
        for(int i=0;i< cards.length;i++){
            if(cards[i] == null){
                cards[i] = pc;
                break;
            }
        }
    }
}
