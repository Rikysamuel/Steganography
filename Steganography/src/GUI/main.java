/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD9;
import common.Common;
import java.io.FileNotFoundException;
import java.io.IOException;

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
        PVD9 p = new PVD9("D:\\tes\\boat.bmp","D:\\tes\\infile.txt");
        Common com = new Common("D:\\tes\\result.bmp");
//        int temp = p.initProcess();
////        temp = -1;
        if (p.initProcess()>0){
            System.out.println(p.initProcess());
            p.hideMsg();
            p.Flush("D:\\tes\\result.bmp");
//            System.out.println(p.countPSNR());
        }
        
//        PVD9 p2 = new PVD9("D:\\tes\\result.bmp","D:\\tes\\infile.txt");
//        System.out.println(p2.bitDiv8("1010101010101010"));
//        if(p.initProcess()>0){
            System.out.println(p.extractMsg());
//            System.out.println(c.bitToText(p2.bitDiv8(p2.extractMessageFromBlock(0, 0))));
//        }
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
		
//		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes3.bmp");
//		temp.process("hide","STEGANO","C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
//		temp.Flush("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result3.bmp");
//		System.out.println("PSNR="+temp.countPSNR());
		
//		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result5.bmp");
//		temp.process("extract","STEGANO","C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
//		System.out.println(temp.getPlainTeks());
    }
}
