/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD4;
import LSBMethod.PVD9;
import common.Common;
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
    public static void main(String[] args) throws IOException{
        PVD9 p = new PVD9("D:\\tes\\lenna.bmp","D:\\tes\\infile.txt");
//        p.tes(0,0);
        Common c = new Common("D:\\tes\\result.bmp");
//        p.processBlock(0, 0);
        p.hideMsg();
        p.Flush("D:\\tes\\result.bmp");
        
        PVD9 p2 = new PVD9("D:\\tes\\result.bmp","D:\\tes\\infile.txt");
//        p2.tes(0,0);
//        String temp = p2.extractMessageFromBlock(0, 0);
//        System.out.println(c.bitToText(temp));
//        System.out.println(temp.length());
        System.out.println(p2.extractMsg(28));
//        System.out.println(p.bit8("101"));
    }
}
