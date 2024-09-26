package test;

public class Main {
    public static void main(String... args){
        char one = '1';
        char two = '2';
        char three = '0';
        int beforeConvert = one + two;
        int afterConvert = (one - '0') + (two- '0');


        int valueOfZero = three;
        System.out.println(beforeConvert);
        System.out.println(afterConvert);
        System.out.println(valueOfZero);
    }
}
