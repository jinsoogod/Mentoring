package com.ac.gachon.game;

import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {
		
		GameStart gamestart = new GameStart();
		
		gamestart.setting();
		gamestart.go();
		
		
		// 카드케이스에서 인덱스 0 인 카드를 꺼내는 방법.
//		System.out.println();
//		System.out.println(list.get(0).getCard());
//		// 인덱스 0 의 카드를 삭제하면 인덱스 1의 카드가 0으로. -> 플레이어에게 카드 배분후 삭제 배부 삭제 반복
//		list.remove(0);
//		System.out.println(list.get(0).getCard());
//		

//		// 유저의 카드 하나를 확인하는 방법
//		System.out.println(userset.user1.get(0).getCard());
		

	}
}
