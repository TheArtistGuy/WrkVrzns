package controller;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Fasst Operationen auf Bildern zusammen
 */

public interface PictureController {

    static Image createBitmap(Image image){
        return image.getScaledInstance(50,50,Image.SCALE_SMOOTH);
    }

    static Image loadImage(String filepath) throws IOException{
        File dat = new File(filepath);
        BufferedImage img = ImageIO.read(dat);
        return (Image) img;
    }

    /**
     *
     * @param imageToSave
     * @param outputfile
     * @param quality 1f = 100% 0.7f = 70%
     * @throws IOException
     */

    static void saveImage(Image imageToSave, File outputfile, float quality) throws IOException {

        BufferedImage image = (BufferedImage) imageToSave;
        ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(quality);

        jpgWriter.setOutput(ImageIO.createImageOutputStream(outputfile));
        IIOImage outputImage = new IIOImage(image, null, null);
        jpgWriter.write(null, outputImage, jpgWriteParam);
        jpgWriter.dispose();

    }

    /**
     *
     * @param imageToSave
     * @param outputfile
     * @param quality 1f = 100% 0.7f = 70%
     * @throws IOException
     */
    static void saveImage(Image imageToSave, String outputfile, float quality) throws IOException {
        BufferedImage image = (BufferedImage) imageToSave;
        File jpegFiletoSave = new File(outputfile);
        ImageWriter jpgWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam jpgWriteParam = jpgWriter.getDefaultWriteParam();
        jpgWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        jpgWriteParam.setCompressionQuality(quality);

        jpgWriter.setOutput(ImageIO.createImageOutputStream(jpegFiletoSave));
        IIOImage outputImage = new IIOImage(image, null, null);
        jpgWriter.write(null, outputImage, jpgWriteParam);
        jpgWriter.dispose();
    }
}