package fibonacci;

public class Fibonacci {

    public static void main(String[] args) {
        printFibonacci(5);
    }

    public static void printFibonacci(int n) {


        int p1 = 0, p2 = 1;

//        0 1 1 2 3

        for (int i = 0; i <= n; i++) {

            if(i == 0) {
                System.out.println(i);
            }
            else if(i == 1){
                    System.out.println(i);
                    p2 = 1;

            }else {
                System.out.println((p1) + (p2));
                int temp = p1;
                p1 =p2;
                p2 = temp + (p2);
            }


        }

    }
}
