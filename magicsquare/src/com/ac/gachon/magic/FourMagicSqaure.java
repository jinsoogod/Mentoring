package com.ac.gachon.magic;

public class FourMagicSqaure {
	private int[][] magic;
	int top;
	
	public FourMagicSqaure(){
		this(4);
	}

	public FourMagicSqaure(int n) {
		
		this.init(n);
	}

	private void init(int n) {
		magic = new int[n][n];
		top = n-1;
	}
	
	public void make(){
		makeRight();
		makeLeft();
	}

	private void makeLeft() {
		// TODO Auto-generated method stub
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

	private void makeRight() {
		// TODO Auto-generated method stub
		int count = top+1;
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count; j++) {
				magic[i][j] = i*count+j+1;
			}
		}
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
}
