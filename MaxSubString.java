/*2. 编程题

        编程获取两个指定字符串中的最大相同子串。

        如： s1="asdafghjka", s2="aaasdfg" 他们的最大子串为"asd"

        提示： 将短的那个串进行长度依次递减的子串与较长的串比较。
        package com.lagou.mod3.homework;

*/

import java.util.Arrays;

public class MaxSubString {
    /*
      获取两个字符串中最大相同子串。比如：
     str1 = "abcwerthelloyuiodefabcdef";str2 = "cvhellobnm"
     提示：将短的那个串进行长度依次递减的子串与较长的串比较。
       */
    //前提：两个字符串中只有一个最大相同子串
    public String getMaxSameString(String str1,String str2){
        if(str1 != null && str2 != null){
            String maxStr = (str1.length() >= str2.length())? str1 : str2;
            String minStr = (str1.length() < str2.length())? str1 : str2;
            int length = minStr.length();

            //首尾递进，尾部先减
            for(int i = 0;i < length;i++){
                for(int x = 0,y = length - i;y <= length;x++,y++){
                    String subStr = minStr.substring(x,y);
                    if(maxStr.contains(subStr)){
                        return subStr;
                    }

                }
            }

        }
        return null;
    }

    // 如果存在多个长度相同的最大相同子串
    // 此时先返回String[]，后面可以用集合中的ArrayList替换，较方便
    public String[] getMaxSameString1(String str1, String str2) {
        if (str1 != null && str2 != null) {
            StringBuilder sBuffer = new StringBuilder();
            String maxString = (str1.length() > str2.length()) ? str1 : str2;
            String minString = (str1.length() > str2.length()) ? str2 : str1;

            int len = minString.length();
            for (int i = 0; i < len; i++) {
                for (int x = 0, y = len - i; y <= len; x++, y++) {
                    String subString = minString.substring(x, y);
                    if (maxString.contains(subString)) {
                        sBuffer.append(subString + ",");
                    }
                }
//                System.out.println(sBuffer);
                if (sBuffer.length() != 0) {
                    break;
                }
            }
            String[] split = sBuffer.toString().replaceAll(",$", "").split("\\,");
            return split;
        }

        return null;
    }

    public static void main(String[] args) {
        String str1 = "asdafghjka";
        String str2 = "aaasdfg";
       /* String str1 = "abcwerthello1yuiodefabcdef";
        String str2 = "cvhello1bnmabcdef";*/
        System.out.println("两个字符串为:");
        System.out.println(str1);
        System.out.println(str2);

        MaxSubString mss = new MaxSubString();
        String[] maxSameStrings = mss.getMaxSameString1(str1, str2);
        System.out.println("他们的最大子串为: " + Arrays.toString(maxSameStrings));

    }
}
