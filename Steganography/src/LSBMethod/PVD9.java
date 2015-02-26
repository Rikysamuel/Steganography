/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.PixelPos;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Rikysamuel
 */
public class PVD9 {
    private final Common com;
    private List<PixelPos> blocks;
    
    public PVD9(String filename) throws IOException{
        com = new Common(filename);
    }
    
    public void initBlocks(){
        int len = com.stream.length;
        
    }
}
