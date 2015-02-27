/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.Block4;
import common.PixelPos;
import java.io.IOException;

/**
 *
 * @author Rikysamuel
 */
public class PVD4 {
	public PixelPos[] blocks;
	private final Common com;
    Block4 blockProcess;
	int T, kLower, kHigher;
	String plainteks;
    
    public PVD4(String picturename) throws IOException{
		System.out.println("--CONSTRUCT PVD4--");
		
		blocks = new PixelPos[4];	
		for(int i=0;i<=3;i++){
			blocks[i] = new PixelPos();
		}
		blockProcess = new Block4(picturename);
		com = new Common(picturename);
		com.imageToPix();
		
		T = 5;
		kLower = 2;
		kHigher = 3;
    }
	
	
    
    public void process(String plaintext, String process) throws IOException{
		plainteks = plaintext;
		int i = 0;
		boolean outOfBound = false;
		
		while(i <= com.height && !outOfBound){
			int j = 0;
			while(j <= com.width && !outOfBound){
				
				// initialization PixelPos per Block4
				blocks[0].setI(i);
				blocks[0].setJ(j);
				blocks[1].setI(i+1);
				blocks[1].setJ(j);
				blocks[2].setI(i);
				blocks[2].setJ(j+1);
				blocks[3].setI(i+1);
				blocks[3].setJ(j+1);
				
				for(int color=1;color<=3;color++){
					// initialization integer Y per Block4
					for(int k=0;k<=3;k++){
						blockProcess.initY(k,com.getIntegerPixel(color, blocks[k].getI(), blocks[k].getJ()));
					}
					
					if(process.equals("encrypt")){
						// processing hide message
						plainteks = blockProcess.encrypt(color,kLower,kHigher,T,plainteks);
						com.editPixel(color, blocks[i].getI(), blocks[i].getJ(), blockProcess.getYfinal(i));
					} else /*decrypt*/ {
						plainteks = blockProcess.decrypt(color,kLower,kHigher,T,plainteks);
					}
					
				}
			
				j = j + 2;
				if(j>com.height)
					outOfBound = true;
			}
			i = i + 2;
			if(i > com.height)
				outOfBound = true;
			else
				outOfBound = false;
		}
    }
}

