package RePractice.SwordOffer0316Twice;

import java.util.Stack;
//没有检查s
public class Code_0405_39moreThanHalf {
    public int solution(int[] nums){
        if (nums == null || nums.length < 1){
            throw new RuntimeException("error!");
        }
        int middle = nums.length >> 1;
        int start = 0;
        int end = nums.length - 1;
        int randIndex = (int)Math.random() * (end - start + 1);
        swap(nums,randIndex,end);
        int res = partition(nums, 0 ,end);
        while (res != middle){
            if (res < middle){
                start = res;
                res = partition(nums , start , end);
            }else {
                end = res;
                res = partition(nums , start, end);
            }

        }
        return nums[res];
    }

    //不知道对不对！
    public int partition(int[] arr , int start , int end){
//        int randIndex = (int)Math.random() * (end - start + 1);
//        swap(arr,randIndex,end);
        int less = start - 1;
        int more = end ;
        int cur = start;
        while (cur < more){
            if (arr[cur] < arr[end]){
                swap(arr,++less,cur++);
            }else if (arr[cur] > arr[end]){
                swap(arr,--more,cur);
            }else {
                cur++;
            }
        }
//        swap(arr,more,cur);
        swap(arr,more,end);
        return more;

    }

    public void swap(int[]arr , int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //第二种做法

    public int solution3(int[] nums){
        int value = -1;
        int count = 0;
        for (int x : nums){
            if (count == 0){
                value = x;
                count = 1;
            }else {
                if (x == value){
                    count++;
                }else {
                    count--;
                }

            }

        }
        return value;
    }

    public int solution2(int[] nums){
        if (nums == null || nums.length < 1){
            throw new  RuntimeException("error!");
        }
        int index = 1;
        int count = 1;
        int cur = nums[0];
        while (index <= nums.length - 1){
            if (cur != nums[index]){
                count--;
            }else {
                count++;
            }
            index++;
            if (count == 0){
                cur = nums[index];
            }
        }
        return cur;
    }
}
