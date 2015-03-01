/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD4;
import LSBMethod.PVD9;
import common.Common;
import common.PlainText;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;
import vigenerecipher.VigenereCipher;

/**
 *
 * @author Rikysamuel
 */
public class main {
   
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
//        PVD9 p = new PVD9("D:\\tes\\lenna.bmp","D:\\tes\\infile.txt");
//        p.initProcess(0);
//        p.hideMsg();
//        p.Flush("D:\\tes\\outfile.bmp");
//        System.out.println(p.countPSNR());
//        System.out.println(p.extractMsg());
//        PlainText plainteks = new PlainText("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\plaintext.txt");
//		Common com = new Common("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
//		plainteks.setStreamPT();
//		System.out.println(plainteks.ptByte);
		
//		System.out.println("woi");
//		VigenereCipher vc = new VigenereCipher();
//		System.out.println(vc.FileReader("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt"));
		//System.out.println(vc.processExtended());
		
//		List<Integer> listTemp = new ArrayList<>();
//		System.out.println(com.getKeySeed("STEGANO"));
//		listTemp = com.randomSeed(com.getKeySeed("STEGANO"),9);
//		for(Integer i:listTemp){
//			System.out.println(i);
//		}
//		for(int i =0;i<=8;i++){
//			System.out.println(com.randomPositionFromSeed(100, 9));
//		}
		
		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\lenna\\boat.bmp");
		temp.process("hide","Kripto","C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
		temp.Flush("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\resultBoat.bmp");
		System.out.println("PSNR="+temp.countPSNR());
		System.out.println("max data="+temp.maxData);
		
//		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result5.bmp");
//		temp.process("extract","STEGANO","C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
//		System.out.println(temp.getPlainTeks());
    }
}
