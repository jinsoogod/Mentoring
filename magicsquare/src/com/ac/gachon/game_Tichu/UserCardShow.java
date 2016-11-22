package com.ac.gachon.game_Tichu;

public class UserCardShow {
//	플레이어 1의 소유카드 출력(); UserCardShow(userset, 0~4) => 인덱스에 해당하는 유저의 소유카드 출력 (0이면 전부)
	UserSet us;
	int index;
	
	public UserCardShow(UserSet us) {
		this.us = us;
	}
	
	public void userSelect(int index) {
		this.index = index;
		
		switch (index) {
		case 0:
			System.out.print("user1 의 카드들 : ");
			for (Card c : us.user1) {
				System.out.print(c.getCard());
				System.out.print(" . ");
			}
			System.out.println();
			
			System.out.print("user2 의 카드들 : ");
			for (Card c : us.user2) {
				System.out.print(c.getCard());
				System.out.print(" . ");
			}
			System.out.println();
			
			try {
				us.user3.get(0);
				System.out.print("user3 의 카드들 : ");
				for (Card c : us.user3) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
				
				
				us.user4.get(0);
				System.out.print("user4 의 카드들 : ");
				for (Card c : us.user4) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
				
			} catch (Exception e) {
				
			}
			
			break;

		case 1:
			try {
				System.out.print("user1 의 카드들 : ");
				for (Card c : us.user1) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			break;

		case 2:
			try {
				System.out.print("user2 의 카드들 : ");
				for (Card c : us.user2) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			break;

		case 3:
			
			try {
				System.out.print("user3 의 카드들 : ");
				for (Card c : us.user3) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			break;

		case 4:
			try {
				System.out.print("user4 의 카드들 : ");
				for (Card c : us.user4) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("해당 유저는 참여하지 않았습니다.");
			}
			break;

		default:
			System.out.println("유저 인덱스 0 부터 최대 4 까지 입력하세요");
			break;
		}
	}
}
