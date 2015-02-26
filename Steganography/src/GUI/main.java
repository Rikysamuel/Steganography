/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import common.Common;
import java.io.FileNotFoundException;
import java.io.IOException;
import LSBMethod.PVD4;

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
        PVD4 temp = new PVD4("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
//		Common c = new Common();
//        c.writeToByte("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
//        System.out.println(c.stream.length);
//        System.out.println(c.getBits(c.stream[1]));
//        c.stream[1] = c.changeBit(c.stream[1],8,0);
//        System.out.println(c.getBits(c.stream[1]));
//        c.convertToImage("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\result.bmp");
		temp.encrypt();
    }
}
