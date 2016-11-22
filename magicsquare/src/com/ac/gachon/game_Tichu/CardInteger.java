package com.ac.gachon.game_Tichu;

import java.util.ArrayList;

public class CardInteger {
	UserSet us;	
//	ArrayList<Card> user1Int = us.user1;
//	ArrayList<Card> user2Int = us.user2;
//	ArrayList<Card> user3Int = us.user3;
//	ArrayList<Card> user4Int = us.user4;
//	
	public CardInteger(UserSet us) {
		this.us = us;
		
	}
	
	
	
	public int[][] cardInt (int index) {
		int[][] userCardInt = new int[2][8];
		int grim = 0;
		int num = 0;
		
		switch (index) {
		case 1:
			for (int i = 0 ; i < 8 ; i++ )	 {	
				switch	(us.user1.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;
				
				switch	(us.user1.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for
			break;

		case 2:
			for (int i = 0 ; i < 8 ; i++ )	 {	
				switch	(us.user2.get(i).getCard().charAt(0)) {
				case '♠':
					grim = 1;
					break;
				case '◇':
					grim = 2;
					break;
				case '♡':
					grim = 3;	
					break;
				case '♣':
					grim = 4;
					break;
				}
				userCardInt[0][i] = grim;
				
				switch	(us.user2.get(i).getCard().charAt(1)) {
				case '2':
					num = 2;
					break;
				case '3':
					num = 3;
					break;
				case '4':
					num = 4;
					break;
				case '5':
					num = 5;
					break;
				case '6':
					num = 6;
					break;
				case '7':
					num = 7;
					break;
				case '8':
					num = 8;
					break;
				case '9':
					num = 9;
					break;
				case 'T':
					num = 10;
					break;
				case 'J':
					num = 11;
					break;
				case 'Q':
					num = 12;
					break;
				case 'K':
					num = 13;
					break;
				case 'A':
					num = 14;
					break;
				}
				userCardInt[1][i] = num;
			} // for
			break;

		case 3:
			try {
				for (int i = 0 ; i < 8 ; i++ )	 {	
					switch	(us.user3.get(i).getCard().charAt(0)) {
					case '♠':
						grim = 1;
						break;
					case '◇':
						grim = 2;
						break;
					case '♡':
						grim = 3;	
						break;
					case '♣':
						grim = 4;
						break;
					}
					userCardInt[0][i] = grim;
					
					switch	(us.user3.get(i).getCard().charAt(1)) {
					case '2':
						num = 2;
						break;
					case '3':
						num = 3;
						break;
					case '4':
						num = 4;
						break;
					case '5':
						num = 5;
						break;
					case '6':
						num = 6;
						break;
					case '7':
						num = 7;
						break;
					case '8':
						num = 8;
						break;
					case '9':
						num = 9;
						break;
					case 'T':
						num = 10;
						break;
					case 'J':
						num = 11;
						break;
					case 'Q':
						num = 12;
						break;
					case 'K':
						num = 13;
						break;
					case 'A':
						num = 14;
						break;
					}
					userCardInt[1][i] = num;
				} // for
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			break;

		case 4:
			try {
				for (int i = 0 ; i < 8 ; i++ )	 {	
					switch	(us.user4.get(i).getCard().charAt(0)) {
					case '♠':
						grim = 1;
						break;
					case '◇':
						grim = 2;
						break;
					case '♡':
						grim = 3;	
						break;
					case '♣':
						grim = 4;
						break;
					}
					userCardInt[0][i] = grim;
					
					switch	(us.user4.get(i).getCard().charAt(1)) {
					case '2':
						num = 2;
						break;
					case '3':
						num = 3;
						break;
					case '4':
						num = 4;
						break;
					case '5':
						num = 5;
						break;
					case '6':
						num = 6;
						break;
					case '7':
						num = 7;
						break;
					case '8':
						num = 8;
						break;
					case '9':
						num = 9;
						break;
					case 'T':
						num = 10;
						break;
					case 'J':
						num = 11;
						break;
					case 'Q':
						num = 12;
						break;
					case 'K':
						num = 13;
						break;
					case 'A':
						num = 14;
						break;
					}
					userCardInt[1][i] = num;
				} // for
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			
			break;

		default:
			System.out.println("참여한 유저만 입력해주세요 ! (숫자 1~4)");
			break;
		}
		
		
		return userCardInt;
	}
}
