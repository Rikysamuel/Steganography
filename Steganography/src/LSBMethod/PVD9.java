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
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final String text;
    private String extractedtext;
    private int pointer;
    private int pointerres;
    
    public PVD9(String filename) throws IOException{
        text = "00000000111111111";
        extractedtext = null;
        pointer = 0; pointerres = 0;
        com = new Common(filename);
        b = new Block9();
        blocks = new ArrayList<>();
        p = new PixelPos();
        
        com.imageToPix();
       System.out.println(com.integerToBit(com.alphaPix[2][2]));
       System.out.println(com.integerToBit(com.redPix[2][2]));
       System.out.println(com.integerToBit(com.greenPix[2][2]));
       System.out.println(com.integerToBit(com.bluePix[2][2]));
    }
    
    public void processBlock(int iOffset, int jOffset){
        b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
        b.getDiff(iOffset, jOffset);
        rule = b.LSBRule();
        char[] temp;
        int it;
        int counter = 0;
        
        for(int i=0;i<8;i++){
            p = b.getPix(i);
            // embedd to red
            it = 0;
            while (pointer<text.length() && it < rule[0]){
                temp = com.integerToBit(com.redPix[iOffset][jOffset]).toCharArray();
                temp[7-it] = text.charAt(pointer);
                com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
                it++; pointer++;
            }
            // embedd to green
            it=0;
             
            while (pointer<text.length() && it < rule[1]){
                temp = com.integerToBit(com.greenPix[iOffset][jOffset]).toCharArray();
                temp[7-it] = text.charAt(pointer);
                com.editPixel(2, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
                it++; pointer++;
            }
            // embedd to blue
            it=0;
            while (pointer<text.length() && it < rule[2]){
                temp = com.integerToBit(com.greenPix[iOffset][jOffset]).toCharArray();
                temp[7-it] = text.charAt(pointer);
                com.editPixel(3, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
                it++; pointer++;
            }
            jOffset++;
            counter++;
            if(counter==3){
                iOffset++;
                jOffset = jOffset - 3;
                counter = 0;
            }
        }
        
        p = b.getPix(8);
        // flag to red
        it = 0;
        temp = com.integerToBit(com.redPix[iOffset][jOffset]).toCharArray();
        String t = String.valueOf(temp);
        while (t.length()<8){
            t = '0' + t;
            temp = t.toCharArray();
        }
        if (rule[0]==2){
            temp[6] = '0'; temp[7]='0';
            com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
        }
        if (rule[0]==3){
            temp[6] = '0'; temp[7]='1';
            if (pointer<text.length() && it < rule[0]){
                temp[5] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[0]==4){
            temp[6] = '1'; temp[7]='0';
            if (pointer<text.length() && it < rule[0]){
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[0]==5){
            temp[6] = '1'; temp[7]='1';
            if (pointer<text.length() && it < rule[0]){
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
            }

        }
        
        com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
            
        // flag to green
        temp = com.integerToBit(com.greenPix[iOffset][jOffset]).toCharArray();
        t = String.valueOf(temp);
        while (t.length()<8){
            t = '0' + t;
            temp = t.toCharArray();
        }
        it = 0;
        if (rule[1]==2){
            temp[6] = '0'; temp[7]='0';
        }
        if (rule[1]==3){
            temp[6] = '0'; temp[7]='1';
            if (pointer<text.length() && it < rule[1]){
                temp[5] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[1]==4){
            temp[6] = '1'; temp[7]='0';
            if (pointer<text.length() && it < rule[1]){
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[1]==5){
            temp[6] = '1'; temp[7]='1';
            if (pointer<text.length() && it < rule[1]){
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
            }

        }
        com.editPixel(2, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
        
        // flag to blue
        temp = com.integerToBit(com.bluePix[iOffset][jOffset]).toCharArray();
        t = String.valueOf(temp);
        while (t.length()<8){
            t = '0' + t;
            temp = t.toCharArray();
        }
        if (rule[2]==2){
            temp[6] = '0'; temp[7]='0';
        }
        if (rule[2]==3){
            temp[6] = '0'; temp[7]='1';
            if (pointer<text.length() && it < rule[2]){
                temp[5] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[2]==4){
            temp[6] = '1'; temp[7]='0';
            if (pointer<text.length() && it < rule[2]){
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
        }
        if (rule[2]==5){
            temp[6] = '1'; temp[7]='1';
            if (pointer<text.length() && it < rule[2]){
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
            }

        }
        com.editPixel(3, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
    }
    
    public void hideMsg(){
        int i=0; int j=0;
        while(i<com.height-1){
            if(j<com.width-1){
                System.out.println("i:" + i + " and j: " + j);
                processBlock(i,j);
                j=j+3;
            } else{
                j=0;
                i=i+3;
            }
        }
    }
    
    public char[] extractMessageFromBlock(int iOffset, int jOffset){
       char[] result = null;
       b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
       char[] temp;
       int it;
       int counter = 0;
       System.out.println(com.integerToBit(com.alphaPix[2][2]));
       System.out.println(com.integerToBit(com.redPix[2][2]));
       System.out.println(com.integerToBit(com.greenPix[2][2]));
       System.out.println(com.integerToBit(com.bluePix[2][2]));
       
       return result;
    }
    
    public String extractMsg(){
        String temp = "";
        int i=0; int j=0;
        while(i<com.height-1){
            if(j<com.width-1){
                System.out.println("i:" + i + " and j: " + j);
                temp+=extractMessageFromBlock(i,j);
                j=j+3;
            } else{
                j=0;
                i=i+3;
            }
        }
        return temp;
    }
    
    public void Flush(String outfile) throws IOException{
        System.out.println(com.integerToBit(com.alphaPix[2][2]));
       System.out.println(com.integerToBit(com.redPix[2][2]));
       System.out.println(com.integerToBit(com.greenPix[2][2]));
       System.out.println(com.integerToBit(com.bluePix[2][2]));
        com.flush(outfile);
    }
    
}
