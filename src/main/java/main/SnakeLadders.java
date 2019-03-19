package main;

import java.util.Random;
import java.util.Scanner;

public class SnakeLadders{
	public static int [][] board;
	//random function to generate random number between 0 to 4
	public static int  random() {
		Random rand = new Random(); 
		int value1 = rand.nextInt(5);
		return value1; 
	}
	public static boolean snake(int i,int j) {
		//snake is in 4th place thats the co-ordinate [1,2] i.e, i=1 & j=2
		//write your code here
		if( i==1 && j==2 ) {
			return true;
		}
		return false;
	}
	public static boolean ladder(int i,int j) {
		//ladder is in 3rd place thats the co-ordinate [0,3] i.e, i=0 and j=2
		//write your code here
		if( i==0 && j==2 ) {
			return true;
		}
		return false;
	}
	public static boolean gameOver(int score) {
		//if the score is greater than 9 you win. 
		//write your code here
		if( score>=9 ) {
			return true;
		}
		return false;
	}
	public static void main(String args[]) {
		board = new int[3][3];
		int k = 1;
		//initializing board array: each square represents 1 unit (from 1 to 9)
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j] = k++;
			}
		}
		
		Scanner sc = new Scanner(System.in);
		//Printing board 
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Enter 'y' to roll the dice");
		char y = sc.next().charAt(0);
		int dice=-1;
		if(y=='y') {
			dice = random();//outcome of rolling dice between 1 to 6
		}
		int place = 0;
		place = place + dice; // place at player reached on board
		System.out.println("Outcome of dice: "+dice);
	
		while(true) {
			int play = place;
			for(int i=0;i<3;i++) {
				for(int j=0;j<3;j++) {
					//We use play-- till it reaches to 0 at particular index such as [0,2] for ladder and [1,2] for snake
					play --;
					if(play==0) {
						if(snake(i,j)) { //if play==0 at index[1,2] then snakes bites player
							place = place - 4;
						}
						if(ladder(i,j)) { //if play==0 at index[0,2] then it catches a ladder
							place = place +5;
						}
					}
				}
			}
			System.out.println("Enter y");
			y = sc.next().charAt(0);
			if(y=='y') {
				dice = random();
			}
			place = place + dice;
			System.out.println("Outcome of dice: "+dice);
			if(gameOver(place)) {
				break;
			}

		}
		System.out.println("you won!");
	}
	
}