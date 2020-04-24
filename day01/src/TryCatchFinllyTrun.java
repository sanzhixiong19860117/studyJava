/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 12:17
 * finlly 的基础使用
 */

//基础使用的
//不管是否有错误，finally都会执行
//finally的不论是否有错误都会执行
    /*
    try语句在返回前，将其他所有的操作执行完，保留好要返回的值，而后转入执行finally中的语句，而后分为以下三种情况：
    情况一：如果finally中有return语句，则会将try中的return语句”覆盖“掉，直接执行finally中的return语句，得到返回值，
    这样便无法得到try之前保留好的返回值。
    情况二：如果finally中没有return语句，也没有改变要返回值，则执行完finally中的语句后，会接着执行try中的return语句，
    返回之前保留的值。
    情况三：如果finally中没有return语句，但是改变了要返回的值，这里有点类似与引用传递和值传递的区别，分以下两种情况，：
    1）如果return的数据是基本数据类型或文本字符串，则在finally中对该基本数据的改变不起作用，
    try中的return语句依然会返回进入finally块之前保留的值。
    2）如果return的数据是引用数据类型，而在finally中对该引用数据类型的属性值的改变起作用，
    try中的return语句返回的就是在finally中改变后的该属性的值。
    */
public class TryCatchFinllyTrun {

    public static void main(String[] args) {
        //基础操作
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally基础使用");
        }
        //复杂操作1
        System.out.println(test());
        //复杂情况2
        System.out.println("复杂情况2=" + test1());
        //复杂情况3
        System.out.println("复杂情况3=" + test2());
    }

    //复杂操作
    //情况一（try中有return，finally中没有return）：
    //1.一定会进入到try里面，如果catch没有错误就不会执行，但是finally是一定会执行
    private static int test() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
        }
        return num;
    }

    //第二种try和finally都有
    private static int test1() {
        int num = 10;
        try {
            System.out.println("try");
            return num += 80;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 100;
            return num;
        }
    }

    //情况三（finally中改变返回值num）：
    private static int test2() {
        int num = 10;
        try {
            System.out.println("try");
            return num;
        } catch (Exception e) {
            System.out.println("error");
        } finally {
            if (num > 20) {
                System.out.println("num>20 : " + num);
            }
            System.out.println("finally");
            num = 100;
        }
        return num;
    }
}
