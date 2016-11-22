package com.ac.gachon.magic;

import com.ac.gachon.magic.hiearachy.AbstractMagicSquare;

public class FourMagicSquare extends AbstractMagicSquare {
	
	public FourMagicSquare(){
		this(4);
	}

	public FourMagicSquare(int n) {
		this.init(n);
	}
	
	public void make(){
		makeRight();
		makeLeft();
	}

	//������ �帧
	private void makeLeft() {
		int count = top+1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				if(i>=0 && i<count/4 || i>=count/4*3 && i<count){
					if(j>=count/4 && j<count/4*3){
						magic[i][j] = (count*count)-(i*count+j);
					}
				}else{
					if(j>=0 && j<count/4 || j>=count/4*3 && j<count){
						magic[i][j] = (count*count)-(i*count+j);
					}
				}
			}
		}
	}

	//������ �帧
	private void makeRight() {
		int count = top+1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				magic[i][j] = i*count+j+1; // ��Į����, 2������ 1�������� �ٲ��ִ� ����
			}
		}
	}
}
