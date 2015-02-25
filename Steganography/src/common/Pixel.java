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
public class Pixel {
    private final byte[] Pix;
    
    public Pixel(){
        Pix = new byte[3];
    }

    public Pixel(byte[] Pix) {
        this.Pix = Pix;
    }

    public byte[] getPix() {
        return Pix;
    }
    
    public void setR(byte b){
        Pix[0] = b;
    }
    
    public byte getR(){
        return Pix[0];
    }
    
    public void setG(byte b){
        Pix[1] = b;
    }
    
    public byte getG(){
        return Pix[1];
    }
    
    public void setB(byte b){
        Pix[2] = b;
    }
    
    public byte getB(){
        return Pix[2];
    }
    
    
}
