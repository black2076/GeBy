package home.kbj.java.chapter13;

import java.util.Scanner;

/* title: Ÿ�̸� ������ */
/* condition
 * �ƹ� Ű�� �Է¹����� ��ǥ(x, y)�� 400ms�� �������� ������ ��ġ�� �̵�
 * */
public class ChapterThirteenExampleTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("Enter any key>> ");
		Scanner sc = new Scanner(System.in);
		if(sc.next() != null)
			new RandomLocationThread().start();
		sc.close();
	}

}


class RandomLocationThread extends Thread {
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			int x = (int)(Math.random() * 10);
			int y = (int)(Math.random() * 10);
			
			System.out.printf("(%d, %d) \n", x, y);
			
			try {
				Thread.sleep(400);
			}
			catch (InterruptedException e) {
				System.out.println("[Exception] RandomLocationThread State : RUNNABLE..");
				e.printStackTrace();
			}
		}
		
	}
	
}

/* result
 * Enter any key >> go
 * (1, 1)
 * (5, 10)
 * (8, 2)
 * ...
 */