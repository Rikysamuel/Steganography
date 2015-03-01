/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import vigenerecipher.VigenereCipher;
import vigenerecipher.vigenere;

/**
 *
 * @author HP
 */
public class PlainText {
    private String pt;
    public vigenere vc;
    public byte[] streamPT;
    public String ptByte = "";
    public String key;
    
    public PlainText (String filename, String key) throws IOException{
        Path filein = Paths.get(filename);
        this.key = key;
        vc = new vigenere();
        String temp = vc.readFile(filename);
        vc.setPesan(temp);
        vc.setKunci(key);
//        vc.genKey();
        vc.encryptExtended();
        //cek
        System.out.println("cek hasil vigenere"+ vc.getCipher());
        streamPT = vc.getCipher().getBytes();
    }
    
    public void setPt(String s){
        this.pt = s;
    }
    
    public String getPt(){
        return this.pt;
    }
    
    public void setStreamPT(){
//        this.streamPT = pt.getBytes();
        for (int i = 0 ; i < streamPT.length ; i++){
            ptByte += getBits(streamPT[i]);
        }
    }
    
    public String getBits(byte b){
        return String.format("%8s", Integer.toBinaryString(b & 0xFF)).replace(' ', '0');
    }
    
    public void decrypt(){
        vc.decryptExtended();
    }
}
