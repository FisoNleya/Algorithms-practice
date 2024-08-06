package arrays;

import java.util.Arrays;

public class ArraysUtil {

    public static void main(String ...args){

        //{1,2,3,4}
        //{24,12,8,6}
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr)));

        int[] maxSubArrayArray = {-2,1,-3,4,-1,2,1,-5,4};
        int[] maxSubArrayArray2 = {5,4,-1,7,8};
        int[] maxSubArrayArray3 = {-2,7,-3,4};
        int[] maxSubArrayArray4 = {-2,-1};
        int[] maxSubArrayArray5 = {-2,3,2, -1, 1};

       System.out.println(maxSubArray(maxSubArrayArray4));
       System.out.println(maxSubArrayOptimal(maxSubArrayArray5));
    }



    // Best case On
    public static int[] productExceptSelf(int[] arr){

        int[] leftIncrements = new int[arr.length];
        int[] resultArr = new int[arr.length];



        leftIncrements[0] = arr[0];
        for(int i=1; i < arr.length; i++){
            leftIncrements[i] = arr[i] * leftIncrements[i - 1];
        }

        resultArr[arr.length - 1] = leftIncrements[arr.length-2];
        int rightIncrement = arr[arr.length-1];


        for(int i = arr.length -2; i >= 1; i--){
            resultArr[i] = leftIncrements[i -1]  * rightIncrement;
            rightIncrement *= arr[i];

        }
        resultArr[0] = rightIncrement;
        return resultArr;
    }


    public static int maxSubArray(int[] arr){

        int maxSoFar = arr[0];
        int rightIndex = 0;


        int[] inrementsArray = new int[arr.length];
        int leftIndex = 0;


        int total = 0;
        for(int i=0; i <= arr.length -1; i++) {
            total += arr[i];
            if (total > maxSoFar) {
                maxSoFar = total;
                rightIndex = i;
            }
            inrementsArray[i] = total;
        }

        maxSoFar =0;
        total =0;
        for(int i = rightIndex ; i >=0 ; i--){

            total += arr[i];
            if(total > maxSoFar){
                maxSoFar = total;
                leftIndex = i;
            }

        }

        return inrementsArray[rightIndex] - inrementsArray[leftIndex] + arr[leftIndex];
    }

    /**
     *
     * Kadane's Algorithm
     * O(n) Time complexity
     * @return int sum
     */

    public static int maxSubArrayOptimal(int[] arr){

        int globalSum = arr[0];
        int currSum = arr[0];

        for (int i =1; i < arr.length; i++){
             currSum = Math.max(arr[i], arr[i]+ currSum);

             if(currSum >  globalSum)
                 globalSum = currSum;
        }

        return globalSum;
    }

}
