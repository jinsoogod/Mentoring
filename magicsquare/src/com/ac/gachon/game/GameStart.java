package com.ac.gachon.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameStart {         

   public static final int USERNUM = 4;
   public static final int CARDNUM = 13;      //한명당 가질 카드 장수
   public UserSet userset = null;
   int[][] user1CardInt, user2CardInt, user3CardInt, user4CardInt;
   
   
   public void setting() {      //게임시작전 카드와 유저를 세팅후 유저에게 카드를 분배.

//      카드섞기();
      CardCase cc = new CardCase();
      ArrayList<Card> list = cc.getCards();
      
//      유저세팅();      4명
      userset = new UserSet();
      
//      유저한테배분 CardShare(카드케이스, 유저들, 카드장수)
      CardShare cs = new CardShare(list, userset, CARDNUM);
      cs.shareToUser();
      
      /* 스트링으로 된 카드를 Int형으로 바꾸는 CardInteger
             y  = 손패 카드의 인덱스 0~12
            xy 0  1  2  3  4  5  6  7  8  9  10  11 12 
      x   문양   0  1  2  1  3  1  4  2  3  4  2   1   3  2      문양은 스페이스,다이아,하트,클로버가 1~4  
               숫자   1  5  8  4  10 12 9  9  8  6  2  14  13 14      숫자는 2부터 A가 2~14      
      */
      CardInteger cardInt = new CardInteger(userset);
      user1CardInt = cardInt.cardInt(1);
      user2CardInt = cardInt.cardInt(2);
      user3CardInt = cardInt.cardInt(3); 
      user4CardInt = cardInt.cardInt(4);
      
      
   }
   public void go() {      // 반복해서 실행할 실질적인 게임 플레이 코드들
      /* 구현 예정   1.    유저 2,3,4의 손패도 선택후 족보를 보여준다.
       *          1-1.각 유저들의 손패를 선택하는 코드를 간략화 한다.
               2.    각 유저당 선택한 카드들의 족보를 서로 비교해 가장 높은 족보를 낸 유저는 손패에서 해당 카드들이 삭제된다.
               2-2.같은 족보를 냈을 경우, 가장 높은 숫자를 비교해야하므로(스트레이트의 경우 장수와 가장높은 숫자가 같을경우 가장 높은숫자의 문양으로 비교)
                  족보 출력시  ' ♠Q 스트레이트 플러쉬 ' 같이 출력되게끔 구현하고, ♠Q를 따로 저장해놔야 한다.(높은숫자 비교용으로)
                2-3.선택한 카드들 중 족보에 해당되는 카드들만 삭제되게끔 구현해야한다.
               3.   1~2 를 반복한다.      (완료?)
               4.   가장 먼저 모든 카드를 손에서 없앤 유저가 승리하게끔 구현한다.
      */
      
      int userCount=1;
      //플레이어 1의 소유카드 출력(); userSelect(0~4) => 인덱스에 해당하는 유저의 소유카드 출력 (0이면 전부, 1이면 유저1의 카드 출력)
      UserCardShow userCardShow = new UserCardShow(userset);
      userCardShow.userSelect(0);
      System.out.println("\n");
      // 카드 숫자 입력
      Scanner sc = new Scanner(System.in);
      UserCardRank userCR;
      String user1Rank = null, user2Rank = null, user3Rank = null, user4Rank = null;
      while(true){
         userCardShow.userSelect(userCount);
         System.out.println("user "+userCount+" 의 카드들 중 내고싶은 카드의 숫자를 ,로 구분해 선택해주세요.");
         System.out.print("선택 : ");
         String sel = sc.next();
         // , 구분을 위한 토크나이저
         StringTokenizer st = new StringTokenizer(sel, ",");
         // 유저가 몇개의 인덱스를 입력했나를 저장하는 변수
         int tokenCount = st.countTokens();
         // 입력받은 인덱스들을 int[i] 배열에 저장한다.
         int[] selNum = new int[tokenCount];
         for (int j = 0; st.hasMoreTokens(); j++) {
            selNum[j] = Integer.parseInt(st.nextToken());
         }
         
         // 선택한 인덱스에 해당하는 카드들을 출력
         userCardShow.handCardSelect(selNum,userCount);
         
         // 유저 카드의 족보(Rank) 를 보여주는 UserCardRank(해당유저의카드Int형배열)
         switch (userCount) {
         case 1:   userCR = new UserCardRank(user1CardInt);
               //UserCardRank.userSelect(선택한인덱스의 배열) 은 족보의 이름을 String 형으로 리턴한다.
               user1Rank = userCR.userSelect(selNum);
               System.out.println(user1Rank);            break;
         case 2:   userCR = new UserCardRank(user2CardInt);
               user2Rank = userCR.userSelect(selNum);
               System.out.println(user2Rank);            break;
         case 3:   userCR = new UserCardRank(user3CardInt);
               user3Rank = userCR.userSelect(selNum);   
               System.out.println(user3Rank);            break;
         case 4:   userCR = new UserCardRank(user4CardInt);
               user4Rank = userCR.userSelect(selNum);
               System.out.println(user4Rank);            break;
         }
         if(userCount==4) {
            System.out.println(user1Rank);
            System.out.println(user2Rank);
            System.out.println(user3Rank);
            System.out.println(user4Rank);
            userCount = 1;
         } else userCount++;
      }
   }
}