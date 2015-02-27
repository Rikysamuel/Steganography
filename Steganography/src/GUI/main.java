/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import common.Common;
import common.Block4;
import java.io.FileNotFoundException;
import java.io.IOException;
import LSBMethod.PVD4;
import LSBMethod.PVD9;
import LSBMethod.Standard;
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

		Common com = new Common("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");

		PlainText plainteks = new PlainText("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\ConquerTheWorld.txt");
		System.out.println(plainteks.ptByte);
		System.out.println(com.bitToText(plainteks.ptByte));
    }
}
