package com.ac.gachon.game;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class GameStart {         

   public static final int USERNUM = 4;
   public static final int CARDNUM = 13;      //�Ѹ�� ���� ī�� ���
   public UserSet userset = null;
   int[][] user1CardInt, user2CardInt, user3CardInt, user4CardInt;
   
   
   public void setting() {      //���ӽ����� ī��� ������ ������ �������� ī�带 �й�.

//      ī�弯��();
      CardCase cc = new CardCase();
      ArrayList<Card> list = cc.getCards();
      
//      ��������();      4��
      userset = new UserSet();
      
//      �������׹�� CardShare(ī�����̽�, ������, ī�����)
      CardShare cs = new CardShare(list, userset, CARDNUM);
      cs.shareToUser();
      
      /* ��Ʈ������ �� ī�带 Int������ �ٲٴ� CardInteger
             y  = ���� ī���� �ε��� 0~12
            xy 0  1  2  3  4  5  6  7  8  9  10  11 12 
      x   ����   0  1  2  1  3  1  4  2  3  4  2   1   3  2      ������ �����̽�,���̾�,��Ʈ,Ŭ�ι��� 1~4  
               ����   1  5  8  4  10 12 9  9  8  6  2  14  13 14      ���ڴ� 2���� A�� 2~14      
      */
      CardInteger cardInt = new CardInteger(userset);
      user1CardInt = cardInt.cardInt(1);
      user2CardInt = cardInt.cardInt(2);
      user3CardInt = cardInt.cardInt(3); 
      user4CardInt = cardInt.cardInt(4);
      
      
   }
   public void go() {      // �ݺ��ؼ� ������ �������� ���� �÷��� �ڵ��
      /* ���� ����   1.    ���� 2,3,4�� ���е� ������ ������ �����ش�.
       *          1-1.�� �������� ���и� �����ϴ� �ڵ带 ����ȭ �Ѵ�.
               2.    �� ������ ������ ī����� ������ ���� ���� ���� ���� ������ �� ������ ���п��� �ش� ī����� �����ȴ�.
               2-2.���� ������ ���� ���, ���� ���� ���ڸ� ���ؾ��ϹǷ�(��Ʈ����Ʈ�� ��� ����� ������� ���ڰ� ������� ���� ���������� �������� ��)
                  ���� ��½�  ' ��Q ��Ʈ����Ʈ �÷��� ' ���� ��µǰԲ� �����ϰ�, ��Q�� ���� �����س��� �Ѵ�.(�������� �񱳿�����)
                2-3.������ ī��� �� ������ �ش�Ǵ� ī��鸸 �����ǰԲ� �����ؾ��Ѵ�.
               3.   1~2 �� �ݺ��Ѵ�.      (�Ϸ�?)
               4.   ���� ���� ��� ī�带 �տ��� ���� ������ �¸��ϰԲ� �����Ѵ�.
      */
      
      int userCount=1;
      //�÷��̾� 1�� ����ī�� ���(); userSelect(0~4) => �ε����� �ش��ϴ� ������ ����ī�� ��� (0�̸� ����, 1�̸� ����1�� ī�� ���)
      UserCardShow userCardShow = new UserCardShow(userset);
      userCardShow.userSelect(0);
      System.out.println("\n");
      // ī�� ���� �Է�
      Scanner sc = new Scanner(System.in);
      UserCardRank userCR;
      String user1Rank = null, user2Rank = null, user3Rank = null, user4Rank = null;
      while(true){
         userCardShow.userSelect(userCount);
         System.out.println("user "+userCount+" �� ī��� �� ������� ī���� ���ڸ� ,�� ������ �������ּ���.");
         System.out.print("���� : ");
         String sel = sc.next();
         // , ������ ���� ��ũ������
         StringTokenizer st = new StringTokenizer(sel, ",");
         // ������ ��� �ε����� �Է��߳��� �����ϴ� ����
         int tokenCount = st.countTokens();
         // �Է¹��� �ε������� int[i] �迭�� �����Ѵ�.
         int[] selNum = new int[tokenCount];
         for (int j = 0; st.hasMoreTokens(); j++) {
            selNum[j] = Integer.parseInt(st.nextToken());
         }
         
         // ������ �ε����� �ش��ϴ� ī����� ���
         userCardShow.handCardSelect(selNum,userCount);
         
         // ���� ī���� ����(Rank) �� �����ִ� UserCardRank(�ش�������ī��Int���迭)
         switch (userCount) {
         case 1:   userCR = new UserCardRank(user1CardInt);
               //UserCardRank.userSelect(�������ε����� �迭) �� ������ �̸��� String ������ �����Ѵ�.
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