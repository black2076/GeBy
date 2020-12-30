package home.kbj.java.chapter7;

import java.util.ArrayList;
import java.util.Scanner;

/* title: ArrayList<E>�� ��ü ���� �� �˻� */
/* condition
 * �л����� Student ��ü�� ����
 * 4���� �л� ������ ArrayList<Student>�� ����
 * ��� �л� ������ ��� + �л� �̸��� �Է¹޾� �ش� �л��� ���� ����� ���
 */
public class ChapterSevenExampleFive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// save student's information
		System.out.println("Enter student's name, department, id, grade point average.");
		ArrayList<Student> student = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < 2; i++) {
			System.out.print(">> ");
			String studentInfo = sc.nextLine();
			String[] temp = studentInfo.split(", ");
			student.add(new Student(temp[0], temp[1], Integer.parseInt(temp[2]), Double.parseDouble(temp[3])));
		}
		
		// print
		for(int i = 0; i < student.size(); i++) {
			student.get(i).printAllInfo();
		}
		
		// enter name -> print grade point average
		while(true) {
			System.out.print("student's name >> ");
			String name = sc.next();
			
			// exit loop
			if("stop".equals(name))
				break;
			
			// retrieve
			for(int i = 0; i < student.size(); i++) {
				if(student.get(i).hasName(name)) {
					student.get(i).printInfo();
					break;
				}
			}
		}
		sc.close();
		
	}

}

class Student {
	private String name;
	private String department;
	private int id;
	private double gradePointAverage;
	
	public Student(String name, String department, int id, double gradePointAverage) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.department = department;
		this.id = id;
		this.gradePointAverage = gradePointAverage;
	}
	
	void printAllInfo() {
		System.out.println("-------------------");
		System.out.printf("name:%s \n", this.name);
		System.out.printf("department:%s \n", this.department);
		System.out.printf("id:%d \n", this.id);
		System.out.printf("grade point average:%.1f \n", this.gradePointAverage);
		System.out.println("-------------------");
	}

	boolean hasName(String name) {
		if(this.name.equals(name))
			return true;
		else 
			return false;
	}
	
	void printInfo() {
		System.out.printf("%s, %s, %d, %.1f \n", this.name, this.department, this.id, this.gradePointAverage);
	}
}
/* result
 * �л� �̸�, �а�, �й�, ��������� �Է��ϼ���. Enter student's name, department, id, grade point average
 * >> Ȳ����, �����, 1, 4.1
 * -------------------
 * �̸�:Ȳ����
 * �а�:�����
 * �й�:1
 * ����:4.1
 * -------------------
 * �л� �̸� >> Ȳ����	student's name
 * Ȳ����, �����, 1, 4.1
 * �л� �̸� >> �׸�
 */
