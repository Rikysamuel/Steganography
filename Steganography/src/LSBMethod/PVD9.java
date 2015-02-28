/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Block9;
import common.Common;
import common.PixelPos;
import common.PlainText;
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
    private final PlainText pt;
    private final List<Block9> blocks;
    private final Block9 b;
    private PixelPos p;
    private int[] rule;
    private final String text;
    private int pointer;
    private int pointerres;
    
    public PVD9(String filename, String textfile) throws IOException{
        com = new Common(filename);
        pt = new PlainText(textfile);
        pt.setStreamPT();
        text = pt.ptByte;
//        text = "101010101111111100000000";
//        text = "0110111001100001011011010110000100100000011100110110000101111001011000010010000001110010011010010110101101111001";
//        System.out.println(text);
//        System.out.println(text.length());
//        System.out.println("char ke 10: " + text.charAt(10));
        pointer = 0; pointerres = 0;
        b = new Block9();
        blocks = new ArrayList<>();
        p = new PixelPos();
        
        com.imageToPix();
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
                temp = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).toCharArray();
                temp[7-it] = text.charAt(pointer);
                com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
                it++; pointer++;
            }
            // embedd to green
            it=0;
            while (pointer<text.length() && it < rule[1]){
                temp = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).toCharArray();
                temp[7-it] = text.charAt(pointer);
                com.editPixel(2, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
                it++; pointer++;
            }
            // embedd to blue
            it=0;
            while (pointer<text.length() && it < rule[2]){
                temp = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).toCharArray();
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
        temp = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).toCharArray();
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
        temp = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).toCharArray();
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
        
//        System.out.println("sebelum flag, iOffset: " + iOffset + " jOffset: " + jOffset);
        // flag to blue
        temp = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).toCharArray();
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
        int height = com.height;
        int width = com.width;
        if (height%3!=0){
            height = (height/3)*3;
        }
        if (width%3!=0){
            width = (width/3)*3;
        }
        while(i<height-1){
            if(j<width-1){
                processBlock(i,j);
                j=j+3;
            } else{
                j=0;
                i=i+3;
            }
        }
    }
    
    public String extractMessageFromBlock(int iOffset, int jOffset){
       char[] result = new char[com.height*com.width];
       b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
       char[] temp;
       int counter = 0;
       p = b.getPix(8);
       
       temp = bit8(com.integerToBit(com.redPix[iOffset+2][jOffset+2])).toCharArray();
       
        for (int i = 0; i < 8; i++) {
           if (temp[6]=='0' && temp[7]=='0'){
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(6); pointerres++;
            }
           if (temp[6]=='0' && temp[7]=='1'){
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
            }
           if (temp[6]=='1' && temp[7]=='0'){
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(4); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(4); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(4); pointerres++;
            }
           if (temp[6]=='1' && temp[7]=='1'){
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(4); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(3); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(4); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(3); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(7); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(6); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(4); pointerres++;
                result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(3); pointerres++;
           }
            jOffset++;
            counter++;
            if(counter==3){
                iOffset++;
                jOffset = jOffset - 3;
                counter = 0;
            }
        }
        
        jOffset++; // bit ke-8
       if (temp[6]=='0' && temp[7]=='1'){
           result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
           result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
           result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
       }
       if (temp[6]=='1' && temp[7]=='0'){
            result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(4); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(4); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(4); pointerres++;
        }
       if (temp[6]=='1' && temp[7]=='1'){
            result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(4); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.redPix[iOffset][jOffset])).charAt(3); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(4); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.greenPix[iOffset][jOffset])).charAt(3); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(5); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(4); pointerres++;
            result[pointerres] = bit8(com.integerToBit(com.bluePix[iOffset][jOffset])).charAt(3); pointerres++;
       }
       return String.valueOf(result).substring(0, pointerres);
    }
    
    public String extractMsg(int len){
        String temp = com.bitToText(extractMessageFromBlock(0,0));
        pointerres = 0;
        int i=0; int j=3;
        while(i<com.height-1){
            if(j<com.width-1){
                temp = temp + com.bitToText(extractMessageFromBlock(i,j));
                pointerres = 0;
                if (temp.length()>=len){
                    break;
                }
                j=j+3;
            } else{
                j=0;
                i=i+3;
            }
        }        
        return temp.substring(0,len);
    }
    
    public void Flush(String outfile) throws IOException{
        com.flush(outfile);
    }
    
    public String bit8(String bit){
        while (bit.length()<8){
            bit = '0' + bit;
        }
        return bit;
    }
    
    public void tes(int iOffset, int jOffset){
        b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
        int counter = 0;
        
        int a = iOffset+2;
        int c = jOffset+2;
        System.out.println(bit8(com.integerToBit(com.bluePix[a][c])));
        for (int i = 0; i < 9; i++) {
            System.out.println(bit8(com.integerToBit(com.redPix[iOffset][jOffset])));
            System.out.println(bit8(com.integerToBit(com.greenPix[iOffset][jOffset])));
            System.out.println(bit8(com.integerToBit(com.bluePix[iOffset][jOffset])));
            System.out.println();
            jOffset++;
            counter++;
            if(counter==3){
                iOffset++;
                jOffset = jOffset - 3;
                counter = 0;
            }
        }
    }
    
}
