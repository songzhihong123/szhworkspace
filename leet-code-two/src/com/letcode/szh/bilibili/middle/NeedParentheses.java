package com.letcode.szh.bilibili.middle;

/**
 * @ClassName NeedParentheses
 * @Description NeedParentheses
 * @Author szh
 * @Date 2024年01月11日
 */
public class NeedParentheses {

    /*

        一个完整的括号字符串定义规则如下：
        1、空字符串是完整的
        2、如果s是完整的字符串，那么(s)也是完整的
        3、如果s和t是完整的字符串， 将他们链接起来形成的st也是完整的。

        ”(()())“、“(())()” 完整
        “())(” 、 “()(”、“)” 不完整

        妞妞又一个括号字符串s，现在需要在其中任意位置尽量少的添加括号，将其
        转化为一个完整的括号字符串。请问妞妞至少需要添加多少个括号。

     */

    public static int needParentheses(String str){
        int count = 0;
        int ans = 0;

        for(int i = 0 ; i < str.length() ; i ++){

            if(str.charAt(i) == '('){
                count ++;
            }else{
                if(count == 0){
                    ans ++;
                }else{
                    count --;
                }
            }
        }
        return count + ans;
    }




}
