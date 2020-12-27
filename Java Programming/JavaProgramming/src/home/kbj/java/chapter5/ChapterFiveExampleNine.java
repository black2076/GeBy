package home.kbj.java.chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* title: Stack �������̽��� ��ӹ޾� �Ǽ��� �����ϴ� StringStack Ŭ���� ���� */
public class ChapterFiveExampleNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("enter size of total stack storage space >> ");
		int capacity = sc.nextInt();
		
		StringStack stringStack = new StringStack(capacity);
		
		while(true) {
			System.out.print("enter String >> ");
			String str = sc.next();
			
			boolean isEmpty = stringStack.push(str);
			if(!isEmpty)
				System.out.println("Stack is full and cannot be pushed");
			
			if("stop".equals(str))
				break;
		}
		
		System.out.println(stringStack.pop());
		sc.close();

	}

}

interface Stack {
	int length(); // ���� ���ÿ� ����� ���� ����
	int capacity(); // ������ ��ü ���� ������ ���� ����
	String pop(); // ������ top�� ����� �Ǽ� ����
	boolean push(String val); // ������ top�� �Ǽ� ����
}

class StringStack implements Stack {
	List<String> storage;
	private int capacity;
	private int top;
	
	StringStack(int capacity) {
		storage = new ArrayList<String>();
		this.capacity = capacity;
		top = -1;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return storage.size();
	}

	@Override
	public int capacity() {
		// TODO Auto-generated method stub
		return capacity;
	}

	@Override
	public String pop() {
		// TODO Auto-generated method stub
		String returnStr = "";
		for(String popStr : storage) {
			returnStr += popStr + " ";
		}
		top = -1;
		return returnStr;
	}

	@Override
	public boolean push(String val) {
		// TODO Auto-generated method stub
		if(++top >= capacity) {
			top = capacity; // ���â���� �ұ��ϰ� ��� push�� ��� error ����
			return false; 
		}
		else {
			storage.add(val);
			return true;
		}
	}
	
}

/* result 
 * �� ���� ���� ������ ũ�� �Է� >> 3 enter size of total stack storage space
 * ���ڿ� �Է� >> hello		enter String
 * ���ڿ� �Է� >> sunny
 * ���ڿ� �Է� >> smile
 * ���ڿ� �Է� >> happy
 * ������ �� ���� Ǫ�� �Ұ�!	Stack is full and cannot be pushed
 * ���ڿ� �Է� >> �׸� ("�׸�"�� �Է��ϸ� ���α׷� ����) stop 
 * ���ÿ� ����� ��� ���ڿ� �� : smile sunny hello	Pop all strings stored on the stack
 */

