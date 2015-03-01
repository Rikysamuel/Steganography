/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.PlainText;
import vigenerecipher.VigenereCipher;
import java.io.IOException;

/**
 *
 * @author Rikysamuel, Hayyu LH
 */
public class Standard {
    private String filenameImg;
    private String filenamePT;
    private String filenameSImg;
    private String key;
    public Common img;
    public Common stimg;
    public PlainText pt;
    

    public Standard(String fimg, String fpt, String fstego, String key) throws IOException {
        this.filenameImg = fimg;
        this.filenamePT = fpt;
        this.filenameSImg = fstego;
        //untuk mode penyisipan
        if (filenameImg != "" && filenamePT != "" && key != ""){
            this.img = new Common(filenameImg);
            img.writeToByte(filenameImg);
            this.pt = new PlainText(filenamePT,key);
            pt.setStreamPT();
        } else {
            //untuk mode ekstraksi
            this.stimg = new Common(filenameSImg);
            stimg.writeToByte(filenameSImg);
        }
    }
    
    public void setKey(String k){
        this.key = k;
    }
   
    public void stegonize () throws IOException{
//        img.writeToByte(filenameImg);
        int offset = 1078;
        int counter = this.img.stream.length - offset;
        int counterPT = this.pt.streamPT.length;
        
        byte temp;
        String ptemp="";
        if (counterPT < counter){
            //ubah plaintext ke string of bit 
            for (int i = 0 ; i < counterPT ; i++){
                ptemp += pt.getBits(pt.streamPT[i]);
            }
            //cek string of bit plainteks
            System.out.println(ptemp);
            //masukkan bit plainteks ke byte gambar; mulai dari byte ke 1078
            for (int i = offset; i < ptemp.length()+offset; i++){
                //versi: cek byte mula-mula dan byte setelah dimasuki bit pesan
                System.out.println("origin: "+img.getBits(img.stream[i]));
                int t = ptemp.charAt(i-offset) - '0';
                img.stream[i] = img.changeBit(img.stream[i], 1, t);
                System.out.println("ubah: "+img.getBits(img.stream[i]));
            }
        }
//        this.img.convertToImage(filenameImg);
    }
    
    public void saveStegoImg (String s) throws IOException{
        filenameSImg = s;
        this.img.convertToImage(filenameSImg);
    }
    
    public void extract() throws IOException{
        this.stimg = new Common(filenameSImg);
        stimg.writeToByte(filenameSImg);
        int count = stimg.stream.length;
        String ext = "";
        for (int i =400 ; i < count; i++){
            ext += stimg.getBits(stimg.stream[i]).charAt(7);
        }
        //cek string of byte hasil ekstraksi
        System.out.println(ext);
    }
    
}
