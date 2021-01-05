package home.kbj.java.chapter13;

import java.util.Scanner;

/* title: ������ ������ ����� */
/* condition
 * ������ڸ��� 1~10���� �ܼ� â�� ������ �� �����ϴ� �����带 Runnable �������̽��� �̿�
 * main �޼ҵ忡���� ����ڰ� �ƹ� ���ڳ� �Է��ϰ� enterġ�� ������ ��ü�� �����ϰ� ����
 * */
public class ChapterThirteenExampleOne{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		PrintThread pt = new PrintThread();
		System.out.print("Enter any key>> ");
		if(sc.next() != null)
			pt.run();
		System.out.println("Thread termination");
		sc.close();
	}
}

class PrintThread implements Runnable {
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Start thread execution");
		for(int i = 1; i <= 10; i++)
			System.out.printf("%d ", i);
		System.out.println();
	}
}

/* result
 * �ƹ� Ű�� �Է�>> go		Enter any key
 * ������ ���� ����			Start thread execution
 * 1 2 ... 10
 * ������ ����				Thread termination
 * */
