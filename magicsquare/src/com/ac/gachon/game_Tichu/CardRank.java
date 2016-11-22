package com.ac.gachon.game_Tichu;



public class CardRank {
	
	int[][]user1CardInt;
	int pairCount=0;
	int [] num = new int[8];
	int [] suit = new int[8];
	int temp, temp2;
	int pair, flush, straight;
	
	public CardRank(int[][] user1CardInt) {
		// TODO Auto-generated constructor stub
		this.user1CardInt = user1CardInt;
		
//		//비교 전 숫자에 따른 카드 정렬
//		for (int i = 0; i < 7; i++) {
//			for (int j = 0; j < 7 - i; j++) {
//				if(user1CardInt[1][j]>user1CardInt[1][j+1]){
//					temp = user1CardInt[1][j];
//					temp2 = user1CardInt[0][j];
//					user1CardInt[1][j] = user1CardInt[1][j+1];
//					user1CardInt[0][j] = user1CardInt[0][j+1];
//					user1CardInt[1][j+1] = temp; 
//					user1CardInt[0][j+1] = temp2;
//				}
//			}
//		}
		
//		//문양에 따른 카드 정렬
//		for (int i = 0; i < 7; i++) {
//			for (int j = 0; j < 7 - i; j++) {
//				if(user1CardInt[0][j]>user1CardInt[0][j+1]){
//					temp = user1CardInt[0][j];
//					temp2 = user1CardInt[1][j];
//					user1CardInt[0][j] = user1CardInt[0][j+1];
//					user1CardInt[1][j] = user1CardInt[1][j+1];
//					user1CardInt[0][j+1] = temp; 
//					user1CardInt[1][j+1] = temp2;
//				}
//			}
//		}
	}

	public int pair(int[][] userCardInt){
		
		for (int i = 0; i < 7; i++) {
		for (int j = 0; j < 7 - i; j++) {
			if(user1CardInt[1][j]>user1CardInt[1][j+1]){
				temp = user1CardInt[1][j];
				temp2 = user1CardInt[0][j];
				user1CardInt[1][j] = user1CardInt[1][j+1];
				user1CardInt[0][j] = user1CardInt[0][j+1];
				user1CardInt[1][j+1] = temp; 
				user1CardInt[0][j+1] = temp2;
			}
		}
	}
		for (int i = 0; i < 7; i++) {
			for (int j = i; j < 7; j++) {
				
				if(userCardInt[1][i] == userCardInt[1][j+1]){
					pair++;
				}
			}
		}
		System.out.println(pair);
		return 0;
		
	}
}
