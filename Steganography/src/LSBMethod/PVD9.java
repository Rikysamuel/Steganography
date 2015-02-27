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
    }
    
    public void processBlock(int iOffset, int jOffset){
        b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
        b.getDiff(iOffset, jOffset);
        rule = b.LSBRule();
        char[] temp;
        int it;
        
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
            if(jOffset==3){
                iOffset++;
                jOffset = 0;
            }
        }
        
        p = b.getPix(8);
        // flag to red
        it = 0;
        while (pointer<text.length() && it < rule[0]){
            temp = com.integerToBit(com.redPix[iOffset][jOffset]).toCharArray();
            if (rule[0]==2){
                temp[6] = '0'; temp[7]='0';
            }
            if (rule[0]==3){
                temp[6] = '0'; temp[7]='1';
                temp[5] = text.charAt(pointer); pointer++;
            }
            if (rule[0]==4){
                temp[6] = '1'; temp[7]='0';
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
            if (rule[0]==5){
                temp[6] = '1'; temp[7]='1';
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
                
            }
            com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
        }
        // flag to green
        it = 0;
        while (pointer<text.length() && it < rule[1]){
            temp = com.integerToBit(com.greenPix[iOffset][jOffset]).toCharArray();
            if (rule[1]==2){
                temp[6] = '0'; temp[7]='0';
            }
            if (rule[1]==3){
                temp[6] = '0'; temp[7]='1';
                temp[5] = text.charAt(pointer); pointer++;
            }
            if (rule[1]==4){
                temp[6] = '1'; temp[7]='0';
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
            if (rule[1]==5){
                temp[6] = '1'; temp[7]='1';
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
                
            }
            com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
        }
        // flag to blue
        while (pointer<text.length() && it < rule[2]){
            temp = com.integerToBit(com.redPix[iOffset][jOffset]).toCharArray();
            if (rule[2]==2){
                temp[6] = '0'; temp[7]='0';
            }
            if (rule[2]==3){
                temp[6] = '0'; temp[7]='1';
                temp[5] = text.charAt(pointer); pointer++;
            }
            if (rule[2]==4){
                temp[6] = '1'; temp[7]='0';
                temp[5] = text.charAt(pointer); pointer++;
                temp[4] = text.charAt(pointer); pointer++;
            }
            if (rule[2]==5){
                temp[6] = '1'; temp[7]='1';
                temp[5-it] = text.charAt(pointer); pointer++;
                temp[4-it] = text.charAt(pointer); pointer++;
                temp[3-it] = text.charAt(pointer); pointer++;
                
            }
            com.editPixel(1, p.getI(), p.getJ(), com.bitToInteger(String.valueOf(temp)));
        }
        
        System.out.println(com.integerToBit(com.redPix[iOffset][jOffset]));
        System.out.println(com.integerToBit(com.greenPix[iOffset][jOffset]));
        System.out.println(com.integerToBit(com.bluePix[iOffset][jOffset]));

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
        b.createBlock(iOffset, jOffset, com.redPix, com.greenPix, com.bluePix);
        char[] temp;
        char[] result = null;
        PixelPos p2;
        int it;
        
        p = b.getPix(8);
        // get red's flag
        temp = com.integerToBit(com.redPix[iOffset][jOffset]).toCharArray();
        System.out.println(String.valueOf(temp));
        for (int i = 0; i < 8; i++) {
            p2 = b.getPix(i);
            if (temp[6]=='0' && temp[7]=='0'){  //get message from red
                // get message from red
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                // get message from green
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                // get message from blue
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
            }
            if (temp[6]=='0' && temp[7]=='1'){
                // get message from red
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                // get message from green
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                // get message from blue
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(5); pointerres++;
            }
            if (temp[6]=='1' && temp[7]=='0'){
                // get message from red
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(4); pointerres++;
                // get message from green
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(4); pointerres++;
                // get message from blue
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(4); pointerres++;
            }
            if (temp[6]=='1' && temp[7]=='1'){
                System.out.println("tes: " + com.integerToBit(com.redPix[p2.getI()][p2.getJ()]));
                // get message from red
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(4); pointerres++;
                result[pointerres] = com.integerToBit(com.redPix[p.getI()][p.getJ()]).charAt(3); pointerres++;
                // get message from green
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(4); pointerres++;
                result[pointerres] = com.integerToBit(com.greenPix[p.getI()][p.getJ()]).charAt(3); pointerres++;
                // get message from blue
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(7); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p2.getI()][p2.getJ()]).charAt(6); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(5); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(4); pointerres++;
                result[pointerres] = com.integerToBit(com.bluePix[p.getI()][p.getJ()]).charAt(3); pointerres++;
            }
        }
        if (result==null){
            result = "-".toCharArray();
        }
        System.out.println(String.valueOf(result));
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
        com.flush(outfile);
    }
    
}
