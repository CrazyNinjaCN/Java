import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] rank = PlayingCard.RANK_LIST;
        String[] suits = PlayingCard.SUITS_LIST;
        System.out.println("ranks:" + Arrays.toString(rank));
        System.out.println("suits:" + Arrays.toString(suits));

        Scanner console = new Scanner(System.in);

        int _card = 52;
        int n = 0;
        while (n*5 > _card || n == 0) {
            System.out.println("Players:");
            n = console.nextInt();
            if(n*5 >_card){
                System.out.println("No cards!");
            }
        }
        Player[] Players = new Player[n];



        PlayingCard[] Cards = new PlayingCard[_card];

        int si = 0; int ri = 0;

        for(int i = 0; i < _card; i++) {
            Cards[i] = new PlayingCard(suits[si], rank[ri]);

            ri++;
            if(ri == rank.length){
                ri = 0;
                si++;
            }
        }

        System.out.println(Arrays.toString(Cards));

        Random rnd = new Random();
        for(int i = 0; i < Cards.length; i++) {
            int index = rnd.nextInt(i + 1);
            PlayingCard a = Cards[index];
            Cards[index] = Cards[i];
            Cards[i] = a;
        }

        System.out.println(Arrays.toString(Cards));

        for(int i=0;i<n;i++){
            Players[i] = new Player();
        }

        int p = 0;
        for(int i=0;i<5*n;i++){
            if(i%5==0 && i !=0){
                p++;
            }
            Players[p].AddCard(Cards[i]);
        }

        for(int i=0; i<n;i++) {
            System.out.println("Player " + Players[i].id + " " + Arrays.toString(Players[i].cards));
        }
    }
}