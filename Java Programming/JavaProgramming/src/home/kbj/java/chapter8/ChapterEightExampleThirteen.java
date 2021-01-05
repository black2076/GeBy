package home.kbj.java.chapter8;

import java.io.File;
import java.util.Scanner;

/* title: File Ŭ���� ���� Ȱ�� (������ ���� Ž����) */
/* condition
 * ó�������� c:\�������� �����Ѵ�
 * ���1(..): �θ� ���͸��� �̵�
 * ���2(���͸���): ���� ���͸��� �̵�
 * */
public class ChapterEightExampleThirteen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String root = "c:\\";
		root.replace("\\", File.separator);
		FileExplorer fileExplorer = new FileExplorer(root);
		fileExplorer.execute();
		
	}

}


class FileExplorer {
	private File file;
	
	FileExplorer(String path) {
		System.out.println("***** File Explorer. *****");
		this.file = new File(path);
	}
	
	void execute() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			print();
			
			System.out.print(">>");
			String path = sc.nextLine();
			if("stop".equals(path))
				break;
			
			move(path);
		}
		sc.close();
	}
	
	void print() {
		System.out.printf("   [%s] \n", file.getPath());
		
		for(File f : file.listFiles()) {
			String type;
			if(f.isFile())
				type = "file";
			else
				type = "dir";
			
			String size = String.valueOf(f.length()) + "byte";
			System.out.printf("%-10s %-20s %-20s \n", type, size, f.getName());
		}
	}
	
	void move(String path) {
		switch (path) {
		case "..":
			if(file.getParent() == null)
				System.out.println("This is root directory");
			else
				file = new File(file.getParent());
			break;
		default:
			boolean isExists = false;
			for(String fileName : file.list()) {
				if(fileName.startsWith(path)) {
					file = new File(file.getPath() + File.separator + path);
					isExists = true;
					break;
				}
			}
			if(!isExists)
				System.out.println("Not exist");
			break;
		}
	}
	
}

/* result
 * ***** ���� Ž�����Դϴ�. *****		File Explorer.
 * [c:\]
 * dir		12288����Ʈ		Program Files 
 * dir		12288����Ʈ		Program Files (x86)
 * dir		8192����Ʈ		ProgramData
 * ...
 * 
 * >>Windows
 * [c:\Windows]
 * dir		4096����Ʈ		AppPatch
 * file		0����Ʈ			ativpsrm.bin
 * ...
 * >>..
 * [c:\]
 * ...
 * >>�׸�
 * */
