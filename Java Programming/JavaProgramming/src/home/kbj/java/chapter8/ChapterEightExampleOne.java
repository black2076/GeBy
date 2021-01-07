package home.kbj.java.chapter8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* title: FileWriter�� �ؽ�Ʈ ���� ���� */
public class ChapterEightExampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "phone.txt";
		File file = new File(url);
		
		System.out.println("Phone number input program.");
		try( 
				FileWriter fw = new FileWriter(file);
				Scanner sc = new Scanner(System.in);
		) {
			while(true) {
				System.out.print("name Phone number >> ");
				String line = sc.nextLine();
				
				if("stop".equals(line))
					break;
				
				fw.write(line + "\r\n");
			}
			System.out.printf("Saved in %s", url);
			
		}
		catch (IOException e) {
			System.out.println("Failed to save");
			e.printStackTrace();
		}
		
		
	}

}

/* result
 * ��ȭ��ȣ �Է� ���α׷��Դϴ�.		Phone number input program
 * �̸� ��ȭ��ȣ >> Ȳ���� 010-5555-7777 
 * �̸� ��ȭ��ȣ >> �׸�
 * phone.txt�� �����Ͽ����ϴ�. 
 * */
