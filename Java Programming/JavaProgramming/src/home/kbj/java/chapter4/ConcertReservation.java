package home.kbj.java.chapter4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* title: �ܼ�Ʈ ���� �ý��� */
/* condition
 * ������ �Ϸ翡 �� �� �ִ�.
 * �¼��� S��, A��, B������ ������, ���� 10���� �¼��� �ִ�
 * ���� �ý����� �޴��� "����", "��ȸ", "���", "������"�� �ִ�.
 * ������ �� �ڸ��� �����ϰ�, �¼� Ÿ��, ������ �̸�, �¼� ��ȣ�� ������� �Է¹޾� �����Ѵ�.
 * ��ȸ�� ��� �¼��� ����Ѵ�.
 * ��Ҵ� �������� �̸��� �Է¹޾� ����Ѵ�.
 * ���� �̸�, ���� ��ȣ, ���� �޴�, �߸��� ��� � ���ؼ� ���� �޽����� ����ϰ� ����ڰ� �ٽ� �õ��ϵ��� �Ѵ�.
 */
public class ConcertReservation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		// concert hall structure
		char[] totalSeatSection = {'S', 'A', 'B'};
		int[] seatCount = {10, 10, 10};
		
		// create concert hall
		Seat[] seat = new Seat[totalSeatSection.length];
		for(int i = 0; i < totalSeatSection.length; i++) {
			seat[i] = new Seat(totalSeatSection[i], seatCount[i]);
		}

		// reservation system start
		boolean isReservation = true;
		System.out.println("This is Luxury Concert Hall reservation system.");
		while(isReservation) {
			int seatSection;
			System.out.print("Reservation:1, Inquiry:2, Cancel:3, Exit:4>> ");
			int menuNum = sc.nextInt();
			switch (menuNum) {
			case 1:
				seatSection = classifySeat(totalSeatSection, seatCount);
				seat[seatSection].reservation();
				break;
			case 2:
				for(int i = 0; i < seat.length; i++)
					seat[i].inquiry();
				System.out.println("<<<You have completed your inquiry>>>");
				break;
			case 3:
				seatSection = classifySeat(totalSeatSection, seatCount);
				seat[seatSection].cancel();
				break;
			case 4:
				isReservation = false;
				sc.close();
				break;
			default:
				// error message
				System.out.printf("%d is doesn't exist in menu \n", menuNum);
				break;
			}
		}
	}
	
	@SuppressWarnings("resource")
	private static int classifySeat(char[] totalSeatSection, int[] seatCount) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Seat classification ");
		for(int i = 0; i < totalSeatSection.length; i++) {
			if(i == totalSeatSection.length-1)
				System.out.printf("%s(%d)>> ", totalSeatSection[i], i+1);
			else
				System.out.printf("%s(%d), ", totalSeatSection[i], i+1);
		}
		int seatSectionNumber = sc.nextInt()-1;
		return seatSectionNumber;
	}
}


class Seat {
	private char seatName;
	private int seatCount;
	private List<String> seat;
	
	Seat(char seatName, int seatCount) {
		this.seatName = seatName;
		this.seatCount = seatCount;
		seat = new ArrayList<String>(seatCount);
		for(int i = 0; i < this.seatCount; i++)
			seat.add("---");
	}

	@SuppressWarnings("resource")
	void reservation() {
		this.inquiry();
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("name>> ");
			String name = sc.next();
			System.out.print("seat number>> ");
			int seatNumber = sc.nextInt()-1;

			// error message
			if(seatNumber < 0 || seatNumber > this.seatCount) {
				System.out.printf("%d is doesn't exist in seat \n", seatNumber);
				continue;
			}
			
			// error message 2
			if(!this.seat.get(seatNumber).equals("---")) {
				System.out.println("already reserved");
				continue;
			}
			else {
				this.seat.add(seatNumber, name);
				break;
			}
		}
	}
	
	void inquiry() {
		System.out.printf("%c>> ", this.seatName);
		for(int i = 0; i < this.seatCount; i++) {
			System.out.print(seat.get(i) + " ");
		}
		System.out.println();
	}
	
	@SuppressWarnings("resource")
	void cancel() {
		this.inquiry();
	
		Scanner sc = new Scanner(System.in);
		boolean isCancel = true;
		while(isCancel) {
			System.out.print("name>> ");
			String name = sc.next();

			// name exist
			for(int i = 0; i < this.seatCount; i++) {
				if(this.seat.contains(name)) {
					this.seat.set(i, "---");
					isCancel = false;
					break;
				}
			}
			if(isCancel)
				System.out.printf("%s is doesn't exist \n", name);
		}
	}
}
/* result
 * ��ǰ�ܼ�ƮȦ ���� �ý����Դϴ�. Luxury concert hall reservation system.
 * ����:1, ��ȸ:2, ���:3, ������:4>>		reservation, inquiry, cancel, exit
 * 1. ����
 * �¼����� S(1), A(2), B(3)>> Seat classification
 * S>> --- --- ---
 * �̸�>>
 * ��ȣ>>
 * 2. ��ȸ
 * S>> �̸� --- ---
 * A>> --- �̸� ---
 * B>> --- --- �̸�
 * <<<��ȸ�� �Ϸ��Ͽ����ϴ�.>>> You have completed your inquiry
 * 3. ���
 * �¼� S:1, A:2, B:3>>
 * A>> -- -- �̸�
 * �̸�>>
 * 4. ��ȸ
 * S>> �̸� --- ---
 * A>> --- --- ---
 * B>> --- --- �̸�
 * */
