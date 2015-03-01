/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.io.IOException;
import static java.lang.Math.abs;
import static java.lang.Math.pow;

/**
 *
 * @author Cilvia
 */
public class Block4 {
	private final Common com;
	public int[] y;
	private int[] ya, yb, yc;
	float D;
	int T, k;
	String level, plainteks;
    
	// constructor
    public Block4(String tempfile) throws IOException{
		com = new Common(tempfile);
		y = new int[4];
		ya = new int[4];
		yb = new int[4];
		yc = new int[4];
		
    }
    
	// Inisialization of one block
    public void initBlock(int color, int keyLower, int keyHigher, int threshold){
		T = threshold;
		setLevel();
		setK(keyLower,keyHigher);
    }
	
	/** EXTRACT **/
	
	// extract the message from stego image
	public String decrypt(int color, int keyLower, int keyHigher, int threshold, String result){
		initBlock(color,keyLower,keyHigher,threshold);
		
		for(int i=0;i<=3;i++){
			result += com.integerToBit(y[i]).substring(8-k);
		}
		
		return result;
	}
	
	/** HIDE **/
	
	// Inisialization for y initial
	public void initY(int pos, int val){
		y[pos] = val;
	}
	
	// Get the final y
	public int getYfinal(int pos){
		return yc[pos];
	}
	
	// Hide the message in cover image
	public String encrypt(int color, int keyLower, int keyHigher, int threshold, String plain){
		plainteks = plain;
		initBlock(color,keyLower,keyHigher,threshold);
		
		if(!isErrorBlock(y)){ // not Error Block
			commonLSBSubstitution();			
			modifiedLSBSubstitution();
			readjustingProcedure();
			
			for(int i=0;i<=3;i++){
				System.out.println(com.integerToBit(yc[i]));
			}
			
		}
		return plainteks;
	}
	
	// readjusting procedure
	private void readjustingProcedure(){
		System.out.println("--READJUSTING--");
		
		
		int[] yTemp = new int[4];
		int min = 256;
		
		for(int l0=-1;l0<=1;l0++){
			yTemp[0] = countReadjusting(0,l0);

			for(int l1=-1;l1<=1;l1++){
				yTemp[1] = countReadjusting(1,l1);
				
				for(int l2=-1;l2<=1;l2++){
					yTemp[2] = countReadjusting(2,l2);

					for(int l3=-1;l3<=1;l3++){
						yTemp[3] = countReadjusting(3,l3);
				
						// not error block and same level with initial
						if(!isErrorBlock(yTemp) && isSameLevel(y,yTemp)){
							// find the minimum of the value
							if(min > sumValue(yTemp)){
								min = sumValue(yTemp);
								for(int i=0;i<=3;i++)
									yc[i] = yTemp[i];
							}
						}
					}
				}
			}
		}
	}
	
	// the value of the difference between y initial and yt
	private int sumValue(int[] yt){
		int temp = 0;
		for(int i=0;i<=3;i++){
			temp += pow(yt[i]-y[i],2);
		}
		return temp;
	}
	
	// the formula in readjusting procedure
	private int countReadjusting(int pos, int l){
		return (yb[pos] + l * (int)pow(2,k));
	}
	
	// return true if y1 and y2 is in the same level
	private boolean isSameLevel(int[] y1, int[] y2){
		return (getLevel(y1).equals(getLevel(y2)));
	}
	
	// modified LSB Substitution
	private void modifiedLSBSubstitution(){
		System.out.println("--MODIFIED--");
		
		int min, temp;
		String message, MSB, cipher;
	
		for(int i=0;i<=3;i++){ // for each y
			min = abs(ya[i]-y[i]);
			yb[i] = ya[i];
			
			message = com.integerToBit(yb[i]).substring(8-k);
			MSB = com.integerToBit(yb[i]).substring(0,8-k);
			
			for(int j=-1;j<=1;j=j+2){ 
				temp = com.bitToInteger(MSB) + j;
				cipher = com.integerToBit(temp) + message;
				if(min > abs(com.bitToInteger(cipher)-y[i]))
					yb[i] = com.bitToInteger(cipher);
			}
		}
	}
	
	// common LSB Substitution
	private void commonLSBSubstitution(){
		System.out.println("--COMMONSUBS--");
		String temp = "";
		for(int i=0;i<=3;i++){
			System.out.println(com.integerToBit(y[i]));
			temp = com.integerToBit(y[i]).substring(0,8-k);
			System.out.println(plainteks);
			System.out.println(plainteks.substring(0,k));
			if(plainteks.length()<k){
				ya[i] = com.bitToInteger(temp+plainteks);
			} else {
				ya[i] = com.bitToInteger(temp+plainteks.substring(0,k));
			}
			plainteks = plainteks.substring(k);
		}
	}
	
	// set the key based on the level of block
	// must done after setLevel
	private void setK(int keyLower, int keyHigher){
		if (level.equals("lower"))
			k = keyLower;
		else
			k = keyHigher;
	}
	
	// set the level of block based on D and T
	private void setLevel(){
		if(getD(y) <= T)
			level = "lower";
		else
			level = "higher";
	}
	
	// Get the maximum of yt
	private int getYmax(int[] yt){
		int max = -1;
		for(int i = 0;i<=3;i++){
			if(max < yt[i]){
				max = yt[i];
			}
		}
		return max;
	}
	
	// Get the minimum of yt
	private int getYmin(int[] yt){
		int min = 256;
		for(int i = 0;i<=3;i++){
			if(min > yt[i]){
				min = yt[i];
			}
		}
		return min;
	}
	
	// Get the average difference value (D) of yt
	private float getD(int[] yt){
		float temp = 0;
		for(int i=0;i<=3;i++){
			temp += yt[i] - getYmin(yt);
		}
		return (temp/3);
	}
	
	// return true if the block is an error block
	private boolean isErrorBlock(int[] yt){
		return ((getYmax(yt)-getYmin(yt) > 2*T+2) && (getD(yt) <= T));
	}
	
	// Get the level of the block
	private String getLevel(int[] yt){
		if(getD(yt) <= T) 
			return "lower";
		else 
			return "higher";
	}
	
}
