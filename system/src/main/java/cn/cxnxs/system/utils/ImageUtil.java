package cn.cxnxs.system.utils;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.security.SecureRandom;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * <p></p>
 *
 * @author mengjinyuan
 * @date 2022-10-28 00:07
 **/
public class ImageUtil {
    private static final Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    public static BufferedImage buildImageVerify(String securityCode, int width, int height) {
        int length = securityCode.length();
        int fSize = (height - 1) / 2;
        int fWidth = fSize + 1;
        width = length * fWidth > width ? length * fWidth : width;
        BufferedImage image = new BufferedImage(width, height, 1);
        Graphics g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Arial", 1, height - 2));
        g.drawRect(0, 0, width - 1, height - 1);
        SecureRandom rand = new SecureRandom();
        g.setColor(Color.LIGHT_GRAY);

        int codeY;
        int i;
        for(codeY = 0; codeY < length * 6; ++codeY) {
            i = rand.nextInt(width);
            int y = rand.nextInt(height);
            g.drawRect(i, y, 1, 1);
        }

        codeY = height - 10;
        g.setColor(new Color(19, 148, 246));
        g.setFont(new Font("Georgia", 1, fSize));

        for(i = 0; i < length; ++i) {
            g.drawString(String.valueOf(securityCode.charAt(i)), i * fSize + 5, codeY);
        }

        g.dispose();
        return image;
    }

    public static void buildImageVerify(String securityCode, int width, int height, OutputStream os) {
        BufferedImage image = buildImageVerify(securityCode, width, height);
        convertImageToStream(image, os);
    }

    private static void convertImageToStream(BufferedImage image, OutputStream os) {
        try {
            ImageIO.write(image, "JPEG", os);
        } catch (IOException var3) {
            logger.error("错误信息", var3);
        }

    }
}
