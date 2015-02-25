/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.Pixel;
import java.io.IOException;

/**
 *
 * @author Rikysamuel
 */
public class PVD4 {
    
    private final Pixel[] blocks;
    private final Common com;
    
    public PVD4(String filename) throws IOException{
        blocks = new Pixel[9];
        com = new Common();
        com.writeToByte(filename);
    }
    
    public void initBlocks(){
        int len = com.stream.length;
        
    }
}
