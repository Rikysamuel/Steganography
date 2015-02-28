/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD9;
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
        PVD9 p = new PVD9("D:\\tes\\input.bmp");
//        p.processBlock(0, 0);
        p.hideMsg();
        p.Flush("D:\\tes\\result.bmp");
        
        PVD9 p2 = new PVD9("D:\\tes\\result.bmp");
//        String temp = p2.extractMessageFromBlock(0, 0);
//        System.out.println(temp);
//        System.out.println(temp.length());
        System.out.println(p2.extractMsg(24));
//        System.out.println(p.bit8("1010"));
    }
}
