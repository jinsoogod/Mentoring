package com.ac.gachon.magic.hiearachy;

public abstract class AbstractMagicSquare implements IMagicSquare {
	public int [][] magic;
	public int top;
	
	public abstract void make();
	
	public void init(int n){
		magic = new int[n][n];
		top = n-1; //
	}
	
	public void print(){
		int count = top + 1;
		
		for (int i = 0; i < count; i++) {
			
			for (int j = 0; j < count; j++) {
				System.out.print(magic[i][j]+"\t");
			}
			System.out.println();
		}
	}

	
	//마방진 검증 로직
	public boolean isCheck(){
		boolean isT = true;
		
		//2N+2개
		int count = top+1;
		int[] mcheck = new int[2*count+2]; //검증할 수 있는 방 생성
		
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				mcheck[i] += magic[i][j]; // 가로 3줄 검증 & 방 번호 0,1,2 부여
				mcheck[i+count] += magic[j][i]; // 세로 3줄 검증 & 방 번호 3번부터 부여
				if(i==j){
					mcheck[2*count] += magic[i][j]; // 대각선 1 검증 & 방번호 6부여
				}
				
				if(i+j == count-1){
					mcheck[2*count+1] += magic[i][j]; // 대각선 2 검증 & 방번호 7부여
				}
			}
		}
		
		for(int i = 0; i < mcheck.length; i++){
			if(mcheck[0] != mcheck[i]){
				isT = false;
				break;
			}
		}
		return isT;
	}

}
