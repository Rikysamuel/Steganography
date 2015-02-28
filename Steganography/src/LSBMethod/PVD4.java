/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.Block4;
import common.PixelPos;
import common.PlainText;
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
	int height, width, maxData;
	PlainText pt;
    
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
		String temp = com.bitToText(plainteks);
		return temp.substring(0,temp.length()-3);
	}
    
	private void initBlocks(int pos){
		int j = (pos % width) * 2;
		int i = (pos / width) * 2;
		
		System.out.println("i,j= "+i+" "+j);
		
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
		maxData = width * height * 3 * 4 * kLower;
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

			if(process.equals("hide")){
				// processing hide message
				plainteks = blockProcess.encrypt(color,kLower,kHigher,T,plainteks);
				for(int k=0;k<=3;k++)
					com.editPixel(color, blocks[k].getI(), blocks[k].getJ(), blockProcess.getYfinal(k));
				if(plainteks.isEmpty())
					endProcess = true;
			} else /*extract*/ {
				System.out.println("-extract-");
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
	
    public void process(String process, String textfile) throws IOException{
		System.out.println("--PROCESS--");
		System.out.println(process);
		
		initProcess();
		if(process.equals("hide")){
			pt = new PlainText(textfile);
			pt.setStreamPT();
			plainteks = pt.ptByte + com.textToBit("EOF");			

			System.out.println(plainteks);
			System.out.println(com.bitToText(plainteks));
		} else /* extract */{
			plainteks = "";
		}
		
		int i = 0;
	//	boolean outOfBound = false;
		boolean endProcess = false;
		
		while(i < height*width && !endProcess){
			System.out.println("pos="+i);
			endProcess = process1Block(i,process, endProcess);
			i++;
		}
    }
}

