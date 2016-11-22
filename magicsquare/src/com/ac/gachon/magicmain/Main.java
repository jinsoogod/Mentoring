package com.ac.gachon.magicmain;

import java.util.ArrayList;

import com.ac.gachon.game.Card;
import com.ac.gachon.game.CardCase;
import com.ac.gachon.magic.FourMagicSqaure;
import com.ac.gachon.magic.OddMagicsquare;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		FourMagicSqaure four = new FourMagicSqaure();
//		four.make();
//		four.print();
//		System.out.println(four.isChecked());
		int count = 0;
		CardCase cc = new CardCase();
		ArrayList<Card> list = cc.getCards();
		for(Card card : list){
			System.out.print(card.getCard()+",");
			count++;
			if(count%10==0){
				System.out.println();
			}
		}
	}

}
