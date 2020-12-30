package home.kbj.java.chapter7;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

/* title: HashMap�� ��� ���� �����ϴ� ���� (���� �̸��� ����Ʈ ������ �����ϴ� ���α׷�) */
/* condition
 * ���� �̸��� ����Ʈ�� �Բ� ���� ����
 * ����Ʈ�� �߰��� ������ �����Ͽ� ����
 */
public class ChapterSevenExampleEight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("** It is a point management program **");
		
		PointManagement pointManagement = new PointManagement();
		while(true) {
			System.out.print("Enter name and point>> ");
			String line = sc.nextLine();
			
			if("stop".equals(line))
				break;
			
			String[] temp = line.split(" ");
			pointManagement.EnterInfo(temp[0], Integer.parseInt(temp[1]));
			pointManagement.printAllInfo();
		}

	}

}

class PointManagement {
	private HashMap<String, Integer> hm;
	
	PointManagement() {
		// TODO Auto-generated constructor stub
		hm = new HashMap<>();
	}
	
	void EnterInfo(String name, int point) {
		if(hm.containsKey(name)) {
			hm.put(name, hm.get(name) + point);
		}
		else {
			hm.put(name, point);
		}
	}
	
	void printAllInfo() {
		for(Entry<String, Integer> entry : hm.entrySet()) {
			System.out.printf("(%s,%d)", entry.getKey(), entry.getValue());
		}
		System.out.println();
	}
}
/* result
 * ** ����Ʈ ���� ���α׷��Դϴ� **	It is a point management program
 * �̸��� ����Ʈ �Է�>> ���繮 40	Enter name and point
 * (���繮,40)
 * �̸��� ����Ʈ �Է�>> Ȳ���� 50
 * (���繮,40)(Ȳ����,50)
 * �̸��� ����Ʈ �Է�>> �׸�
 */
