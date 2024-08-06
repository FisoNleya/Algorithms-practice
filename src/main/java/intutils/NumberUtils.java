package intutils;

public class NumberUtils {
    public static void main(String[] args) {

        System.out.println(""+reverseInteger(256));
        System.out.println(""+reverseInteger(-256));

    }

    public static int reverseInteger(int num){

        boolean negative = num < 0;
        int sign = negative ? -1 : 1;
        int end = negative ? 1 : 0;

        String stringNum = String.valueOf(num);
        StringBuilder rsltString = new StringBuilder();

        for(int i = stringNum.length()-1; i >= end; i--){

            rsltString.append(stringNum.charAt(i));
        }

        return Integer.parseInt(rsltString.toString()) * sign ;

    }

}
