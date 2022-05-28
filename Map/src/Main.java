import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {


    public static void main(String[] args) throws IOException {

        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> sortedMap = new HashMap<>();

        System.out.println(map);


       FileWriter writer = new FileWriter("out.txt", false);

        File file = new File("access.txt");
        FileReader fr = new FileReader(file);

        BufferedReader reader = new BufferedReader(fr);


            String line = reader.readLine();
            String[] linewords;
            ArrayList words = new ArrayList<>();


            while (line != null) {
                linewords = line.split(" ");
                words = new ArrayList<>();
                for(int i=0;i<linewords.length;i++)
                {
                    if(linewords[i] != ""){
                        words.add(linewords[i]);
                    }
                }
                map.put(words.get(2).toString(), map.get(words.get(2).toString()) == null ? 1 : map.get(words.get(2).toString())+1);
                line = reader.readLine();
            }

        sortedMap = map.entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                .collect(Collectors
                        .toMap(Map.Entry::getKey,
                                Map.Entry::getValue,
                                (e1, e2) -> e1,
                                LinkedHashMap::new));

        System.out.println(sortedMap);

        Iterator<Map.Entry<String, Integer>> itr = sortedMap.entrySet().iterator();
        int i = 0;
        while (itr.hasNext())
        {

            Map.Entry<String, Integer> next = itr.next();
            System.out.println(next);
            writer.write(next.getKey().toString());writer.append('\n');
            i++;
            if(i==10){
                break;
            }
        }
        writer.flush();
    }


}