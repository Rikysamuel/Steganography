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
    private final int[] RGBArray;
    private final BufferedImage image;
    public final int width;
    public final int height;
    public int[][] alphaPix;
    public int[][] redPix;
    public int[][] greenPix;
    public int[][] bluePix;
    
    
    public Common(String filename) throws IOException{
			File file = new File(filename);
			extention = filename.substring(filename.length()-3);

			image = ImageIO.read(file);
			width = image.getWidth();
			height = image.getHeight();
			RGBArray = image.getRGB(0,0,width,height,null,0,width);

			alphaPix = new int [height][width];
			redPix = new int [height][width];
			greenPix = new int [height][width];
			bluePix = new int [height][width];

			stream = null;
    }
    
    
    // Convert image to pixel
    public void imageToPix() throws IOException{
        int i=0;
        for(int row=0; row<height; row++)
        {
           for(int col=0; col<width; col++)
           {
              alphaPix[row][col] = ((RGBArray[i]>>24)&0xff);
              redPix[row][col] = ((RGBArray[i]>>16)&0xff);
              greenPix[row][col] = ((RGBArray[i]>>8)&0xff);
              bluePix[row][col] = (RGBArray[i]&0xff);
              i++;
           }
        }
    }
    
    public int bitToInteger(String binary){
        return Integer.parseInt(binary,2);
    }
    
    public String integerToBit(int val){
		String temp = Integer.toBinaryString(val);
        while(temp.length() < 8){
			temp = '0' + temp;
		}
		return temp;
//		return Integer.toBinaryString(val);
    }
    
    // edit array el with a certain value
    public void editPixel(int TRGB, int i, int j, int val){
        if (TRGB==0){
            alphaPix[i][j]=val;
        }
        if (TRGB==1){
            redPix[i][j]=val;
        }
        if (TRGB==2){
            greenPix[i][j]=val;
        }
        if (TRGB==3){
            bluePix[i][j]=val;
        }
    }
    
    //flush the image
    public void flush(String outfile) throws IOException{
        System.out.println(extention);
        for(int row=0; row<height; row++)
         {
            for(int col=0; col<width; col++)
            {
               int rgb = (alphaPix[row][col] & 0xff) << 24 | (redPix[row][col] & 0xff) << 16 | (greenPix[row][col] & 0xff) << 8 | (bluePix[row][col] & 0xff);
               image.setRGB(col, row, rgb);
            }
         }
        ImageIO.write(image, extention, new File(outfile));
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
 
        Image img = reader.read(0, param);
 
        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
 
        Graphics2D g2 = bufferedImage.createGraphics();
        g2.drawImage(img, null, null);
 
        File imageFile = new File(filename);
        ImageIO.write(bufferedImage, "bmp", imageFile);
 
        System.out.println(imageFile.getPath());
    }
    
    // Convert image to array of bytes
    public void writeToByte(String filename) throws FileNotFoundException, IOException{
        File file = new File(filename);
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
	
	// return value of RGB in a certain place
    public int getIntegerPixel(int TRGB, int i, int j){
        int result = 0;
		if (TRGB==0){
            result = alphaPix[i][j];
        }
        if (TRGB==1){
            result = redPix[i][j];
        }
        if (TRGB==2){
            result = greenPix[i][j];
        }
        if (TRGB==3){
            result = bluePix[i][j];
        }
		return result;
    }
	
	// change binary string to text
	public String bitToText(String bit){
		String result = "";
		int ascii;
		String bitProcess;

		while(bit.length()>0){
			bitProcess = bit.substring(0,8);
			//System.out.println(bitProcess);
			ascii = bitToInteger(bitProcess);
			result += (char)ascii;
			bit = bit.substring(8);
		}
		return result;
	} 
    
}
