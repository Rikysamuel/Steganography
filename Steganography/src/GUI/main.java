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
//        PVD9 p = new PVD9("D:\\tes\\boat.bmp","D:\\tes\\infile.txt");
//        Common com = new Common("D:\\tes\\result.bmp");
//        if (p.initProcess()>0){
//            System.out.println(p.initProcess());
//            p.hideMsg();
//            p.Flush("D:\\tes\\result.bmp");
//            System.out.println(p.extractMsg());
        VigenereCipher vc = new VigenereCipher();
        vc.setStr(vc.FileReader("D:\\tes\\infile.txt"));
        vc.setKey("RIKY");
        vc.genKey();
        vc.processExtended();
        System.out.println(vc.getEncStr());
        
        vc.setStr(vc.getEncStr());
        vc.setKey("RIKY");
        vc.genKey();
        vc.processDecExtended();
        System.out.println(vc.getEncStr());
    }
}
