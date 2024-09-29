package search;

public class Search {

    public static void main(String... args){

        int[] binarySearchArray = new int[]{4,8,19};
        System.out.println(binarySearch(binarySearchArray, 8));
    }

    //Standard
    public static int binarySearch(int[] arr, int n) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {

            int mid = l + ((r - l) / 2) ;
            if (arr[mid] == n)
                return mid;

            if (n < arr[mid]) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;
    }


}
