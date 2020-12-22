package home.kbj.java.chapter3;

import java.util.Scanner;

public class ChapterThreeEnd {
	/* ��ǻ�Ϳ� ���� ������ ���� ���� �� ������ ������. ���ں��� ���� �����Ѵ�.
	 * ���ڰ� ���� ���� �� �� �ϳ��� �Է��ϰ� <Enter>Ű�� ġ��,
	 * ���α׷��� ���� ���� �� �߿��� �����ϰ� �ϳ��� �����ϰ� ��ǻ�Ͱ� �� ������ �Ѵ�.
	 * ���ڰ� �Է��� ���� �����ϰ� ������ ���� ���Ͽ� ���� �̰���� �Ǵ��Ѵ�.
	 * ���ڰ� ���� ���� �� ��� "�׸�"�� �Է��ϸ� ������ ������.
	 */
	public static void main(String[] args) {
		// create object
		ChapterThreeEnd chapterThreeEnd = new ChapterThreeEnd();
		
		// input
		String computer[] = {"scissors", "rock", "paper"}; // computer array
		
		// function: rock scissors paper game
		boolean result = chapterThreeEnd.gameRockScissorsPaper(computer);
		if(!result)
			System.out.println("exit game");
		 
	}
	
	private boolean gameRockScissorsPaper(String[] computer) {
		boolean gameFlag = true;	// Whether or not to play the game
		
		System.out.println("let's start rock scissors paper game with computer.");
		Scanner sc = new Scanner(System.in);

		// game start
		while(gameFlag) {
			boolean userWin = false;
			boolean computerWin = false;
			
			System.out.print("rock scissors paper!>> ");
			String user = sc.next();
			
			// computer random variable
			int n = (int)(Math.random() * computer.length);
			
			// compare computer with user
			switch (computer[n]) {
			case "rock":
				// user win - lose - draw
				if("paper".equals(user)) {
					userWin = true; computerWin = false;
				}
				else if("scissors".equals(user)) {
					userWin = false; computerWin = true;
				}
				else if("rock".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;
			case "scissors":
				if("rock".equals(user)){
					userWin = true; computerWin = false;
				}
				else if("paper".equals(user)){
					userWin = false; computerWin = true;
				}
				else if("scissors".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;
			case "paper":
				if("scissors".equals(user)){
					userWin = true; computerWin = false;
				}
				else if("rock".equals(user)){
					userWin = false; computerWin = true;
				}
				else if("paper".equals(user)) {
					userWin = true; computerWin = true;
				}
				else
					gameFlag = false;
				break;	
			default:
				System.out.println("This is no rock, scissors and paper in computer \n");
				gameFlag = false;
				break;
			}
			
			// print result
			if(userWin && !computerWin)
				System.out.printf("user = %s, computer = %s, user win \n", user, computer[n]);
			if(!userWin && computerWin)
				System.out.printf("user = %s, computer = %s, computer win \n", user, computer[n]);
			if(userWin && computerWin)
				System.out.printf("user = %s, computer = %s, draw \n", user, computer[n]);
		}
		
		return gameFlag;
	}
	
	/* Scenario
	 * let's start rock scissors paper game with computer.
	 * rock scissors paper!>> rock
	 * user = "", computer = "", "" win, lose, draw
	 * exit game.
	 */
	
}
