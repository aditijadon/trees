package datastructures;

import java.util.*;

public class MapImplementation {

    public static void main(String[] args) {

        // table of 2 creation
        List<Integer> tableOf2 = new ArrayList<>();
        for(int i=2; i<=20; i=i+2) {
            tableOf2.add(i);
        }

        //table of 3 creation
        List<Integer> tableOf3 = new ArrayList<>();
        for(int j=3; j<=30; j=j+3) {
            tableOf3.add(j);
        }

        Map <Integer,List<Integer>> map = new HashMap<>();

        map.put(2,tableOf2); //storing table of 2 in map
        map.put(3,tableOf3); //storing table of 3 in map

        System.out.println(map.containsKey(5)); //does not contain 5

        //printing
        for(Integer key: map.keySet() ){
            System.out.println(key);
        }

        System.out.println("table of 3 : ");
        for( Integer value : map.get(2))
        System.out.println(value);

    }

}
