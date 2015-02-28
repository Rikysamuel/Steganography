/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD4;
import LSBMethod.PVD9;
import common.Common;
import java.io.FileNotFoundException;
import java.io.IOException;
import common.PlainText;


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
//        PlainText plainteks = new PlainText("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\plaintext.txt");
		Common com = new Common("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
//		plainteks.setStreamPT();
//		System.out.println(plainteks.ptByte);
		
//		PlainText plainteks = new PlainText("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
//		System.out.println(plainteks.ptByte);
//		System.out.println(com.bitToText(plainteks.ptByte));
//		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes3.bmp");
//		temp.process(plainteks.ptByte,"encrypt");
//		temp.Flush("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result3.bmp");

		PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result3.bmp");
		temp.process("","decrypt");
		System.out.println(temp.getPlainTeks());
		
//		PVD9 p = new PVD9("D:\\tes\\imgtes.jpg");
//        p.hideMsg();
//        p.Flush("D:\\tes\\result.jpg");
		
    }
}
