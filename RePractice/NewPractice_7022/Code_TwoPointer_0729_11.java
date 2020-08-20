package RePractice.NewPractice_7022;

public class Code_TwoPointer_0729_11 {


    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        while (l < r){
            int h = Math.min(height[l],height[r]);
            res = Math.max((r - l) * h,res);
            if (height[l] < height[r]){
                l++;
            }else {
                r--;
            }
        }
        return res;
    }
    //on的平方
    public int maxArea1(int[] height) {
        int n = height.length;
        int res = 0;
        for (int i = 0;i < n;i++){
            for (int j = 0;j < i;j++){
                int h = Math.min(height[i],height[j]);
                res = Math.max(res,(i - j) * h);
            }
        }
        return res;
    }


}
