package com.ac.gachon.magic;

import com.ac.gachon.magic.hiearachy.AbstractMagicSquare;

public class SixMagicSquare extends AbstractMagicSquare{

	public SixMagicSquare(){
		this(6);
	}
	
	public SixMagicSquare(int n){
		this.init(n);
	}

	
	//6마방진 로직
	//ABCD 4구역으로 나눔
	
	public void make(){
		makeA();
		makeB();
		makeCD();
		multiples();
		addABCD();
	}
	
	private void addABCD() {
		int count = top+1;
		OddMagicSquare odd = new OddMagicSquare(count/2);
		odd.make();
		int [][] oddMagic = odd.getMagic();
		
		for (int i = 0; i < count/2; i++) {
			for (int j = 0; j < count/2; j++) {
				magic[i][j] += oddMagic[i][j];
				magic[i][j+count/2] += oddMagic[i][j];
				magic[i+count/2][j] += oddMagic[i][j];
				magic[i+count/2][j+count/2] += oddMagic[i][j];
			}
		}
	}

	private void multiples() {
		int count = top+1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				magic[i][j] *= (count/2)*(count/2);
			}
		}
	}

	private void makeCD() {
		int count = top+1;

		for (int i = 0; i < count/2; i++) {
			for (int j = 0; j < count/2; j++) {
				if(magic[i][j+count/2] == 1){
					magic[i+count/2][j+count/2] = 2;
				}else if(magic[i][j+count/2] == 2){
					magic[i+count/2][j+count/2] = 1;
				}
			}
		}
		
		for (int i = 0; i < count/2; i++) {
			for (int j = 0; j < count/2; j++) {
				if(magic[i][j] == 0){
					magic[i+count/2][j] = 3;
				}else if(magic[i][j] == 3){
					magic[i+count/2][j] = 0;
				}
			}
		}

	}

	private void makeB() {
		int count = top+1;
		for (int i = 0; i < count/2; i++) {
			for (int j = 0; j < count/2; j++) {
				magic[i][j+count/2] = 1;
			}
		}
		for (int i = 0; i < count/2; i++) {
			for (int j = 0; j < count/4-1; j++) {
				magic[i][j+count/2] = 2;
			}
		}
	}

	private void makeA() {
		int count = top+1;
		for (int  i= 0;  i< count/2; i++) {
			for (int j = 0; j < count/4; j++) {
				if(i==count/4){
					magic[i][j+1] =3;
				}else{
					magic[i][j]=3;
				}
			}
		}
	}

}
