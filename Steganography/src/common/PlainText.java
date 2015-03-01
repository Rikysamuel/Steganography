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
import vigenerecipher.Vigenere;
import vigenerecipher.VigenereCipher;


/**
 *
 * @author HP
 */
public class PlainText {
    private String pt;
//    public VigenereCipher vc;
//	public Vigenere vc;
    public byte[] streamPT;
    public String ptByte = "";
//    public String key;
    
    public PlainText (String filename) throws IOException{
        Path filein = Paths.get(filename);
//        this.key = key;
//        vc = new VigenereCipher();
//        String temp = vc.FileReader(filename);
//        vc.setStr(temp.toUpperCase());
//        vc.setKey(key.toUpperCase());
//        vc.genKey();
//        temp = vc.processExtended();
//		String temp;
//		vc = new Vigenere();
//		vc.encryptFile(filename, key);
//		vc.encryptVigenereCipherExtended();
//		temp = vc.getCiphertext();
//		System.out.println(vc.getCiphertext());
//		System.out.println(temp);
        streamPT = Files.readAllBytes(filein);// temp.getBytes(Charset.forName("UTF-8"));
		System.out.println("-finished construct PlainText-");
    }
    
//	public String getPlaintextAfterDecrypt(String cipher){
//		System.out.println("--DECRYPT IN PLAINTEXT CLASS--");
//		String plaintext="";
//		vc.setStr(cipher.toUpperCase());
//		System.out.println(cipher);
//		vc.setKey(key.toUpperCase());
//		System.out.println(key);
//		vc.genKey();
//		plaintext = vc.processDecExtended();
//		System.out.println(plaintext);
//		return plaintext;
//	}
	
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
}
