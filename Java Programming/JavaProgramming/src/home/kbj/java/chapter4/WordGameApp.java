package home.kbj.java.chapter4;

import java.util.Scanner;

/* title: n���� �����ϴ� �����ձ� ����
 * ó���ܾ�� "�ƹ���"
 * n���� �����ڵ��� ������� �ڽ��� �ܾ �Է��ϸ� �ȴ�. �����ձ⿡�� ������ Ʋ�� ��� ������ ������ ���ӿ��� �� �����ڸ� ȭ�鿡 ���
 * �ٽ�: ���� ���� ��ü�� �迭 ����� �����ϱ� ����
 * WordGameApp, ���� Player Ŭ���� �ۼ�
 * ���� �߿��� WordGameApp ��ü �ϳ��� ���� ���ڸ�ŭ�� Player ��ü ����
 */

/* hint
 * WordGameApp: ������, main(), ������ ��ü������ �����ϴ� run(): ���� ���� ��ŭ�� Player ��ü�� �迭�� ����
 * Player Ŭ����: ���� �������� �̸� �ʵ�� ����ڷκ��� �ܾ �Է¹޴� getWordFromUser()
 * �����ձ��� �������ο� ������ ����ϴ����� �Ǻ��ϴ� checkSuccess()
 */
public class WordGameApp {

	public WordGameApp() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordGameApp wordGameApp = new WordGameApp();
		wordGameApp.run();
	}

	void run() {
		System.out.println("Let's start Word Chain game.");

		// personnel
		Scanner sc = new Scanner(System.in);
		System.out.print("How many people are participating in the game?>>");
		int personnel = sc.nextInt();

		// create object array
		Player[] player = new Player[personnel];
		
		// enter name
		for(int i = 0; i < personnel; i++) {
			System.out.print("Please enter participant name>>");
			String name = sc.next();
			player[i] = new Player(name);
		}
		
		String preWord = "�ƹ���"; // start_word & pre_word
		System.out.printf("The starting word is %s \n", preWord);

		boolean game = true; // keep going game flag
		int j = 0; // control player
		while(game) {
			String postWord = player[j].getWordFromUser();
			if(player[j].checkSuccess(preWord, postWord)) {
				j++;
				preWord = postWord;
			}
			else {
				game = false;
				System.out.printf("%s lose", player[j].name);
			}
			
			// init loop
			if(j >= personnel)
				j = 0;
		}
		
		sc.close();
	}
}

class Player {
	String name;

	Player(String name) {
		this.name = name;
	}
	
	String getWordFromUser() {
		Scanner sc = new Scanner(System.in); // resource leak..
		System.out.printf("%s>> ", name);
		String word = sc.next();

		return word;
	}

	boolean checkSuccess(String preWord, String postWord) {
		int lastIndex = preWord.length()-1;
		char last = preWord.charAt(lastIndex);
		char first = postWord.charAt(0);
		
		if(last == first)
			return true;
		else
			return false;
	}
}

/* result
 * Let's start "Word Chain" game.
 * How many people are participating in the game?>>3
 * Please enter participant name>>Ȳ����
 * The starting word is "�ƹ���"
 * player1 name>>
 * player2 lose.
 */