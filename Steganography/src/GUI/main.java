/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

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
        PVD9 p = new PVD9("D:\\tes\\PeppersRGB.bmp","D:\\tes\\infile.txt");
//        Common c = new Common("D:\\tes\\input.bmp");
//        p.initProcess(25);
        p.hideMsg();
        p.Flush("D:\\tes\\result.bmp");
        
        PVD9 p2 = new PVD9("D:\\tes\\result.bmp","");
        System.out.println(p2.extractMessageFromBlock(0, 0));
//        System.out.println(p2.extractMsg());
    }
}
