/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package common;

import java.io.IOException;
import static java.lang.Math.pow;

/**
 *
 * @author Cilvia
 */
public class Block4 {
	public final PixelPos[] blocks;
    private final Common com;
	private int[] y, ya, yb, yc;
	float D;
	int T, k, TRGB;
	String level, plainteks;
    
    public Block4() throws IOException{
        blocks = new PixelPos[4];	
		for(int i=0;i<=3;i++){
			blocks[i] = new PixelPos();
		}
		
//		blocks[0].setI(0);
//		blocks[0].setJ(0);
//		blocks[1].setI(0);
//		blocks[1].setJ(1);
//		blocks[2].setI(1);
//		blocks[2].setJ(0);
//		blocks[3].setI(1);
//		blocks[3].setJ(1);
		
       com = new Common("C:\\Users\\Anggi\\Documents\\kuliah\\Semester6\\Kripto\\tes.bmp");
		y = new int[4];
		y[0] = 139;
		y[1] = 146;
		y[2] = 137;
		y[3] = 142;
		T=5;
		plainteks = "000111111101";
    }
    
    public void initBlocks(){
     //   int len = com.stream.length;
        
    }

	/**ENCRYPT**/
	
	private void setTRGB(int color){
		TRGB = color;
	}
	
	public void encrypt(int color){
		System.out.println(Integer.toBinaryString(y[0]));
		System.out.println(Integer.toBinaryString(y[1]));
		System.out.println(Integer.toBinaryString(y[2]));
		System.out.println(Integer.toBinaryString(y[3]));
		
		setTRGB(color);
		// gimana nentuin T
		setLevel();
		// gimana nentuin klower khigher
		setK(2,3);
		if(!isErrorBlock(y)){
			commonLSBSubstitution();			

//			System.out.println(ya[0]);
//			System.out.println(ya[1]);
//			System.out.println(ya[2]);
//			System.out.println(ya[3]);
			
			modifiedLSBSubstitution();
			
//			System.out.println(yb[0]);
//			System.out.println(yb[1]);
//			System.out.println(yb[2]);
//			System.out.println(yb[3]);
			
			readjustingProcedure();
			
//			System.out.println(yc[0]);
//			System.out.println(yc[1]);
//			System.out.println(yc[2]);
//			System.out.println(yc[3]);
			
			finishing();
		}
		
	}

	private void finishing(){
		for(int i=0;i<=3;i++)
			com.editPixel(TRGB, blocks[i].getI(), blocks[i].getJ(), yc[i]);
	}
	
	private void readjustingProcedure(){
		System.out.println("--READJUSTING--");
		
		yc = new int[4];
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
	
	private int abs(int a){
		if(a<0)	a = a * -1;
		return a;
	}
	
	private void modifiedLSBSubstitution(){
		System.out.println("--MODIFIED--");
		
		yb = new int[4];
		int min, temp;
		String message, MSB, cipher;
	
		for(int i=0;i<=3;i++){
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
	
	private void commonLSBSubstitution(){
		ya = new int[4];		
		String temp = "";
		for(int i=0;i<=3;i++){
			temp = com.integerToBit(y[i]).substring(0,8-k);
			ya[i] = com.bitToInteger(temp+plainteks.substring(0,k));
			plainteks = plainteks.substring(k);
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
	
	private String getLevel(int[] yt){
		if(getD(yt) <= T) 
			return "lower";
		else 
			return "higher";
	}
	
	
	
	
	
	
	
}
