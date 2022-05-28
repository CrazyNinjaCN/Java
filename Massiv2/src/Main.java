import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Count Alpinist:");
        int n = console.nextInt();

        Alpinist[] Alpinists = new Alpinist[n];
        Random rnd = new Random();
        for (int i=0;i<n;i++){
            Alpinists[i] = new Alpinist(rnd.nextInt(10), rnd.nextInt(10), rnd.nextInt(15+20));
            System.out.println("Alpinist "+Alpinists[i].id + " up " + Alpinists[i].UP + " down " + Alpinists[i].DOWN + " size " + Alpinists[i].SIZE);
        }
        int [] Map = new int[]{6,5,5,4,5,4,3,2,0,0,1,2,3,1,0,0,1,2};

        for(int i=0;i<n;i++){
            for(int j=0;j<Map.length-1;j++){

                if(Alpinists[i].SIZE < j){
                    Alpinists[i].Win = false;
                }

                if(Map[j+1] > Map[j]){
                   if(Alpinists[i].UP < Map[j+1] - Map[j]){
                       Alpinists[i].Win = false;
                   }
                }
                if(Map[j+1] < Map[j]){
                    if(Alpinists[i].DOWN < Map[j] - Map[j+1]){
                        Alpinists[i].Win = false;
                    }
                }
            }

        System.out.println("Alpinist " + Alpinists[i].id + (Alpinists[i].Win ? " Win" : " Loose"));

        }
    }
}