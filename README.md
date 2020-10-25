# Java_Basic
一阶段模块学习笔记：

https://github.com/jackzhang2000/Java_Basic


 十进制转成2进制，除二取余，直至商为0
45的二进制为0B10 1101=Java 7告诉系统是2进制
                    0开头8进制，0X开头16进制

... 128  64  32  16  8  4  2  1	
                  1   0   1  1  0  1

正二进制转为十进制，加权法
原码，反码，补码
除去符号，二进制正数先取反再加1
十进制转为-45为1101 0011
高位溢出

负二进制转10进制，所以先减一，再按位取反，添加一个负号

单个字节能表示的整数范围
2*8  -128~127 0111 1111
一个字节表示的负数的范围：1000 0000~1111 1111
                   即-128~-1
byte类型的整数范围：-2^7~2^7-1，即-128~127
short类型的整数范围：-2^15~2^15-1 占2个字节的整数-32768~32767
int类型占用4个字节：-2^31-2^31-1 
long占用8个字节：-2^63~2^63-1
数字后加L，long类型
java.math.BigInteger类型比Long还大

float占4个字节，部分位用来存幂位数
double占8个字节 -1.798E308~1.798E308

System.out.println(0.1 + 0.2);//0.30000000000000004
float和Double类型，运算时可能有误差，不能得到精确结果，商业开发不能使用, 需要用java.math.BigDecimal类型

char类型占用2个字节，65535个字符 单引号'' 单个中文字也可以
short类型也占用2个字节，有符号位
String类型双引号""
基本数据类型和引用数据类型

自动类型转换：小类型到大类型的转换
强制类型转换：大类型到小类型的转换
1字节    2字节   4字节  8字节    4字节    8字节
byte-->short-->int-->long-->float-->double
            chart

128
尽量不要做强制类型转换，强转有风险，操作需谨慎
byte short int long foat double boolean char 8个基本类型

Java运算符ia++：先用ia的值赋给表达式，然后再++
Java运算符++ia：先++，再用ia的值赋给表达式

&& 逻辑与 如果第一个条件为假，则第二个表达式不执行
||     逻辑或 如果第一个条件为真，则第二个表达式不执行
ia+=2 即为ia = ia+2

推荐2==ia的方式，判断2是否等于ia的值，防止把==写成=
2=ia会编译报错，规避错误。
<<左移 右边0补充 左移1位相当于*2, 2位相当于*4
>>右移 左边用符号位补充 右移1位正数相当于除以2
>>>逻辑右移，左边用0补充 逻辑右移1位正数相当于除以2

continue提前结束本次循环，开始下一次循环
break直接结束所有循环
for(;;) 无限循环

import java.util.Random;
Random ra = new Random();
ra.nextInt(100); 0-100间的整数

注意print和println的区别，前者不换行，后者换行

break outer; 跳出标号所在的循环体外

Stack存放局部变量int num=2; arr2中存放数组地址信息
Heap存放new关键字创建的变量 int[] arr2 = new int2[2]; 

int[][] = new int[2][6] 2行6列 2个一维数组

重载（overload）public class Overloading {
    public int test(){
        System.out.println("test1");
        return 1;
    }
 
    public void test(int a){
        System.out.println("test2");
    }   
 
    //以下两个参数类型顺序不同
    public String test(int a,String s){
        System.out.println("test3");
        return "returntest3";
    }   
 
    public String test(String s,int a){
        System.out.println("test4");
        return "returntest4";
    }   
 
    public static void main(String[] args){
        Overloading o = new Overloading();
        System.out.println(o.test());
        o.test(1);
        System.out.println(o.test(1,"test3"));
        System.out.println(o.test("test4",1));
    }
}重载方法满足的一些条件：（1）方法名相同。（2）方法的参数类型、个数、顺序至少有一项不同。（3）方法的返回值可以不同。（4）方法的修饰符可以不同。

