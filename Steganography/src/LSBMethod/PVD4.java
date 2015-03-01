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
import static java.lang.Math.log;
import static java.lang.Math.log10;
import static java.lang.Math.pow;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Cilvia
 */
public class PVD4 {
	public PixelPos[] blocks;
	private final Common com;
    Block4 blockProcess;
	int T, kLower, kHigher;
	double diff;
	String plainteks;
	int height, width, maxData;
	PlainText pt;
	List<Integer> listPosition;
    
    public PVD4(String picturename) throws IOException{
		System.out.println("--CONSTRUCT PVD4--");
		
		blocks = new PixelPos[4];	
		for(int i=0;i<=3;i++){
			blocks[i] = new PixelPos();
		}
		blockProcess = new Block4(picturename);
		listPosition = new ArrayList<>();
		
		
		com = new Common(picturename);
		com.imageToPix();
		
		width = 0;
		height = 0;
		diff = 0;
		
		T = 5;
		kLower = 2;
		kHigher = 3;
    }
	
	public void Flush(String outfile) throws IOException{
        com.flush(outfile);
    }
	
	public String getPlainTeks(){
		String temp = com.bitToText(plainteks);
		System.out.println(temp);
		temp = temp.substring(0,temp.length()-3);
		System.out.println(temp);
		System.out.println("tes  "+pt.getPlaintextAfterDecrypt(temp));
		return pt.getPlaintextAfterDecrypt(temp);
	}
    
	public void setRandomPosition(String key){
		System.out.println("-Set Random Position-");
		listPosition = com.randomSeed(com.getKeySeed(key),height*width/*,(plainteks.length()/(3*4*kLower))+1*/);
		System.out.println("-SRP: finished-");
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
	
	private void countDifferent(int yInitial, int yFinal){
		diff += pow(yInitial-yFinal,2);
	}
	
	public double countPSNR(){
		double result = 0.0;
		double rms = pow(diff/(9*com.height*com.width),0.5);
		result = 20 * log10(256/rms);
		return result;
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
				for(int k=0;k<=3;k++){
					countDifferent(com.getIntegerPixel(color, blocks[k].getI(), blocks[k].getJ()),blockProcess.getYfinal(k));
					com.editPixel(color, blocks[k].getI(), blocks[k].getJ(), blockProcess.getYfinal(k));
				}
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
	
    public void process(String process, String key, String textfile) throws IOException{
		System.out.println("--PROCESS--");
		System.out.println(process);
		
		initProcess();
		if(process.equals("hide")){
			pt = new PlainText(textfile,key);
			pt.setStreamPT();
			plainteks = pt.ptByte + com.textToBit("EOF");			

			System.out.println(plainteks);
			System.out.println(com.bitToText(plainteks));
		} else /* extract */{
			pt = new PlainText(textfile,key);
			plainteks = "";
		}
	//	setRandomPosition(key);
		
		int i = 0;
	//	boolean outOfBound = false;
		boolean endProcess = false;
		
		while(/*i < listPosition.size() &&*/ !endProcess){
			System.out.println("pos="+i);
			endProcess = process1Block(com.randomPositionFromSeed(com.getKeySeed(key),height*width),process, endProcess);
			i++;
		}
    }
}

