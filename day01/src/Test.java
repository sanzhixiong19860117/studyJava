/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 12:02
 * <p>
 * 自定义trycatch的操作
 * 1.继承与Exception
 * 2.构造函数自定定义也可以进行抛出
 * 3.在try catch的时候使用自定义的类完成操作
 */
public class Test {
    public static void main(String[] args) {
        try {
            show();
        } catch (CustomizeTry customizeTry) {
            //这个地方是第三点
            customizeTry.printStackTrace();
        }
    }

    private static void show() throws CustomizeTry {
        String ss = "aaaa";
        if (ss.equals("man")) {
            System.out.println("man");
        } else if (ss.equals("woman")) {
            System.out.println("woman");
        } else {
            throw new CustomizeTry("性别异常");
        }
    }
}
