package com.ac.gachon.game;

public class UserCardRank {
	   int[][] userCardInt = null;                     // 유저의 int형 카드배열을 받을 함수
	   String rankResult = null, userRankResult = null;   
	   boolean[][] userCardBool = new boolean[4][13];      // 족보 확인을 위한  boolean[][] 2차원 배열.
	   int[] numMatch = new int[13];                  //   페어를 구하기 위한 배열 
	   int[] rankNum = new int[4];                     // 8개의 족보의 순위를 담을 배열 (예정)
	   int[] selNum;                              //   유저가 입력한 카드 번호
	   
	   
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
	      int pairCount = 0, tripleCount = 0, fourCount = 0;      // 족보에서 페어(몇세트인지 포함),트리플,포카드를 찾기위한 변수
	      int straightCount = 0,straightFlushCount = 0;         // 스트레이트(몇장인지 포함), 스트레이트플러쉬를 찾기위한 변수
	      int sel = 0;                                 // 유저가 입력한 인덱스를 하나씩 저장할 변수
//	      int topNum=0,tripleTopNum=0;
	      for (int i = 0; i < selNum.length; i++) {
	         sel = selNum[i];
	         grim = userCardInt[0][sel];
	         num = userCardInt[1][sel];
	         userCardBool[grim-1][num-2] = true;
	      }
	      
	      /* 족보 검출을 위한 boolean 2차원 배열
	       * 52개의 칸중 유저가 선택한 패에 해당하는 값을 true 값으로 바꾼다.
	       * 
	                    y = 카드 2~A 는 0 ~ 12 에 해당한다.
	                xy   0   1   2   3   4   5   6   7   8   9   10   11   12
	      x   스페이드    0    0   1   0   0   0   1   1   0   1   0   0   0   0
	         다이아    1   0   0   1   0   1   0   1   0   0   0   0   0   1
	         하트      2   0   0   0   0   0   0   0   0   0   1   0   1   0
	         클로버    3   0   0   0   1   0   0   1   0   0   0   0   0   1
	                   ㄴ-- numMatch[0] = 0      ㄴ-- numMatch[6] = 3      ㄴ-- numMatch[12] = 2
	      
	            numMatch[i] 배열은 i에 해당하는 숫자의 카드를 몇장이나 가지고 있는지를 판별한다.
	       */
	      for (int i = 0; i < 13; i++) {
	         if(userCardBool[0][i] == true) numMatch[i]++;
	         if(userCardBool[1][i] == true) numMatch[i]++;
	         if(userCardBool[2][i] == true) numMatch[i]++;
	         if(userCardBool[3][i] == true) numMatch[i]++;
	         if(numMatch[i] == 2) {
	            pairCount++;      // 2장을 가지고있으면 페어 카운트++
//	            topNum = i;
	         }else if (numMatch[i] == 3) {
	            tripleCount++;      //   3장을 가지고 있으면 트리플 카운트 ++
//	            tripleTopNum = i;
	         }else if (numMatch[i] == 4) {
	            fourCount++;      //    4장을 가지고 있으면 포카드 카운트 ++
//	            topNum = i;
	         } 
//	         else if (numMatch[i] == 1) {
//	            topNum = i;
//	         }
	      }
	         // numMatch[i] 와 numMatch[i+1] 를 비교해서 둘다 1이상이면 ( 해당 카드를 한장이상 가지고 있으면) count++ 시키고, 
	         // 어느 하나라도 0 이면 ( 연속된 카드를 가지고 있지 않으면 ) count = 0으로 하여 다시 처음부터 count를 샌다.
	         // 만약 count 가 4이상이면 ( 연속된 숫자가 5장 이상이면) 스트레이트 카운트는 count가 된다 (연속된숫자의 카드가 몇장인지)
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
	      
	      // 스트레이트플러쉬를 6장 이상으로 찾는 방법을 생각하지 못함
	      
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
	      // 위에있을수록 높은 족보
	      // rankResult 에 해당 족보의 이름을 넣는다. 차후에 족보 비교를 위한 순위값을 넣을 예정. (0~7으로 7이 가장 높은 족보)
	      
	      
//	      // topNum이 11이상일때 문자로 바꿔주는게 필요 
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
	         rankResult = " 스트레이트 플러쉬";
	         cardRank=8;
	      }else if (fourCount >= 1){
	         rankResult = " 포 카드";
	         cardRank=7;
	      }else if(straightCount >= 1) {
	         rankResult = " 스트레이트 " + straightCount + "장";
	         cardRank=6;
	      }else if (pairCount >= 1 && tripleCount >= 1) {
	         rankResult = " 풀 하우스";
	         cardRank=5;
	      }else if (tripleCount >= 1) {
	         rankResult = " 트리플";
	         cardRank=4;
	      }else if (pairCount >= 2) {
	         rankResult = " 페어 " + pairCount + " 세트";
	         cardRank=3;
	      }else if (pairCount == 1) {
	         rankResult = " 원 페어";
	         cardRank=2;
	      }else rankResult = " 싱글";   cardRank=1;
	      
	         // 하나도 해당되지 않으면 (족보가 없으면 싱글)
	      
	      return rankResult;
	   }
	}
