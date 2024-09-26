package stringutils;

import java.util.*;

public class StringUtils {

    public static void main(String[] args) {

//        String testString = "aagcgddefccebfb";
//        System.out.println(firstNonRepeatingChar(testString));


        System.out.println(removeVowelsFromString("stripped"));

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



    public static String removeVowelsFromString(String str) {

        String result = "";

        for (int i = 0; i < str.length(); i++) {

            switch (str.charAt(i)) {

                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    break;
                default:
                    result += str.charAt(i);

            }

        }
        return result;

    }


    //Not good, LeetCode 58
    //TODO rewrite
    public int lengthOfLastWordBruteForce(String s) {

        boolean lastWordEnded = true;
        int lastWordLength = 0;

        for(int i = 0; i < s.length(); i++){

            char currChar = s.charAt(i);

            if(lastWordEnded &&  currChar != ' '){
                lastWordLength = 0;
            }

            if(currChar != ' '){
                lastWordLength++;
                lastWordEnded = false;
            } else
            {
                lastWordEnded = true;
            }

        }
        return lastWordLength;

    }

    //Bad, need rewrite
    //TODO rewrite
    public int[] plusOne(int[] digits) {

        int remainder = 0;
        Stack<Integer> resultStack = new Stack<>();


        int lastValue = digits[digits.length-1];
        if(lastValue+1 > 9){
            remainder = 1;
            resultStack.push(0);
        }else{
            resultStack.push(lastValue+1);
            System.out.println("Adding "+ lastValue+1);
            remainder = 0;
        }


        for( int i = digits.length -2; i >= 0; i--){
            int val = digits[i];

            if(remainder> 0){

                if(val+remainder > 9){
                    remainder = 1;
                    resultStack.push(0);
                }else{
                    resultStack.push(val+remainder);
                    remainder = 0;
                }

            }else{
                resultStack.push(val);
            }

        }

        if(remainder > 0){
            resultStack.push(remainder);
        }


        int[] resultArry = new int[resultStack.size()];

        for(int i = 0 ; i < resultArry.length; i++){
            resultArry[i] = resultStack.pop();
        }


        return resultArry;
    }



    //Add binary --Brute force
    //TODO optimize
    public String addBinaryA(String a, String b) {

        int index = 1;
        int remainder = 0;
        String finalResult = "";

        while(a.length() - index >= 0 && b.length() - index >=0){
            int aTarget = a.length() - index;
            int bTarget = b.length() - index;

            char aChar = a.charAt(aTarget);
            char bChar = b.charAt(bTarget);

            int result = Integer.parseInt(aChar+"") + Integer.parseInt(bChar+"") + remainder;

            if(result == 2){
                finalResult = "0"+finalResult;
                remainder = 1;
            }else if (result > 2){
                finalResult = "1"+finalResult;
                remainder = 1;
            }else{
                finalResult = result+finalResult;
                remainder = 0;
            }

            index++;

        }

        if(a.length() > b.length()){
            while(a.length() - index >= 0){
                int aTarget = a.length() - index;
                char aChar = a.charAt(aTarget);

                int result = Integer.valueOf(aChar+"") + remainder;

                if(result > 1 ){
                    finalResult = "0"+finalResult;
                    remainder = 1;
                }
                else{
                    finalResult = result+finalResult;
                    remainder = 0;
                }
                index++;

            }
        }else{
            while(b.length() - index >= 0){
                int bTarget = b.length() - index;
                char bChar = b.charAt(bTarget);
                int result = Integer.valueOf(bChar+"") + remainder;
                if(result > 1){
                    finalResult = "0"+finalResult;
                    remainder = 1;
                }else{
                    finalResult = result+finalResult;
                    remainder = 0;
                }
                index++;

            }
        }


        if(remainder > 0){
            finalResult = remainder+finalResult;
        }

        return finalResult;

    }



    //Better version
    /***
     * tricks
     *-User modulus function to get remainder and devide to get  value to add
     * -Used char - '0' to make char an int
     */

    public String addBinary(String a, String b) {

        int remainder = 0;
        StringBuilder result = new StringBuilder();

        int index = 1;

        while(a.length()-index>=0 || b.length()-index>=0 || remainder != 0){
            int sum = 0;
            int aIndex = a.length()-index;
            int bIndex = b.length()-index;

            if(aIndex>=0)
                sum = sum + (a.charAt(aIndex)-'0');


            if(bIndex>=0)
                sum = sum + (b.charAt(bIndex)-'0');


            sum += remainder;

            result.append(sum % 2);
            remainder = sum / 2;

            index++;
        }
        return result.reverse().toString();
    }




}
