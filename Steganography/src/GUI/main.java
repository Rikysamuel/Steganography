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
import java.util.ArrayList;
import java.util.List;

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
//        PVD9 p = new PVD9("D:\\tes\\lenna.bmp","D:\\tes\\infile.txt");
//        p.hideMsg();
//        p.Flush("D:\\tes\\result.bmp");
//        
//        PVD9 p2 = new PVD9("D:\\tes\\result.bmp","");
//        System.out.println(p2.extractMsg());
        Common com = new Common("D:\\tes\\lenna.bmp");
        List<Integer> rand = new ArrayList<>();
        rand = com.randomSeed(30, 8);
        System.out.println(rand.toString());
    }
}
