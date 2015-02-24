/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package steganography;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Rikysamuel
 */
public class Common {
    
    public Common(){
        
    }
    
    public void convertToImage(String dirName, String filename) throws IOException{
    }
    
    public String writeToBit(String input, String output) throws FileNotFoundException, IOException{
        File file = new File("D:\\tes\\Rome.png");
 
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        byte[] buf = new byte[4096];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                //Writes to this byte array output stream
                bos.write(buf, 0, readNum); 
//                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
 
        byte[] bytes = bos.toByteArray();
        
        
//        
//        
//        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
//        Iterator<?> readers = ImageIO.getImageReadersByFormatName("png");
// 
//        //ImageIO is a class containing static methods for locating ImageReaders
//        //and ImageWriters, and performing simple encoding and decoding. 
// 
//        ImageReader reader = (ImageReader) readers.next();
//        Object source = bis; 
//        ImageInputStream iis = ImageIO.createImageInputStream(source); 
//        reader.setInput(iis, true);
//        ImageReadParam param = reader.getDefaultReadParam();
// 
//        Image image = reader.read(0, param);
//        //got an image file
// 
//        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
//        //bufferedImage is the RenderedImage to be written
// 
//        Graphics2D g2 = bufferedImage.createGraphics();
//        g2.drawImage(image, null, null);
// 
//        File imageFile = new File("D:\\tes\\NewRome.png");
//        ImageIO.write(bufferedImage, "png", imageFile);
// 
//        System.out.println(imageFile.getPath());
//        
//        output = bytes.toString();
        return output;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Common c = new Common();
        System.out.println(c.writeToBit("D:\\tes.jpg", "out.txt"));
        // TODO code application logic here
//        String tes = "AA";
//        Character a = 5;
//        String sosol = new BigInteger(tes.getBytes()).toString(2);
//        sosol = "00" + sosol;
////        System.out.println(a.toString());
//        System.out.println(sosol);
    }
    
}
