package home.kbj.java.chapter8;

import java.io.File;

/* title: File Ŭ������ ���� ����Ʈ, ���� Ÿ��, ���� ���� ���� (.txt ���ϸ� �����ϴ� ���α׷�) */
public class ChapterEightExampleNine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		deleteFile();
	}
	
	static void deleteFile() {
		String directoryPath = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\src\\home\\kbj\\java\\chapter8";
		String fileType = ".txt";
		directoryPath.replace("\\", File.separator);
		File file = new File(directoryPath);

		File[] fileList = file.listFiles();
		
		System.out.printf("Delete all %s files in %s directory.... \n", fileType, directoryPath);
		int countD = 0;
		for(int i = 0; i < fileList.length; i++) {
			if(fileList[i].getName().contains(fileType)) {
				fileList[i].delete();
				System.out.printf("Delete %s \n", fileList[i].getName());
				countD++;
			}
		}
		System.out.printf("A total of %d %s files have been deleted.", countD, fileType);
		
	}

}

/* result
 * ~���͸��� .txt ������ ��� �����մϴ�....	Delete all .txt files in ~ directory
 * 1.txt ����		Delete 1.txt
 * 2.txt ����
 * �� 2���� .txt ������ �����Ͽ����ϴ�.	 A total of 2 .txt files have been deleted.
 */