/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

/**
 *
 * @author Rikysamuel
 */
public class PixelPos {
    private int i;
    private int j;
    
    private final int[] val;
    
    public PixelPos(){
        val = new int[3];
        i=0;
        j=0;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public void setI(int i) {
        this.i = i;
    }

    public void setJ(int j) {
        this.j = j;
    }
    
    public void setScore(int val1, int val2, int val3){
        val[0] = val1;
        val[1] = val2;
        val[2] = val3;
    }
    
}
