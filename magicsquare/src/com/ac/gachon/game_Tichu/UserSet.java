package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

public class UserSet {
//	public static final int USERNUM = 2;
	public static ArrayList<Card> user1, user2, user3, user4;
//	public static int[][] user1, user2, user3, user4;
	
	public UserSet() {
		
	}
	
	public UserSet(int num) {
		switch (num) {
		case 2:
			user1 = new ArrayList<Card>();
			user2 = new ArrayList<Card>();
			
			break;
		
		case 3:
			user1 = new ArrayList<Card>();
			user2 = new ArrayList<Card>();
			user3 = new ArrayList<Card>();
			
			break;
			
		case 4:
			user1 = new ArrayList<Card>();
			user2 = new ArrayList<Card>();
			user3 = new ArrayList<Card>();
			user4 = new ArrayList<Card>();
			
			break;
			
		default:
			System.out.println("유저수는 2~4명, 숫자만 입력가능합니다");
			break;
		}
	}
	
	
	
	
	
//	ArrayList<Card> user1 = new ArrayList<Card>();
//	ArrayList<Card> user2 = new ArrayList<Card>();

	
	
	
	
	
	
	
	
	
	/*
	public static final int CARDMAX = 8;
	
	ArrayList<Card> user1 = new ArrayList<Card>();
	ArrayList<Card> user2 = new ArrayList<Card>();
	int i = 0;
	int cardCount = 0;
	int count = 0;
	
	
	CardCase cc = new CardCase();
	ArrayList<Card> list = cc.getCards();
	
	for (Card c : list) {
		System.out.print(c.getCard() + ",");
		count++;
		if(count % 10 == 0) {
			System.out.println();
		}
	}
	
	System.out.println();
	while(true) {
		user1.add(cardCount,list.get(i));
		list.remove(i);
		user2.add(cardCount,list.get(i));
		list.remove(i);
		cardCount++;
		if (cardCount == CARDMAX)
			break;
	}
	
	System.out.print("user1 의 카드들 : ");
	for (Card c : user1) {
		System.out.print(c.getCard() + ",");
	}
	System.out.println();
	System.out.print("user2 의 카드들 : ");
	for (Card c : user2) {
		System.out.print(c.getCard() + ",");
	}
	System.out.println();

	*/

}
