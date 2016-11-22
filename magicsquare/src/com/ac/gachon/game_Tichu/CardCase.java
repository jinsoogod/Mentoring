package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

//�������� ī�带 �ϳ��� ����� ������ �� ī����� ��� ���� ���̽���

/* ���δٸ� 13 * 4 = 52 ���� ī�带 ����.
 * ��---- �߿�
 * */

public class CardCase {
	private ArrayList<Card> cards;
//	public int grim = Card.grim.length;  // 4��
//	public int num = Card.num.length;	// 13��
	
	
	public CardCase() {
		cards = new ArrayList<Card>();
		shuffle();
	}

	private void shuffle() {
		int count = 0;
		
		while(true) {
			Card cd = new Card();			
			if (!cards.contains(cd)) {		// ���� �ٸ��� ī��� �ְԲ�
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
