
import java.util.*;



public class GuessGame {
	
	
	public int randNum() {
		
		Random random = new Random();
		int x = random.nextInt(100);
		
		return x;
	}
	
	public int  guessStart(int target) {
		
			int attempts = 10;
			int num; 
			
			Scanner sc = new Scanner(System.in);
		    System.out.print("Guess the number 0 - 100 : ");
		    
		while(attempts != 0) {
			
			  num  = sc.nextInt();
			  
			if(num == target) {
				System.out.print("You guessed Correct! | ");
				return attempts;
			}
			else if(num < target) {
				System.out.print("You Guessed Wrong! \n"+ "Increase the Number! | ");
			}
			else {
				System.out.print("You Guessed Wrong! \n"+"Decrease the Number! | ");
			}
			
			attempts--;
			System.out.println("Attempts left " + attempts);
		}
		
		return attempts;
		
	}
	
	
	public int calPoints(int num) {
		int points = (num * 10);
		
		return points;
	}
	
	public int updateHighScore(int num,int highscore) {
		if(num > highscore) {
			highscore = num;
		}
		return highscore;
	}
	
	public int startGame(int round , int highscore) {
	
		int randomNumber = randNum();
		
		System.out.println("**********  Round " + round + " | HighScore = " + highscore + "  **********");
		int retried = guessStart(randomNumber);
		
		int score = calPoints(retried);
		
		highscore = updateHighScore(score,highscore);
		System.out.println("Your score " + score + " | HighScore " +  highscore);
		
		return highscore;
		
	}
	
	
	
	public static void main(String args[]) {
		
		int round = 1;
		int highscore = 0;
		
		Scanner sc = new Scanner(System.in);
		
		GuessGame gg = new GuessGame();
		highscore = gg.startGame(round, highscore);
		
		while(true) {
			
		System.out.println("1.Do you want to play again?");
		System.out.println("2.Exit");
		int n = sc.nextInt();
		
		switch(n) {
	
		case 1: 
		 round++;	
		 highscore = gg.startGame(round, highscore);
		 break;
		
		case 2: System.exit(0);
		break;
		
		}
	
		}
		
	}
	
}
