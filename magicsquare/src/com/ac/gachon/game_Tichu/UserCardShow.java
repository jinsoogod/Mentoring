package com.ac.gachon.game_Tichu;

public class UserCardShow {
//	�÷��̾� 1�� ����ī�� ���(); UserCardShow(userset, 0~4) => �ε����� �ش��ϴ� ������ ����ī�� ��� (0�̸� ����)
	UserSet us;
	int index;
	
	public UserCardShow(UserSet us) {
		this.us = us;
	}
	
	public void userSelect(int index) {
		this.index = index;
		
		switch (index) {
		case 0:
			System.out.print("user1 �� ī��� : ");
			for (Card c : us.user1) {
				System.out.print(c.getCard());
				System.out.print(" . ");
			}
			System.out.println();
			
			System.out.print("user2 �� ī��� : ");
			for (Card c : us.user2) {
				System.out.print(c.getCard());
				System.out.print(" . ");
			}
			System.out.println();
			
			try {
				us.user3.get(0);
				System.out.print("user3 �� ī��� : ");
				for (Card c : us.user3) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
				
				
				us.user4.get(0);
				System.out.print("user4 �� ī��� : ");
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
				System.out.print("user1 �� ī��� : ");
				for (Card c : us.user1) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("�ش� ������ �������� �ʾҽ��ϴ�.");
			}
			break;

		case 2:
			try {
				System.out.print("user2 �� ī��� : ");
				for (Card c : us.user2) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("�ش� ������ �������� �ʾҽ��ϴ�.");
			}
			break;

		case 3:
			
			try {
				System.out.print("user3 �� ī��� : ");
				for (Card c : us.user3) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("�ش� ������ �������� �ʾҽ��ϴ�.");
			}
			break;

		case 4:
			try {
				System.out.print("user4 �� ī��� : ");
				for (Card c : us.user4) {
					System.out.print(c.getCard());
					System.out.print(" . ");
				}
				System.out.println();
			} catch (Exception e) {
				System.out.println("�ش� ������ �������� �ʾҽ��ϴ�.");
			}
			break;

		default:
			System.out.println("���� �ε��� 0 ���� �ִ� 4 ���� �Է��ϼ���");
			break;
		}
	}
}
