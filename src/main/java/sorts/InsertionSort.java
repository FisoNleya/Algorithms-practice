package sorts;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {


    public static void main(String[] args) {

        //Insertion sort

//        int[] arr = new int[]{1,2,3,5,6,4};
//        insertionSort(arr);

        //Selection sort

//        int[] arr = new int[]{3,1,5,2,6};
//        selectionSort(arr);

        //Merge sort

//        int[] arr1 = new int[]{1, 3, 5, 13,30};
//        int[] arr2 = new int[]{2, 9, 10, 11, 12, 32};
//
//        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));


        //Three number sort
        // threeNUmberSort();

        //Quick sort
//        int[] arr = {2, 5, 3, 10, 30, 3, 21,1, 4};
//
//        quickSort2(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));


        squareAndSort();
    }



    public static void squareAndSort(){

        int[] arr = {-20,-4,-1,0,3,10,40, 100 };

        for(int i = 1 ; i < arr.length; i++){

            if(i == 1){
                arr[i-1] = arr[i-1]*arr[i-1];
            }


            for(int j = i-1 ; j >=0 ; j--){

                int jvalue = arr[j];
                int j1squar = arr[j+1] * arr[j+1];

                if(jvalue > j1squar && j+1 == i){
                    squareSwap(arr, j , j+1);

                } else if (j+1 == arr.length-1 && j+1 == i) {
                    arr[j+1] = j1squar;

                } else if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                } else
                    break;
            }

        }

        System.out.println(Arrays.toString(arr));

    }


    public static void squareSwap(int[] arr, int j , int j1){
        int temp = arr[j1];
        arr[j1] = arr[j];
        arr[j] = temp * temp;
    }



    private static void square(int[] arr, int i){
        arr[i] = arr[i]*arr[i];
    }


    //faster quick sort , Ologn, best case On
    public static void quickSort2(int[] arr, int left, int right) {

        if (left >= right) return;

        int r = right - 1;
        int l = left;

        int randIndex = new Random().nextInt(right - left) + left;
        swap(arr, randIndex, right);
        int p = right;

        while (l <= r) {
            if (arr[l] >= arr[p] && arr[p] >= arr[r]) {
                swap(arr, l, r);
                l++;
                r--;
            } else if (arr[l] < arr[p]) {
                l++;
            } else if (arr[r] > arr[p]) {
                r--;
            }

        }

        swap(arr, l, p);

        quickSort2(arr, left, l - 1);
        quickSort2(arr, l + 1, right);

    }



    //worst case On^2
    // best case On
    public static void quickSort(int[] arr, int i, int k) {

        if (i >= k)
            return;

        int p = (i + k) / 2;

        while (i < k) {

            if (arr[i] >= arr[p] && arr[k] <= arr[p]) {
                System.out.printf("Swaping %d with %d\n", arr[i], arr[k]);
                swap(arr, i, k);
                i++;
                k--;
                System.out.println("i = " + i + ", k = " + k);


            } else if (arr[i] < arr[p]) {
                System.out.println("inrementing i at " + arr[i]);
                i++;
            } else if (arr[k] > arr[p]) {
                System.out.println("decrementing k at " + arr[k]);
                k--;
            }
            System.out.println("iter--");
        }


        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, p - 1);

        quickSort(arr, p + 1, k);

    }


    //worst case n^2
    // best case n
    // deck of cards
    public static int[] insertionSort(int[] arr) {


        if (arr.length <= 1)
            return arr;

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            for (int j = i - 1; j >= 0; j--) {

                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                } else
                    break;

            }


        }

        return arr;
    }


    //worst case n^2
// best case n^2
//  opposite of insertion sort
//  find the minimum in the unsorted array and swapp with the current value
    public static int[] selectionSort(int[] arr) {

        if (arr.length <= 1)
            return arr;


        for (int i = 0; i < arr.length - 1; i++) {

            int tempMIn = arr[i + 1];
            if (tempMIn < arr[i]) {
                arr[i + 1] = arr[i];
                arr[i] = tempMIn;
                tempMIn = arr[i + 1];
            }


            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] < tempMIn) {
                    int temp = arr[j];
                    arr[j] = tempMIn;
                    arr[i + 1] = temp;
                    tempMIn = arr[j];
                }
            }


        }

        return arr;
    }


    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {


        int newSize = arr1.length + arr2.length;
        int[] newArr = new int[newSize];

        int x = 0;
        int y = 0;

        for (int i = 0; i < newSize; i++) {

            if (x < arr1.length && y < arr2.length) {
                if (arr1[x] < arr2[y]) {
                    newArr[i] = arr1[x];
                    x++;
                } else {
                    newArr[i] = arr2[y];
                    y++;
                }
            } else if (x >= arr1.length) {
                while (y < arr2.length) {
                    newArr[i++] = arr2[y];
                    y++;
                }
                break;
            } else if (y >= arr2.length) {
                {
                    while (x < arr1.length) {
                        newArr[i++] = arr1[x];
                        x++;
                    }
                    break;
                }
            }

        }

        return newArr;
    }


    public static void threeNUmberSort() {


        int[] arr = {2, 0, 2, 2, 0, 1, 1};

        int i = 0;
        int j = 0;
        int k = arr.length - 1;

        System.out.println("Before three Number " + Arrays.toString(arr));

        while (i <= k) {

            if (arr[i] == 0) {
                swap(arr, i, j);
                i++;
                j++;
            } else if (arr[i] == 2) {
                swap(arr, i, k);
                k--;
            } else {
                i++;

            }


        }


        System.out.println("Sorted in three Number " + Arrays.toString(arr));

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}