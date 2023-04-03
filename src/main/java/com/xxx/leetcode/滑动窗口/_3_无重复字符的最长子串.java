package 滑动窗口;


/**
 * @author shenjingbin
 * @date 2021/10/27
 */
public class _3_无重复字符的最长子串 {
    public static void main(String[] args) {

        System.out.println(Integer.valueOf('a'));
        String str = "abcdef";
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                System.out.print(str.substring(i, j) + "---");
            }
        }
    }

    /**
     * 1. 如何判断最长子串
     * 2. 首先我们取一个临时变量用于存储字串的起始位置
     * 3. 因为字符串都是数字，字母和字符,所以ASCII码肯定在0-128之间
     * 4. 我们创建一个int类型 128长度的数组，用于存储，每个字符重复后start的新起点
     */
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) {
            return 0;
        }
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            hash[c] = i + 1;
            max = Math.max(max, i - preP + 1);
        }
        return max;
    }


}
