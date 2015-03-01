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
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import vigenerecipher.VigenereH;

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
    public double psnrStd;
    public byte[] unchanged;
    

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
            System.out.println("string of bit plainteks"+ptemp);
            unchanged = img.stream;
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
        VigenereH cip = new VigenereH();
        cip.setCipher(ext);
        cip.setKunci(key);
        cip.decryptExtended();
        System.out.println(cip.getPesan());
    }
    
    public void countPSNR(){
        int offset = 1078;
        int M = img.height;
        int N = img.width;
        int MN = (M*N);
        System.out.println("MN "+MN);
        System.out.println("N "+N);
        System.out.println("M "+M);
        double temp=0;
        double rms;
        for(int i = 0 ; i < MN ;i++){
            String unc = img.getBits(unchanged[i+offset]);
            String org = img.getBits(img.stream[i+offset]);
            temp += pow(((img.bitToInteger(unc))-img.bitToInteger(org)),2);
//            System.out.println(temp);
        }
//        System.out.format("%.3f", temp);
        rms = sqrt((temp/M)/N);
        System.out.println("rms "+rms);
        this.psnrStd = (20 * log10(256/rms));
//        System.out.format("%.3f", this.psnrStd);
        System.out.println(this.psnrStd);
    }
    
}
