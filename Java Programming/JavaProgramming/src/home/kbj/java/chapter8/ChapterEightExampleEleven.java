package home.kbj.java.chapter8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/* title: Vector �÷���, ���� ����� ���� ���� */
/* condition
 * ����: ������ �� ���ξ� �о� Vector �÷��ǿ� ���κ��� ����
 * ���� �ܾ �Է¹޾� �� �ܾ�� �����ϴ� ��� �ܾ ���Ϳ��� ã�� ���
 */

public class ChapterEightExampleEleven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchWord sw = new SearchWord("./", "words.txt");
		
		sw.searchWord();
	}

}


class SearchWord {
	private String directoryPath;
	private String filePath;
	private String fileName;
	private File file;
	private Vector<String> v;
	
	public SearchWord(String directoryPath, String fileName) {
		// TODO Auto-generated constructor stub
		this.directoryPath = directoryPath.replace("\\", File.separator);
		this.fileName = fileName;
		this.filePath = directoryPath + File.separator + fileName;
		
		file = new File(filePath);
		v = new Vector<>((int)file.length());
	}
	
	void readFile() {
		try (
				BufferedReader br = new BufferedReader(new FileReader(file));
		) {
			System.out.printf("Read the %s file under %s folder \n", fileName, directoryPath);
			while(true) {
				String line = br.readLine();
				if(line == null)
					break;
				v.add(line);
			}
			
		}
		catch(IOException e) {
			System.out.println("Failed to read");
			e.printStackTrace();
		}
	}
	
	void searchWord() {
		// read file
		readFile();
		
		// search word
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("word>>");
			String word = sc.next();
			
			if("stop".equals(word)) {
				System.out.println("It ends..");
				break;
			}
				
			
			int wordCount = 0;
			for(int i = 0; i < v.size(); i++) {
				if(v.get(i).startsWith(word)) {
					System.out.println(v.get(i));
					wordCount++;
				}
			}
			
			if(wordCount == 0)
				System.out.println("Not found");
		}
		sc.close();
	}
}

/* result
 * ������Ʈ ���� ���� words.txt ������ �о����ϴ�...	Read the words.txt file under directory path folder
 * �ܾ�>>lov
 * love
 * lovebird
 * lovelorn
 * �ܾ�>>asdfjasdf
 * �߰��� �� ����	Not found
 * �ܾ�>>�׸�
 * �����մϴ�..	It ends..
 */
