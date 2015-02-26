/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rikysamuel
 */
public class Block9 {
    PixelPos p;
    List<PixelPos> block;
    List<int[]> Dval;
    
    public Block9() {
        Dval = new ArrayList<>();
        p = new PixelPos();
        block = new ArrayList<>();
    }
    
    public void add(PixelPos p){
        block.add(p);
    }
    
    public void setVal(int pos, int val1, int val2, int val3){
        int temp[] = new int[3];
        temp[0] = val1;
        temp[1] = val2;
        temp[2] = val3;
        Dval.add(temp);
    }
}
