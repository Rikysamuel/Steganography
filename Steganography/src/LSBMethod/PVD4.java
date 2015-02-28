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
 * @author Cilvia
 */
public class PVD4 {
	public PixelPos[] blocks;
	private final Common com;
    Block4 blockProcess;
	int T, kLower, kHigher;
	String plainteks;
	int height, width;
    
    public PVD4(String picturename) throws IOException{
		System.out.println("--CONSTRUCT PVD4--");
		
		blocks = new PixelPos[4];	
		for(int i=0;i<=3;i++){
			blocks[i] = new PixelPos();
		}
		blockProcess = new Block4(picturename);
		
		com = new Common(picturename);
		com.imageToPix();
		
		width = 0;
		height = 0;
		
		T = 5;
		kLower = 2;
		kHigher = 3;
    }
	
	public void Flush(String outfile) throws IOException{
        com.flush(outfile);
    }
	
	public String getPlainTeks(){
		return com.bitToText(plainteks);
	}
    
	private void initBlocks(int pos){
		int j = (pos % width) * 2;
		int i = (pos / width) * 2;
		
		blocks[0].setI(i);
		blocks[0].setJ(j);
		blocks[1].setI(i+1);
		blocks[1].setJ(j);
		blocks[2].setI(i);
		blocks[2].setJ(j+1);
		blocks[3].setI(i+1);
		blocks[3].setJ(j+1);
	}
	
	private void initProcess(){
		int i = 0;
		while(i <= com.width){
			width++;
			i = i + 2;
		}
		i = 0;
		while(i <= com.height){
			height++;
			i = i + 2;
		}
	}
	
	private boolean process1Block(int pos, String process, boolean endProcess){
		
		initBlocks(pos);

		//System.out.println("After inisialization PixelPos");

		int color=1;
		while(color<=3 && !endProcess){
			// initialization integer Y per Block4
			for(int k=0;k<=3;k++){
				blockProcess.initY(k,com.getIntegerPixel(color, blocks[k].getI(), blocks[k].getJ()));
			}

			//System.out.println("After inisialization Y per Block4");

			if(process.equals("encrypt")){
				// processing hide message
				plainteks = blockProcess.encrypt(color,kLower,kHigher,T,plainteks);
				for(int k=0;k<=3;k++)
					com.editPixel(color, blocks[k].getI(), blocks[k].getJ(), blockProcess.getYfinal(k));
				if(plainteks.isEmpty())
					endProcess = true;
			} else /*if(process.equals("decrypt"))*/ {
				System.out.println("-decrypt-");
				plainteks = blockProcess.decrypt(color,kLower,kHigher,T,plainteks);
				System.out.println(plainteks);
				if(com.bitToText(plainteks).endsWith("EOF"))
					endProcess = true;
			}

			color++;
		}
		
		return endProcess;
	}
	
	private void hideMessage(int color, int i, int j){
		com.editPixel(color, blocks[i].getI(), blocks[i].getJ(), blockProcess.getYfinal(i));
	}
	
    public void process(String plaintext, String process) throws IOException{
		System.out.println("--PROCESS--");
		System.out.println(process);
		
		initProcess();
		plainteks = plaintext;
		int i = 0;
	//	boolean outOfBound = false;
		boolean endProcess = false;
		
		while(i < height*width && !endProcess){
			endProcess = process1Block(i,process, endProcess);
		}
		
//		while(i <= height && !outOfBound && !endProcess){
//			int j = 0;
//			while(j <= width && !outOfBound && !endProcess){
//			//	System.out.println("[PV4] plainteks="+com.bitToText(plainteks));
////				System.out.println("[PV4] plainteks="+plainteks);
//				// initialization PixelPos per Block4
//				
//				/* diproses di void process1Block di atas */
//				process1Block();
//				
//				j++;
////				j = j + 2;
////				if(j>com.height)
////					outOfBound = true;
//			}
//			i++;
////			i = i + 2;
////			if(i > com.height)
////				outOfBound = true;
////			else
////				outOfBound = false;
//		}
    }
}

