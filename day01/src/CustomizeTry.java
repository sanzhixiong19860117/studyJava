/**
 * @author joy
 * @version 1.0
 * @date 2020/4/24 11:55
 */

/**
 * 自定义报错操作
 *
 */
public class CustomizeTry extends Exception {
    public CustomizeTry() {
        System.out.println("自定义报错");
    }

    public CustomizeTry(String msg) {
        System.out.println(msg);
    }
}
