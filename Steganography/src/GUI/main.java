/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import LSBMethod.Standard;
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

        Common c = new Common("D:\\tes\\imgtes.jpg");
        c.imageToPix();
        System.out.println(c.greenPix[0][100]);
        System.out.println(c.integerToBit(c.greenPix[0][100]));

        for(int i=0;i< c.height;i++){
            for(int j=0;j<c.width;j++){
                c.editPixel(1, i, j, 255);
                c.editPixel(2, i, j, 255);
                c.editPixel(3, i, j, 255);
            }
        }
        
        c.flush("D:\\tes\\out-tes.jpg");
        System.out.println(c.greenPix[0][100]);
        System.out.println(Integer.toBinaryString(c.greenPix[0][100]));

//        Common c = new Common("D:\\tes\\untitled2.bmp");
//       
    }
}
