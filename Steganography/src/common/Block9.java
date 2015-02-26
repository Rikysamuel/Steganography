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
    int[] dmin;
    int[] xmin;
    
    public Block9() {
        p = new PixelPos();
        block = new ArrayList<>();
        dmin = new int[3];
        xmin = new int[3];
    }
    
    // create a block, set xmin-red, set xmin-green, set xmin-blue
    public List<PixelPos> createBlock(int iOffset, int jOffset, int[][] mat1, int[][] mat2, int[][] mat3){
        xmin[0] = 999;
        xmin[1] = 999;
        xmin[2] = 999;
        // row 1
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        
        // row 2
        iOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        
        //row 3
        iOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        jOffset++;
        p.setI(iOffset);
        p.setJ(jOffset);
        p.setScore(mat1[iOffset][jOffset], mat2[iOffset][jOffset], mat3[iOffset][jOffset]);
        if (mat1[iOffset][jOffset]<xmin[0]){
            xmin[0] = mat1[iOffset][jOffset];
        }
        if (mat2[iOffset][jOffset]<xmin[1]){
            xmin[1] = mat2[iOffset][jOffset];
        }
        if (mat3[iOffset][jOffset]<xmin[2]){
            xmin[2] = mat3[iOffset][jOffset];
        }
        block.add(p);
        
        return block;
    }

    // find d-red, d-green, d-blue
    public void getDmin(int iOffset, int jOffset, int[][] mat1, int[][] mat2, int[][] mat3){
        int[] tmin = null;
        tmin[0] = 999;
        tmin[1] = 999;
        tmin[2] = 999;
        
        for (int i = 0; i < 9; i++) {
            tmin[0] += (mat1[iOffset][jOffset] - xmin[0]);
            tmin[1] += (mat2[iOffset][jOffset] - xmin[1]);
            tmin[2] += (mat3[iOffset][jOffset] - xmin[2]);
        }
        
        dmin[0] = 1/8 * tmin[0];    // d-red
        dmin[1] = 1/8 * tmin[1];    // d-green
        dmin[2] = 1/8 * tmin[2];    // d-blue
    }

}
