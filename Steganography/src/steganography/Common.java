/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steganography;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
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
        
    }
    
    public void convertToImage(String filename) throws IOException{
        ByteArrayInputStream bis = new ByteArrayInputStream(stream);
        Iterator<?> readers = ImageIO.getImageReadersByFormatName(extention); 
 
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
        ImageIO.write(bufferedImage, extention, imageFile);
 
        System.out.println(imageFile.getPath());
    }
    
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
    
    public String getBits(byte b){
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
    
    public byte changeBit(byte b, int pos, int val){
        if (val==1){
            b = (byte) (b | (1 << (pos-1)));
            System.out.println(getBits(b));
        }
        if (val==0){
            b = (byte) (b & ~(1 << (pos-1)));
            System.out.println(getBits(b));
        }
        return b;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Common c = new Common();
        c.writeToByte("D:\\tes\\Rome.png");
        System.out.println(c.getBits(c.stream[0]));
        c.changeBit(c.stream[0],4,0);
        System.out.println(c.getBits(c.stream[0]));
        
//        c.convertToImage("D:\\tes\\tes.bmp");
//        c.convertToImage("D:\\tes\\newRome2tes.png",c.writeToBit("D:\\tes\\Rome.png", 3));
        // TODO code application logic here
//        String tes = "AA";
//        Character a = 5;
//        String sosol = new BigInteger(tes.getBytes()).toString(2);
//        sosol = "00" + sosol;
////        System.out.println(a.toString());
//        System.out.println(sosol);
    }
    
}
