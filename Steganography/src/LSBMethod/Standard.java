/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import java.io.IOException;

/**
 *
 * @author Rikysamuel, Hayyu LH
 */
public class Standard {
    private String filenameImg = "D:\\[6]\\IF4020 Kripto\\coret.bmp";
    private String filenamePT = "D:\\[6]\\IF4020 Kripto\\Tubes 1\\tes.txt";
    private Common img = new Common();
    private String plaintext = "";
    private Common pt = new Common();
    
    public void setPlaintext (String s){
        this.plaintext = s;
    }
    
    public String getPlaintext(){
        return this.plaintext;
    }
    
    public void setFilenameImg (String filein){
        this.filenameImg = filein;
    }
    
    public void printByteImg () throws IOException{
       img.writeToByte(this.filenameImg);
       pt.writeToByte(filenamePT);
    }
    
    public void stegonize () throws IOException{
        printByteImg();
//        for (int i=0;i<5;i++){
//            String ss = this.img.getBits(this.img.stream[i]);
//            System.out.println(ss);
//        }
        
        int counter = this.img.stream.length;
        int counterPT = this.pt.stream.length;
        byte temp;
        String ptemp="";
        if (counterPT < counter){
            //ubah plaintext ke string of bit 
            for (int i = 0 ; i < counterPT ; i++){
                ptemp += this.pt.getBits(this.pt.stream[i]);
            }
            
            for (int i = 0; i < ptemp.length(); i++){
                System.out.println("origin: "+img.getBits(img.stream[i]));
                int t = ptemp.charAt(i) - '0';
                img.stream[i] = img.changeBit(img.stream[i], 1, t);
                System.out.println("ubah: "+img.getBits(img.stream[i]));
            }
        }
        this.img.convertToImage("hasil.bmp");
//        System.out.println(this.pt.getBits(this.pt.stream[0]));
//        for (int i=0;i<5;i++){
//            String st = this.img.getBits(this.img.stream[i]);
//            System.out.println(st);
//        }
    }
    
    
}
