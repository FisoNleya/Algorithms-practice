package dynamic;

import java.util.Arrays;
import java.util.HashMap;


public class TwoSum {

    public static void main(String[] args) {

        int[] arr = new int[]{2, 11, 5, 10, 7, 8};

        System.out.println(Arrays.toString(twoSum(arr, 9)));
        System.out.println(Arrays.toString(twoSum2(arr, 9)));

    }

    public static int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];


        for (int i = 0; i < nums.length; i++) {

            if (i > target)
                continue;

            for (int j = i + 1; j < nums.length; j++) {

                if (j > target)
                    continue;

                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }

        return result;
}



    public static int[] twoSum2(int[] nums, int target) {

        int[] result = new int[2];

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {

            Integer val = map.get(nums[i]);
            if(val == null){
                map.put(target - nums[i], i);
            }else {
                result[0] = val;
                result[1] = i;
                return  result;
            }

        }

        return result;
    }
}
