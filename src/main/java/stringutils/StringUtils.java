package stringutils;

import java.util.*;

public class StringUtils {

    public static void main(String[] args) {

        String testString = "aagcgddefccebfb";

        System.out.println(firstNonRepeatingChar(testString));

    }

    public static int firstNonRepeatingChar(String str) {


        Map<Character, Integer> allElements = new HashMap<>();
        allElements.put(str.charAt(0), 0);

        Map<Character, Integer> nonRepValuesMap = new HashMap<>();
        List<Integer> noRepIndexes = new ArrayList<>();


        for (int i = 1; i < str.length(); i++) {

            Integer value = allElements.get(str.charAt(i));
           if (value == null){
               nonRepValuesMap.put(str.charAt(i), i);
               noRepIndexes.add(i);
            }else {

               noRepIndexes.remove(nonRepValuesMap.get(str.charAt(i)));
               nonRepValuesMap.remove(str.charAt(i));

           }

            allElements.put(str.charAt(i), i);
        }


        if (noRepIndexes.isEmpty()){
            return -1;
        }

        System.out.println("First non repeating char "+str.charAt(noRepIndexes.get(0)));

        return noRepIndexes.get(0);

    }


}
