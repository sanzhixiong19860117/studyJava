/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 11:18
 */

/**
 * 1.使用new Exception 进行抛出异常
 * 2.在方法的外部需要结果 throws Exception
 * 3.使用的时候需要对方法进行捕获
 */
public class TryDemo1 {
    public static void main(String[] args) {
        try {
            test();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test() throws Exception{
        String ss = "aaaa";
        if(ss.equals("man")) {
            System.out.println("man");
        }else if(ss.equals("woman")){
            System.out.println("woman");
        }else{
            throw new Exception("性别出错");
        }
    }
}

