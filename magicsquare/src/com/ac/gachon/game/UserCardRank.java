package com.ac.gachon.game;

public class UserCardRank {
	   int[][] userCardInt = null;                     // ������ int�� ī��迭�� ���� �Լ�
	   String rankResult = null, userRankResult = null;   
	   boolean[][] userCardBool = new boolean[4][13];      // ���� Ȯ���� ����  boolean[][] 2���� �迭.
	   int[] numMatch = new int[13];                  //   �� ���ϱ� ���� �迭 
	   int[] rankNum = new int[4];                     // 8���� ������ ������ ���� �迭 (����)
	   int[] selNum;                              //   ������ �Է��� ī�� ��ȣ
	   
	   
	   public UserCardRank(int[][] userCardInt) {
	      this.userCardInt = userCardInt;
	   }
	   
	   public String userSelect(int[] selNum) {
	      this.selNum = selNum;
	      
	      userRankResult = rankMatch();
	      
	      return userRankResult;
	   }
	   
	   public String rankMatch() {
	      int grim = 0, num = 0;
	      int pairCount = 0, tripleCount = 0, fourCount = 0;      // �������� ���(�Ʈ���� ����),Ʈ����,��ī�带 ã������ ����
	      int straightCount = 0,straightFlushCount = 0;         // ��Ʈ����Ʈ(�������� ����), ��Ʈ����Ʈ�÷����� ã������ ����
	      int sel = 0;                                 // ������ �Է��� �ε����� �ϳ��� ������ ����
//	      int topNum=0,tripleTopNum=0;
	      for (int i = 0; i < selNum.length; i++) {
	         sel = selNum[i];
	         grim = userCardInt[0][sel];
	         num = userCardInt[1][sel];
	         userCardBool[grim-1][num-2] = true;
	      }
	      
	      /* ���� ������ ���� boolean 2���� �迭
	       * 52���� ĭ�� ������ ������ �п� �ش��ϴ� ���� true ������ �ٲ۴�.
	       * 
	                    y = ī�� 2~A �� 0 ~ 12 �� �ش��Ѵ�.
	                xy   0   1   2   3   4   5   6   7   8   9   10   11   12
	      x   �����̵�    0    0   1   0   0   0   1   1   0   1   0   0   0   0
	         ���̾�    1   0   0   1   0   1   0   1   0   0   0   0   0   1
	         ��Ʈ      2   0   0   0   0   0   0   0   0   0   1   0   1   0
	         Ŭ�ι�    3   0   0   0   1   0   0   1   0   0   0   0   0   1
	                   ��-- numMatch[0] = 0      ��-- numMatch[6] = 3      ��-- numMatch[12] = 2
	      
	            numMatch[i] �迭�� i�� �ش��ϴ� ������ ī�带 �����̳� ������ �ִ����� �Ǻ��Ѵ�.
	       */
	      for (int i = 0; i < 13; i++) {
	         if(userCardBool[0][i] == true) numMatch[i]++;
	         if(userCardBool[1][i] == true) numMatch[i]++;
	         if(userCardBool[2][i] == true) numMatch[i]++;
	         if(userCardBool[3][i] == true) numMatch[i]++;
	         if(numMatch[i] == 2) {
	            pairCount++;      // 2���� ������������ ��� ī��Ʈ++
//	            topNum = i;
	         }else if (numMatch[i] == 3) {
	            tripleCount++;      //   3���� ������ ������ Ʈ���� ī��Ʈ ++
//	            tripleTopNum = i;
	         }else if (numMatch[i] == 4) {
	            fourCount++;      //    4���� ������ ������ ��ī�� ī��Ʈ ++
//	            topNum = i;
	         } 
//	         else if (numMatch[i] == 1) {
//	            topNum = i;
//	         }
	      }
	         // numMatch[i] �� numMatch[i+1] �� ���ؼ� �Ѵ� 1�̻��̸� ( �ش� ī�带 �����̻� ������ ������) count++ ��Ű��, 
	         // ��� �ϳ��� 0 �̸� ( ���ӵ� ī�带 ������ ���� ������ ) count = 0���� �Ͽ� �ٽ� ó������ count�� ����.
	         // ���� count �� 4�̻��̸� ( ���ӵ� ���ڰ� 5�� �̻��̸�) ��Ʈ����Ʈ ī��Ʈ�� count�� �ȴ� (���ӵȼ����� ī�尡 ��������)
	      int count = 0;
	      for (int i = 0; i < 11; i++) {
	         
	         if (numMatch[i]>=1 && numMatch[i+1]>=1) {
	            count++;
	            if(count >= 4) {
	               straightCount = count;
//	               topNum = i+1;
	            }
	         }
	         else count = 0;      
	      }
	      
	      // ��Ʈ����Ʈ�÷����� 6�� �̻����� ã�� ����� �������� ����
	      
	      for (int i = 0; i < 4; i++) {
	         for (int j = 0; j < 9; j++) {
	            if(userCardBool[i][j]
	               && userCardBool[i][j+1]
	               && userCardBool[i][j+2]
	               && userCardBool[i][j+3]
	               && userCardBool[i][j+4]) {
	               straightFlushCount++;
//	               topNum = j+4;
	            }
	         }
	      }
	      // ������������ ���� ����
	      // rankResult �� �ش� ������ �̸��� �ִ´�. ���Ŀ� ���� �񱳸� ���� �������� ���� ����. (0~7���� 7�� ���� ���� ����)
	      
	      
//	      // topNum�� 11�̻��϶� ���ڷ� �ٲ��ִ°� �ʿ� 
//	      String strTopNum = null;
//	      if(topNum < 9) {
//	         strTopNum = String.valueOf(topNum+2);
//	      } else if(tripleTopNum < 9) {
//	         strTopNum = String.valueOf(tripleTopNum+2);
//	      } else {
//	         if(topNum == 9 || tripleTopNum == 9) strTopNum = "J";
//	         else if(topNum == 10 || tripleTopNum == 10) strTopNum = "Q";
//	         else if(topNum == 11 || tripleTopNum == 11) strTopNum = "K";
//	         else if(topNum == 12 || tripleTopNum == 12) strTopNum = "A";
//	      }
//	      
//	      
	      int cardRank;
	      
	      if(straightFlushCount >= 1){
	         rankResult = " ��Ʈ����Ʈ �÷���";
	         cardRank=8;
	      }else if (fourCount >= 1){
	         rankResult = " �� ī��";
	         cardRank=7;
	      }else if(straightCount >= 1) {
	         rankResult = " ��Ʈ����Ʈ " + straightCount + "��";
	         cardRank=6;
	      }else if (pairCount >= 1 && tripleCount >= 1) {
	         rankResult = " Ǯ �Ͽ콺";
	         cardRank=5;
	      }else if (tripleCount >= 1) {
	         rankResult = " Ʈ����";
	         cardRank=4;
	      }else if (pairCount >= 2) {
	         rankResult = " ��� " + pairCount + " ��Ʈ";
	         cardRank=3;
	      }else if (pairCount == 1) {
	         rankResult = " �� ���";
	         cardRank=2;
	      }else rankResult = " �̱�";   cardRank=1;
	      
	         // �ϳ��� �ش���� ������ (������ ������ �̱�)
	      
	      return rankResult;
	   }
	}
