package home.kbj.java.chapter8;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* title: ���̳ʸ� ���� ���� */
/* condition
 * ��� ����
 */

public class ChapterEightExampleSeven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sourceURL = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\src\\home\\kbj\\java\\chapter8\\Ryan.jpg";
		String destinationURL = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\src\\home\\kbj\\java\\chapter8\\Ryan_copy.jpg";
		sourceURL.replace("\\", File.separator);
		destinationURL.replace("\\", File.separator);
		
		File srcFile = new File(sourceURL);
		File destFile = new File(destinationURL);
		
		System.out.printf("Copy %s to %s \n", sourceURL, destinationURL);
		CopyFile cf = new CopyFile();
		cf.copyFile(srcFile, destFile);
	}

}

class CopyFile {
	
	void copyFile(File srcFile, File destFile) {
		try (
				FileInputStream fis = new FileInputStream(srcFile);
				FileOutputStream fos = new FileOutputStream(destFile);
				BufferedInputStream bis = new BufferedInputStream(fis);
				BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			int c;
			System.out.println("Print * every 10%");
			while(true) {
				c = bis.read();
				bos.write(c);
				
				if(c == -1) {
					bos.flush();
					break;
				}

				if(bis.available() % (int)srcFile.length() / 10 == 0)
					System.out.print("*");
			}
		}
		catch (IOException e) {
			System.out.println("Failed to copy");
			e.printStackTrace();
		}
		
	}
}

/* result
 * A�� B�� �����մϴ�.	Copy A to B
 * 10%���� *�� ����մϴ�		Print * every 10%
 * */

