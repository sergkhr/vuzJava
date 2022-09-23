package prac7;

import java.util.ArrayDeque;

public class DrunkGame {
	public static void play(){
		int[] arr = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};
		for (int i = 0; i < arr.length; i++) {
			int rand = (int)(Math.random()*arr.length);
			int temp = arr[i];
			arr[i] = arr[rand];
			arr[rand] = temp;
		}
		System.out.println("cards are:");
		for(int i = 0; i < 5; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		for(int i = 5; i < 10; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		ArrayDeque<Integer> player1 = new ArrayDeque<>();
		ArrayDeque<Integer> player2 = new ArrayDeque<>();
		for(int i = 0; i < 5; i++){
			player1.add(arr[i]);
		}
		for(int i = 5; i < 10; i++){
			player2.add(arr[i]);
		}
		for(int turn = 1; turn <= 106; turn++){
			int card1 = player1.poll();
			int card2 = player2.poll();
			if(card1 == 0 && card2 == 9){
				player1.add(card1);
				player1.add(card2);
			}
			else if(card1 == 9 && card2 == 0){
				player2.add(card1);
				player2.add(card2);
			}
			else if(card1 > card2){
				player1.add(card1);
				player1.add(card2);
			}
			else if(card1 < card2){
				player2.add(card1);
				player2.add(card2);
			}
			if(player1.isEmpty()){
				System.out.println("second " + turn);
				return;
			}
			else if(player2.isEmpty()){
				System.out.println("first " + turn);
				return;
			}

			//print turn
//			System.out.println("turn: " + turn);
//			System.out.println("player 1 card: " + card1);
//			System.out.println("player 2 card: " + card2);
		}
		System.out.println("botva");
	}
}
