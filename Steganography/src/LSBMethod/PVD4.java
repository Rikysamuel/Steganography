/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.Pixel;
import java.io.IOException;

/**
 *
 * @author Rikysamuel
 */
public class PVD4 {
    
    private final Pixel[] blocks;
 //   private final Common com;
	private int[] y, ya, yb, yc;
	float D;
	int T, k;
	String level, plainteks;
    
    public PVD4(String filename) throws IOException{
        blocks = new Pixel[4];
      // com = new Common();
      //  com.writeToByte(filename);
		y = new int[4];
		y[0] = 139;
		y[1] = 146;
		y[2] = 137;
		y[3] = 142;
		plainteks = "000111111101";
    }
    
    public void initBlocks(){
     //   int len = com.stream.length;
        
    }
	
	public void encrypt(){
		System.out.println(Integer.toBinaryString(y[0]));
		System.out.println(Integer.toBinaryString(y[1]));
		System.out.println(Integer.toBinaryString(y[2]));
		System.out.println(Integer.toBinaryString(y[3]));
		
		setLevel();
		setK(2,3);
		if(!isErrorBlock(y)){
			commonLSBSubstitution();
			
			
			System.out.println(Integer.toBinaryString(ya[0]));
			System.out.println(Integer.toBinaryString(ya[1]));
			System.out.println(Integer.toBinaryString(ya[2]));
			System.out.println(Integer.toBinaryString(ya[3]));

		}
		
	}
	
	private void setK(int keyLower, int keyHigher){
		if (level.equals("lower"))
			k = keyLower;
		else
			k = keyHigher;
	}
	
	private void setLevel(){
		if(getD(y) <= T)
			level = "lower";
		else
			level = "higher";
	}
	
	private int getYmax(int[] yt){
		int max = -1;
		for(int i = 0;i<=3;i++){
			if(max < yt[i]){
				max = yt[i];
			}
		}
		return max;
	}
	
	private int getYmin(int[] yt){
		int min = 256;
		for(int i = 0;i<=3;i++){
			if(min > yt[i]){
				min = yt[i];
			}
		}
		return min;
	}
	
	private float getD(int[] yt){
		float temp = 0;
		for(int i=0;i<=3;i++){
			temp += yt[i] - getYmin(yt);
		}
		return (temp/3);
	}
	
	private boolean isErrorBlock(int[] yt){
		return ((getYmax(yt)-getYmin(yt) > 2*T+2) && (getD(yt) <= T));
	}
	
	String getLevel(int[] yt){
		if(getD(yt) <= T) 
			return "lower";
		else 
			return "higher";
	}
	
	private int sumValue(){
		int temp = 0;
		for(int i=0;i<=3;i++){
			temp += yc[i] - y[i];
		}
		return temp;
	}
	
	void commonLSBSubstitution(){
		ya = new int[4];
		String temp = plainteks.substring(0, k);
		plainteks = plainteks.substring(k+1);
		System.out.println(temp);
		
		
	}
	
	void modifiedLSBSubtitution(){
	
	}
	
	void readjustingProcedure(){
	
	}
	
	int countReadjusting(int pos, int l){
		return (yb[pos] + l * 2 ^ k);
	}
	
	boolean isSameLevel(int[] y1, int[] y2){
		return (getLevel(y1).equals(getLevel(y2)));
	}
	
	
}

