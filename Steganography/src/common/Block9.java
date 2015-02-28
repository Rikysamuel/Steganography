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
    private List<PixelPos> p;
//    private List<PixelPos> block;
    double[] dmin;
    int[] xmin;
    
    public Block9() {
        p = new ArrayList<>();
//        block = new ArrayList<>();
        dmin = new double[3];
        xmin = new int[3];
        
        for (int i = 0; i < 9; i++) {
            p.add(new PixelPos());
        }
    }

    public PixelPos getPix(int pos) {
        return p.get(pos);
    }
    
    // create a block, set xmin-red, set xmin-green, set xmin-blue
    public void createBlock(int iOffset, int jOffset, int[][] mat1, int[][] mat2, int[][] mat3){
        int jstart = jOffset;
        xmin[0] = 999;
        xmin[1] = 999;
        xmin[2] = 999;
        // row 1
        p.get(0).setI(iOffset);    //col 1
        p.get(0).setJ(jOffset);
        p.get(0).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(1).setI(iOffset); //col 2
        p.get(1).setJ(jOffset);
        p.get(1).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(2).setI(iOffset); // col 3
        p.get(2).setJ(jOffset);
        p.get(2).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        
        // row 2
        jOffset = jstart;
        iOffset++;
        p.get(3).setI(iOffset);
        p.get(3).setJ(jOffset);
        p.get(3).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(4).setI(iOffset);
        p.get(4).setJ(jOffset);
        p.get(4).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(5).setI(iOffset);
        p.get(5).setJ(jOffset);
        p.get(5).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        
        //row 3
        jOffset = jstart;
        iOffset++;
        p.get(6).setI(iOffset);
        p.get(6).setJ(jOffset);
        p.get(6).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(7).setI(iOffset);
        p.get(7).setJ(jOffset);
        p.get(7).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        jOffset++;
        p.get(8).setI(iOffset);
        p.get(8).setJ(jOffset);
        p.get(8).setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
    }

    // find d-red, d-green, d-blue
    public void getDiff(int iOffset, int jOffset){
        int[] tmin = new int[3];
        tmin[0] = 0;
        tmin[1] = 0;
        tmin[2] = 0;
        
        int k = 0;
        for (int i = iOffset; i < iOffset+3; i++) {
            for (int j = jOffset; j < jOffset+3; j++) {
                tmin[0] = tmin[0] + (p.get(k).getVal()[0] - xmin[0]);
                tmin[1] = tmin[1] + (p.get(k).getVal()[1] - xmin[1]);
                tmin[2] = tmin[2] + (p.get(k).getVal()[2] - xmin[2]);
                k++;
            }
        }
        
        dmin[0] = tmin[0]/8;    // d-red
        dmin[1] = tmin[1]/8;    // d-green
        dmin[2] = tmin[2]/8;    // d-blue
    }
    
    // get LSB Rule
    public int[] LSBRule(){
        int[] rule = new int[3];
        // Red rule
        if (dmin[0]<=7){
            rule[0] = 2;
        } else{
            if (dmin[0]>=8 && dmin[0]<=15){
                rule[0] = 3;
            } else{
                if (dmin[0]>=16 && dmin[0]<=31){
                    rule[0] = 4;
                } else{
                    rule[0] = 5;
                }
            }
        }
        
        // Green rule
        if (dmin[1]<=7){
            rule[1] = 2;
        } else{
            if (dmin[1]>=8 && dmin[1]<=15){
                rule[1] = 3;
            } else{
                if (dmin[1]>=16 && dmin[1]<=31){
                    rule[1] = 4;
                } else{
                    rule[1] = 5;
                }
            }
        }
        
        // Blue rule
        if (dmin[2]<=7){
            rule[2] = 2;
        } else{
            if (dmin[2]>=8 && dmin[2]<=15){
                rule[2] = 3;
            } else{
                if (dmin[2]>=16 && dmin[2]<=31){
                    rule[2] = 4;
                } else{
                    rule[2] = 5;
                }
            }
        }
        
        return rule;
    }
}
