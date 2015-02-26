/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import common.Common;
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
        Common c = new Common();
        c.writeToByte("D:\\Photograph\\libur akhir 2014\\pulang.jpg");
        System.out.println(c.stream.length);
        System.out.println(c.getBits(c.stream[125]));
        c.stream[125] = c.changeBit(c.stream[125],8,0);
        System.out.println(c.getBits(c.stream[125]));
        c.convertToImage("D:\\Photograph\\libur akhir 2014\\pulang222.jpg");
    }
}
