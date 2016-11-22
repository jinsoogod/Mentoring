package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

public class Main {
	public static final int USERNUM = 4;
	
	public static void main(String[] args) {
		int count = 0;
		
//		카드섞기();
		CardCase cc = new CardCase();
		ArrayList<Card> list = cc.getCards();
		
		
		
		
		
//		유저준비();		2~4명
		UserSet userset = new UserSet(USERNUM);
		
//		유저한테배분 CardShare(카드케이스, 유저들, 유저숫자, 카드숫자)
		CardShare cs = new CardShare(list, userset, USERNUM, 8);
		cs.shareToUser();

		
		CardInteger cardInt = new CardInteger(userset);
		int[][] user1CardInt = null,
				user2CardInt = null,
				user3CardInt = null, 
				user4CardInt = null;
		
		
		switch (USERNUM) {
		case 2:
			user1CardInt = cardInt.cardInt(1);
			user2CardInt = cardInt.cardInt(2);
			break;
		case 3:
			user1CardInt = cardInt.cardInt(1);
			user2CardInt = cardInt.cardInt(2);
			user3CardInt = cardInt.cardInt(3);
			break;

		case 4:
			user1CardInt = cardInt.cardInt(1);
			user2CardInt = cardInt.cardInt(2);
			user3CardInt = cardInt.cardInt(3);
			user4CardInt = cardInt.cardInt(4);
			break;
		
		default:
			System.out.println("ArrayList -> int[][] 변환 오류");
			break;
		}
//		플레이어 1의 소유카드 출력(); userSelect(0~4) => 인덱스에 해당하는 유저의 소유카드 출력 (0이면 전부)
				UserCardShow userCardShow = new UserCardShow(userset);
				userCardShow.userSelect(0);
		
		
		System.out.println();
		
		CardRank rank = new CardRank(user1CardInt);
		
		rank.pair(user1CardInt);
	}

}
