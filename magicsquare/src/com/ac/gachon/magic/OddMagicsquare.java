package com.ac.gachon.magic;


// 홀수 마방진 구현하기
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
	      
	      // 1은 이미 들어있고, 2부터 n by n까지 입력하면서 넣는것
	      for (int i = 2; i <= (top+1)*(top+1); i++) {
	         
	         //원래 있던 위치의 x와 y의 좌표값
	         int tempX = x;
	         int tempY = y;
	         
	         // 기본흐름 x
	         if(x-1 < 0)
	            x = top;
	         else
	            x--;

	         // 기본흐름 y
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
	   
	   // 마방진 출력
	   public void print(){
	      int count = top + 1;
	      
	      for (int i = 0; i < count; i++) {
	         
	         for (int j = 0; j < count; j++) {
	            System.out.print(magic[i][j]+"\t");
	         }
	         System.out.println();
	      }
	   }
	   
	   
	   //마방진 체크
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
	   
	   // assignment 검증하는 메소드를 만들어 오는 것
	   
	}