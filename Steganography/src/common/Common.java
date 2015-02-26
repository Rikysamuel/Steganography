/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

/**
 *
 * @author Rikysamuel
 */
public class Common {
    
    public byte[] stream;
    private String extention;
    
    public Common(){
       stream = null;
       extention = null;
    }
    
    // Convert array of byte to a certain Image
    public void convertToImage(String filename) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(stream);
        Iterator<?> readers = ImageIO.getImageReadersByFormatName("bmp"); 
 
        ImageReader reader = (ImageReader) readers.next();
        Object source = bis; 
        ImageInputStream iis = ImageIO.createImageInputStream(source); 
        reader.setInput(iis, true);
        ImageReadParam param = reader.getDefaultReadParam();
 
        Image image = reader.read(0, param);
 
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
 
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(image, null, null);
 
        File imageFile = new File(filename);
        ImageIO.write(bufferedImage, "bmp", imageFile);
 
        System.out.println(imageFile.getPath());
    }
    
    // Convert image to array of bytes
    public void writeToByte(String filename) throws FileNotFoundException, IOException{
        File file = new File(filename);
        extention = filename.substring(filename.length()-3);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
 
        byte[] bytes = bos.toByteArray();
        System.out.println(bytes.length);
        stream = bytes;
    }
    
    // return array of bits in a certain byte
    public String getBits(byte b){
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
    
    // change a bit in a certain of byte
    public byte changeBit(byte b, int pos, int val){
        if (val==1){
            b = (byte) (b | (1 << (pos-1)));
        }
        if (val==0){
            b = (byte) (b & ~(1 << (pos-1)));
        }
        return b;
    }
    
}
