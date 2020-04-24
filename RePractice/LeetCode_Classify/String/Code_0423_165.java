package RePractice.LeetCode_Classify.String;

public class Code_0423_165 {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int len = Math.max(s1.length , s2.length);

        for (int i = 0; i < len; i++){
            int res1 = 0 ,res2 = 0;
            if (i < s1.length){
                res1 = Integer.parseInt(s1[i]);
            }
            if (i < s2.length) {
                res2= Integer.parseInt(s2[i]);
            }

            if (res1 == res2){
                continue;
            }
            return res1 > res2 ? 1 : -1;
        }
        return 0;
    }




















    ///

    String[] strs1 = version1.split("\\.");
    String[] strs2 = version2.split("\\.");

    int len = Math.max(strs1.length, strs2.length);

		for (int i = 0; i < len; i++) {

        int dec1 = 0;

        if (i < strs1.length)
            dec1 = Integer.parseInt(strs1[i]);
        int dec2 = 0;
        if (i < strs2.length)
            dec2 = Integer.parseInt(strs2[i]);

        if (dec1 == dec2) {
            continue;
        }

        return dec1 > dec2 ? 1 : -1;
    }

		return 0;

}
