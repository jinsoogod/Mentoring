package com.ac.gachon.magic;


// Ȧ�� ������ �����ϱ�
public class OddMagicsquare {
	
	private int[][] magic;
	public int top;
	
	public OddMagicsquare() {
		this(3);
	}
	
	public OddMagicsquare(int num){
		magic = new int[num][num];
		top = num-1;
	}
	
	public void make(){
	      int x = 0;
	      int y = top/2;
	      magic[x][y] = 1;
	      
	      // 1�� �̹� ����ְ�, 2���� n by n���� �Է��ϸ鼭 �ִ°�
	      for (int i = 2; i <= (top+1)*(top+1); i++) {
	         
	         //���� �ִ� ��ġ�� x�� y�� ��ǥ��
	         int tempX = x;
	         int tempY = y;
	         
	         // �⺻�帧 x
	         if(x-1 < 0)
	            x = top;
	         else
	            x--;

	         // �⺻�帧 y
	         if(y-1 < 0)
	            y = top;
	         else
	            y--;
	         
	         if(magic[x][y] != 0){
	            x = tempX + 1;
	            y = tempY;
	         }
	         
	         magic[x][y] = i;

	      } // for
	   }
	   
	   // ������ ���
	   public void print(){
	      int count = top + 1;
	      
	      for (int i = 0; i < count; i++) {
	         
	         for (int j = 0; j < count; j++) {
	            System.out.print(magic[i][j]+"\t");
	         }
	         System.out.println();
	      }
	   }
	   
	   
	   //������ üũ
	   public boolean isChecked(){
		
		   boolean isT=true;
		   
		   //2*N+2
		   int count = top+1;
		   int[] mcheck = new int[2*count+2];
		   for (int i = 0; i < count; i++) {
			   for (int j = 0; j < count; j++) {
				   mcheck[i] += magic[i][j];
				   mcheck[i+count] += magic[j][i];
				   if(i == j){
					   mcheck[2*count] += magic[i][j];
				   }
				   if(i+j == count-1){
					   mcheck[2*count+1] += magic[i][j];
				   }
			   }		
		   }
		   
		   
		   for (int i = 0; i < mcheck.length; i++) {
			   if(mcheck[0] != mcheck[i]){
				   isT = false;
				   break;
			   }
		   }
		   return isT;
		   
	   }
	   
	   // assignment �����ϴ� �޼ҵ带 ����� ���� ��
	   
	}