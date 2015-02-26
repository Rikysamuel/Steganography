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
    private final PixelPos p;
    
    public PVD9(String filename) throws IOException{
        com = new Common(filename);
        b = new Block9();
        blocks = new ArrayList<>();
        p = new PixelPos();
        
        com.imageToPix();
    }
    
    public void setBlock(int iOffset, int jOffset){
        // row 1
        p.setI(iOffset);
        p.setJ(jOffset);
        b.add(p);
        p.setI(iOffset);
        p.setJ(jOffset+1);
        b.add(p);
        p.setI(iOffset);
        p.setJ(jOffset+2);
        b.add(p);
        
        // row 2
        p.setI(iOffset+1);
        p.setJ(jOffset);
        b.add(p);
        p.setI(iOffset+1);
        p.setJ(jOffset+1);
        b.add(p);
        p.setI(iOffset+1);
        p.setJ(jOffset+2);
        b.add(p);
        
        //row 3
        p.setI(iOffset+2);
        p.setJ(jOffset);
        b.add(p);
        p.setI(iOffset+2);
        p.setJ(jOffset+1);
        b.add(p);
        p.setI(iOffset+2);
        p.setJ(jOffset+2);
        b.add(p);
        
        // add to block
        blocks.add(b);
    }
}
