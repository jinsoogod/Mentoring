package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

//랜덤으로 카드를 하나씩 만들게 했으니 그 카드들을 모아 담을 케이스를

/* 서로다른 13 * 4 = 52 개의 카드를 만듬.
 * ㄴ---- 중요
 * */

public class CardCase {
	private ArrayList<Card> cards;
//	public int grim = Card.grim.length;  // 4개
//	public int num = Card.num.length;	// 13개
	
	
	public CardCase() {
		cards = new ArrayList<Card>();
		shuffle();
	}

	private void shuffle() {
		int count = 0;
		
		while(true) {
			Card cd = new Card();			
			if (!cards.contains(cd)) {		// 값이 다르면 카드즈에 넣게끔
				cards.add(cd);
				count++;
			}
			
			if(count == 52) {
				break;
			}
		}
	}

	public ArrayList<Card> getCards() {
		return cards;
	}
	
}
