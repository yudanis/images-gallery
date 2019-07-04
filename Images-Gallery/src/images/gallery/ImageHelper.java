/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images.gallery;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author ytr
 */
public class ImageHelper {
    public static Image GetScaledImg(int width, int height, String filename){
           BufferedImage img = null;
                try {
                    img = ImageIO.read(new File(filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Image dimg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
             return dimg;
    }
}
