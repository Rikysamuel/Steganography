/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD4;
import common.Common;
import java.io.FileNotFoundException;
import java.io.IOException;
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
//		Common com = new Common("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
//		plainteks.setStreamPT();
//		System.out.println(plainteks.ptByte);
		
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
