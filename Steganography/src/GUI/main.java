/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.PVD9;
import java.io.FileNotFoundException;
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
    public static void main(String[] args) throws FileNotFoundException, IOException {
        PVD9 p = new PVD9("D:\\tes\\imgtes.jpg");
//          PVD9 p = new PVD9("D:\\tes\\result.jpg");
//          p.extractMessageFromBlock(0, 0);
//        p.hideMsg();
        p.processBlock(0, 0);
        p.Flush("D:\\tes\\result.jpg");
    }
}
