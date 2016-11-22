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

	
	//������ ���� ����
	public boolean isCheck(){
		boolean isT = true;
		
		//2N+2��
		int count = top+1;
		int[] mcheck = new int[2*count+2]; //������ �� �ִ� �� ����
		
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				mcheck[i] += magic[i][j]; // ���� 3�� ���� & �� ��ȣ 0,1,2 �ο�
				mcheck[i+count] += magic[j][i]; // ���� 3�� ���� & �� ��ȣ 3������ �ο�
				if(i==j){
					mcheck[2*count] += magic[i][j]; // �밢�� 1 ���� & ���ȣ 6�ο�
				}
				
				if(i+j == count-1){
					mcheck[2*count+1] += magic[i][j]; // �밢�� 2 ���� & ���ȣ 7�ο�
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
