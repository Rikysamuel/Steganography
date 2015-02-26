/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Block9;
import common.Common;
import common.PixelPos;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rikysamuel
 */
public class PVD9 {
    private final Common com;
    private final List<Block9> blocks;
    private final Block9 b;
    private PixelPos p;
    private int[] rule;
    
    public PVD9(String filename) throws IOException{
        com = new Common(filename);
        b = new Block9();
        blocks = new ArrayList<>();
        p = new PixelPos();
        
        com.imageToPix();
    }
    
    public void processBlock(int iOffset, int jOffset) throws IOException{
        b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
        b.getDiff(iOffset, jOffset);
        rule = b.LSBRule();
        p = b.getPix(7);
        System.out.println(com.redPix[p.getI()][p.getJ()]);
        System.out.println(com.integerToBit(com.redPix[p.getI()][p.getJ()]));
        System.out.println(rule[0] + " " + rule[1] + " " + rule[2]);
//        System.out.println(rule[1]);
//        System.out.println(rule[2]);
        for(int i=0;i< com.height;i++){
            for(int j=0;j<com.width;j++){
                com.editPixel(1, i, j, 251);
                com.editPixel(2, i, j, 251);
                com.editPixel(3, i, j, 251);
            }
        }
        System.out.println(com.redPix[p.getI()][p.getJ()]);
        System.out.println(com.integerToBit(com.redPix[p.getI()][p.getJ()]));
        com.flush("D:\\tes\\result.jpg");
    }
    
    
}
