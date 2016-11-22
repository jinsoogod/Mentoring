package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

public class CardShare {
	int cardCount = 0;
	int i = 0;
	ArrayList<Card> list;
	UserSet us;
	int userNum;
	int cardNum;
	
	public CardShare() {
		list = null;
		us = null;
		userNum = 0;
		cardNum = 0;
	}
	
	public CardShare(ArrayList<Card> list,UserSet us, int userNum, int cardNum) {
		this.list = list;
		this.us = us;
		this.userNum = userNum;
		this.cardNum = cardNum;
		System.out.println(list.get(i));
	}
	
	public void shareToUser() {
		
			switch (userNum) {
			case 2:
				while(true) {
					us.user1.add(cardCount,list.get(i));
					list.remove(i);
					us.user2.add(cardCount,list.get(i));
					list.remove(i);
					cardCount++;
					if (cardCount == cardNum)
						break;
				}
				break;

			case 3:
				while(true) {
					us.user1.add(cardCount,list.get(i));
					list.remove(i);
					us.user2.add(cardCount,list.get(i));
					list.remove(i);
					us.user3.add(cardCount,list.get(i));
					list.remove(i);
					cardCount++;
					if (cardCount == cardNum)
						break;
				}
				break;
				
			case 4:
				while(true) {
					
					us.user1.add(cardCount,list.get(i));
					list.remove(i);
					us.user2.add(cardCount,list.get(i));
					list.remove(i);
					us.user3.add(cardCount,list.get(i));
					list.remove(i);
					us.user4.add(cardCount,list.get(i));
					list.remove(i);
					cardCount++;
					if (cardCount == cardNum)
						break;
				}
				break;

			default:
				System.out.println("CardShare 오류 발생");
				break;
			}
		
	}
	
	
	
	
	
	
	
	
//	public CardShare(int num, ArrayList<Card> cc) {
//		while(true) {
//			user1.add(cardCount,cc.get(i));
//			cc.remove(i);
//			user2.add(cardCount,cc.get(i));
//			cc.remove(i);
//			cardCount++;
//			if (cardCount == num)
//				break;
//		}
//	}
}
