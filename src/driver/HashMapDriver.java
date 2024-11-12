package driver;

import hashmap.HashMap;

public class HashMapDriver {

    public static void main(String[] args){
        HashMap<String, Integer> numToLetter = new HashMap<>();

        for(int i = 1; i <= 150; i++){
            Integer val = i;
            numToLetter.put(String.valueOf(i), val);
            //System.out.println(numToLetter.get(i+""));
        }

        numToLetter.put("1", 1000);
        System.out.println(numToLetter.get("1") + " is key 1");
        System.out.println("Size of hash map " + numToLetter.size());

        numToLetter.remove("1");
        System.out.println("Size of hash map after the removal " + numToLetter.size());


    }
}
