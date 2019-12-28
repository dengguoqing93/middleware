import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 测试
 *
 * @author dengguoqing
 * @date 2019/12/28
 * @copyright spiral
 * @since 1.0 Version
 */

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedImage bufImg = ImageIO.read(new URL("https://mir-s3-cdn-cf.behance.net/project_modules/1400_opt_1/b43b3858567215.5a047aacb997b.jpg"));
        int wi = bufImg.getWidth();
        int he = bufImg.getHeight();
        System.out.println("宽度:" + wi + "高度:" + he);
    }
}
