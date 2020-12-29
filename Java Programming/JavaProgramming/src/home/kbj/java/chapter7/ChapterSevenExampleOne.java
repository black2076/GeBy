package home.kbj.java.chapter7;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

/* title: Vector<Integer> ���� */
/* condition: -1�� �Էµ� ������ ���� ������ �Է¹޾� ���Ϳ� �����ϰ� ���͸� �˻��Ͽ� ���� ū ���� ��� */
public class ChapterSevenExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumNumber maximumNumber = new MaximumNumber();
		System.out.printf("The largest number is %d", maximumNumber.enterInteger());
		
	}

}

class MaximumNumber {
	
	public MaximumNumber() {
		// TODO Auto-generated constructor stub
	}
	
	int enterInteger() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Integer(until -1 is entered)>> ");
		String line = sc.nextLine();
		String[] lines = line.split(" ");
		// String -> Integer
		int[] linesConversion = Arrays.asList(lines).stream().mapToInt(Integer::parseInt).toArray();
		
		Vector<Integer> v = new Vector<>();
		for(int i = 0; i < linesConversion.length; i++) {
			if(linesConversion[i] == -1)
				break;
			else
				v.add(linesConversion[i]); // auto boxing
		}
			
		
		// retrieve
		int maximumNumber = 0;
		if(!v.isEmpty()) {
			for(int i = 0; i < v.size(); i++) {
				if(v.get(i) > maximumNumber)
					maximumNumber = v.get(i);
			}
		}
		
		sc.close();
		return maximumNumber;
	}
	
}

/* result 
 * ����(-1�� �Էµ� ������)>> 10 6 22 6 88 77 -1 Integer(until -1 is entered)
 * ���� ū ���� 88 The largest number is
 */