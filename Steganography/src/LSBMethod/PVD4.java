/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package LSBMethod;

import common.Common;
import common.Block4;
import java.io.IOException;

/**
 *
 * @author Rikysamuel
 */
public class PVD4 {
	private final Common com;
    Block4 blockProcess;
	int T, k;
	String plainteks;
    
    public PVD4(String filename) throws IOException{
		blockProcess = new Block4();
		com = new Common("tes");
		plainteks = com.getPlaintextFromFile("tes");
    }
    
    public void encrypt() throws IOException{
		int i = 0;
		while(i <= com.height){
			int j = 0;
			while(j <= com.width){
				blockProcess.blocks[0].setI(i);
				blockProcess.blocks[0].setJ(j);
				blockProcess.blocks[1].setI(i+1);
				blockProcess.blocks[1].setJ(j);
				blockProcess.blocks[2].setI(i);
				blockProcess.blocks[2].setJ(j+1);
				blockProcess.blocks[3].setI(i+1);
				blockProcess.blocks[3].setJ(j+1);
				
				for(int color=1;color<=3;color++)
					blockProcess.encrypt(color);
				
				j = j + 2;
			}
			i = i + 2;
		}
    }
	
}

