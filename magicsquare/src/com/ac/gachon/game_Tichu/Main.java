package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

public class Main {
	public static final int USERNUM = 4;
	
	public static void main(String[] args) {
		int count = 0;
		
//		ī�弯��();
		CardCase cc = new CardCase();
		ArrayList<Card> list = cc.getCards();
		
		
		
		
		
//		�����غ�();		2~4��
		UserSet userset = new UserSet(USERNUM);
		
//		�������׹�� CardShare(ī�����̽�, ������, ��������, ī�����)
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
			System.out.println("ArrayList -> int[][] ��ȯ ����");
			break;
		}
//		�÷��̾� 1�� ����ī�� ���(); userSelect(0~4) => �ε����� �ش��ϴ� ������ ����ī�� ��� (0�̸� ����)
				UserCardShow userCardShow = new UserCardShow(userset);
				userCardShow.userSelect(0);
		
		
		System.out.println();
		
		CardRank rank = new CardRank(user1CardInt);
		
		rank.pair(user1CardInt);
	}

}
