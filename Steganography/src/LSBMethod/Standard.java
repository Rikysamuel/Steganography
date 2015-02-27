/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.PlainText;
import java.io.IOException;

/**
 *
 * @author Rikysamuel, Hayyu LH
 */
public class Standard {
    private String filenameImg;
    private String filenamePT;
    private String filenameSImg;
    public Common img;
    private Common stimg;
    public PlainText pt;
    private String plaintext = "";
    

    public Standard(String fimg, String fpt) throws IOException {
        this.filenameImg = fimg;
        this.filenamePT = fpt;
        this.img = new Common(filenameImg);
        img.writeToByte(filenameImg);
        this.pt = new PlainText(filenamePT);
    }
    
    public void setPlaintext (String s){
        this.plaintext = s;
    }
    
    public String getPlaintext(){
        return this.plaintext;
    }
    
    public void setFilenameImg (String filein){
        this.filenameImg = filein;
    }
   
    public void stegonize () throws IOException{
        img.writeToByte(filenameImg);
        int counter = this.img.stream.length;
        int counterPT = this.pt.streamPT.length;
        byte temp;
        String ptemp="";
        if (counterPT < counter){
            //ubah plaintext ke string of bit 
            for (int i = 0 ; i < counterPT ; i++){
                ptemp += this.pt.getBits(this.pt.streamPT[i]);
            }
            
            for (int i = 0; i < ptemp.length(); i++){
                System.out.println("origin: "+img.getBits(img.stream[i]));
                int t = ptemp.charAt(i) - '0';
                img.stream[i] = img.changeBit(img.stream[i], 1, t);
                System.out.println("ubah: "+img.getBits(img.stream[i]));
            }
        }
        this.img.convertToImage(filenameSImg);
    }
    
    public void extract() throws IOException{
        this.stimg = new Common("hasil.bmp");
        this.stimg.writeToByte("hasil.bmp");
        int count = this.stimg.stream.length;
        String ext = "";
        for (int i =0 ; i < count; i++){
            ext += stimg.getBits(stimg.stream[i]).charAt(7);
        }
        System.out.println(ext);
    }
    
}
