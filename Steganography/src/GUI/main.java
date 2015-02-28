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
//        PVD9 p = new PVD9("D:\\tes\\imgtes.jpg");
////          PVD9 p = new PVD9("D:\\tes\\result.jpg");
////          p.extractMessageFromBlock(0, 0);
////        p.hideMsg();
//        p.processBlock(0, 0);
//        p.Flush("D:\\tes\\result.jpg");
        String result = "";
		int ascii;
		String bitProcess;
                String tes ="01100001010000010110000101000001011000010100000101100001010000010110000101000001";
		while(tes.length()>0){
			bitProcess = tes.substring(0,8);
			ascii = Integer.parseInt(bitProcess,2);
			result += (char)ascii;
			tes = tes.substring(8);
		}
		System.out.println( result );
    }
}
