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
    
    public Block4(String tempfile) throws IOException{
		com = new Common(tempfile);
		y = new int[4];
		ya = new int[4];
		yb = new int[4];
		yc = new int[4];
		
    }
    
    public void initBlock(int color, int keyLower, int keyHigher, int threshold){
		T = threshold;
		// gimana nentuin T
		setLevel();
		// gimana nentuin klower khigher
		setK(keyLower,keyHigher);
        
    }
	
	/** DECRPYT **/
	public String decrypt(int color, int keyLower, int keyHigher, int threshold, String result){
		initBlock(color,keyLower,keyHigher,threshold);
		
		for(int i=0;i<=3;i++){
		//	System.out.println("y["+i+"]="+y[i]);
			result += com.integerToBit(y[i]).substring(8-k);
		}
		
		return result;
	}
	
	/** ENCRYPT **/
	public void initY(int pos, int val){
		y[pos] = val;
	}
	
	public int getYfinal(int pos){
		return yc[pos];
	}
	
	private String make8bit(String bit){
		while(bit.length()<8){
			bit = '0' + bit;
		}
		return bit;
	}
	
	public String encrypt(int color, int keyLower, int keyHigher, int threshold, String plain){
		plainteks = plain;
		initBlock(color,keyLower,keyHigher,threshold);
		
		if(!isErrorBlock(y)){
			commonLSBSubstitution();			
			modifiedLSBSubstitution();
			readjustingProcedure();
			
			for(int i=0;i<=3;i++){
				System.out.println(com.integerToBit(yc[i]));
			}
			
		}
		return plainteks;
	}

	
	
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
				
						if(!isErrorBlock(yTemp) && isSameLevel(y,yTemp)){
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
	
	private int sumValue(int[] yt){
		int temp = 0;
		for(int i=0;i<=3;i++){
			temp += pow(yt[i]-y[i],2);
		}
		return temp;
	}
	
	private int countReadjusting(int pos, int l){
		return (yb[pos] + l * (int)pow(2,k));
	}
	
	private boolean isSameLevel(int[] y1, int[] y2){
		return (getLevel(y1).equals(getLevel(y2)));
	}
	
//	private int abs(int a){
//		if(a<0)	a = a * -1;
//		return a;
//	}
	
	private void modifiedLSBSubstitution(){
		System.out.println("--MODIFIED--");
		
		
		int min, temp;
		String message, MSB, cipher;
	
		for(int i=0;i<=3;i++){
			min = abs(ya[i]-y[i]);
			yb[i] = ya[i];
			
			message = com.integerToBit(yb[i]).substring(8-k);
			MSB = com.integerToBit(yb[i]).substring(0,8-k);
			
//			System.out.println(message);
//			System.out.println(MSB);
			
			for(int j=-1;j<=1;j=j+2){
				temp = com.bitToInteger(MSB) + j;
				cipher = com.integerToBit(temp) + message;
//				System.out.println(cipher);
				if(min > abs(com.bitToInteger(cipher)-y[i]))
					yb[i] = com.bitToInteger(cipher);
			}
		}
	}
	
	private void commonLSBSubstitution(){
		System.out.println("--COMMONSUBS--");
		String temp = "";
		for(int i=0;i<=3;i++){
//			System.out.println("plainteks="+plainteks);
//			System.out.println(y[i]);
			System.out.println(com.integerToBit(y[i]));
			temp = com.integerToBit(y[i]).substring(0,8-k);
//			System.out.println("After substring from y");
			ya[i] = com.bitToInteger(temp+plainteks.substring(0,k));
			plainteks = plainteks.substring(k);
		}
	}
	
	// must done after setLevel
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
	
	private String getLevel(int[] yt){
		if(getD(yt) <= T) 
			return "lower";
		else 
			return "higher";
	}
	
}
