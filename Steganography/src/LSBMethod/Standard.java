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
    public double sum = 0.0;
    

    public Standard(String fimg, String fpt, String fstego) throws IOException {
        this.filenameImg = fimg;
        this.filenamePT = fpt;
        this.filenameSImg = fstego;
        //untuk mode penyisipan
        if (filenameImg != "" && filenamePT != ""){
            this.img = new Common(filenameImg);
            img.writeToByte(filenameImg);
            this.pt = new PlainText(filenamePT);
            pt.setStreamPT();
            pt.ptByte += "010001010100111101000110"; //tambah EOF
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
        int T;
        String ptemp="";
        if (counterPT < counter){
            //ubah plaintext ke string of bit 
            for (int i = 0 ; i < counterPT ; i++){
                ptemp += pt.getBits(pt.streamPT[i]);
            }
            //cek string of bit plainteks
            System.out.println("string of bit plainteks "+ptemp);
            //masukkan bit plainteks ke byte gambar; mulai dari byte ke 1078
            System.out.println(ptemp.length());
            for (int i = offset; i < ptemp.length()+offset; i++){
                //versi: cek byte mula-mula dan byte setelah dimasuki bit pesan
                System.out.println("origin: "+img.getBits(img.stream[i]));
                T = img.bitToInteger(img.getBits(img.stream[i]));
                int t = ptemp.charAt(i-offset) - '0';
                img.stream[i] = img.changeBit(img.stream[i], 1, t);
                System.out.println("ubah: "+img.getBits(img.stream[i]));
                T -= img.bitToInteger(img.getBits(img.stream[i]));
                sum += pow(T,2);
            }
        }
//        this.img.convertToImage(filenameImg);
    }
    
    public void saveStegoImg (String s) throws IOException{
        filenameSImg = s;
        this.img.convertToImage(filenameSImg);
    }
    
    public void extract() throws IOException{
        int offset = 1078;
        int count = stimg.stream.length - offset;
        int i = offset;
        String ext;
        String result = "";
        do{
            ext = "";
            for (int j = i; j < i+24; j++){
                ext += stimg.getBits(stimg.stream[j]).charAt(7);
                System.out.println(ext);
            }
            if (stimg.bitToText(ext)!="EOF"){
                result += stimg.bitToText(ext);
                System.out.println(result);
            }
            i += 24;
            
        } while (i < count+offset && stimg.bitToText(ext)!="EOF");
       
        
        System.out.println(result);
    }
    
    public void countPSNR(){
        int offset = 1078;
        int M = img.width;
        int N = img.height;
        int MN = (M*N);
        System.out.println("MN "+MN);
        System.out.println("N "+N);
        System.out.println("M "+M);
        double temp=0.0;
        double rms;
        rms = pow(((sum/M)/N),0.5);
        System.out.println("rms "+rms);
        this.psnrStd = (20 * log10(256/rms));
//        System.out.format("%.3f", this.psnrStd);
        System.out.println("PSNR :"+this.psnrStd);
    }
    
}
