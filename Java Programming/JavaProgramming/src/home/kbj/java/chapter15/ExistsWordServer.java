package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/* title: ���� Ŭ���̾�Ʈ�� �����ϴ� ���� ��� ���� */
/* condition
 * �ϳ��� ������ ���� Ŭ���̾�Ʈ�� ���ÿ� �����Ͽ� ����ϴ� ���α׷��� �ۼ�
 * words.txt���� �б�
 * Ŭ���̾�Ʈ�� ����ڷκ��� ���� �ܾ �Է¹޾� ������ ������.
 * ������ Ŭ���̾�Ʈ�κ��� ���� �ܾ words.txt�� �ִ��� �˻��ϰ� ������ "YES", ���¸� 'NO"�� �����Ѵ�.
 * Ŭ���̾�Ʈ�� �����κ��� ���� ����� ��� 
 */
public class ExistsWordServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server(9998);
		server.execute();
	}

}

class Server {
	private int port;
	private Vector<String> words;
	private File file;
	
	
	Server(int port) {
		this.port = port;
		String url = "C:\\Users\\black\\Desktop\\BJK\\Git\\LocalStorage\\Java Programming\\JavaProgramming\\words.txt".replace("\\", File.separator);
		file = new File(url); // convert absolute path for execute cmd 
		words = new Vector<>((int)file.length());
	}
	
	void readFile() {
		try (
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
		) {
			String line;
			while(true) {
				line = br.readLine();
				if(line == null)
					break;
				words.add(line);
			}
		}
		catch (IOException e) {
			System.out.printf("Failed to read %s \n", file.getName());
		}
	}
	
	void execute() {
		readFile();
		System.out.printf("Finished reading %s \n", file.getName());
		
		try(
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			Socket socket = null;
			try {
				while(true) {
					socket = serverSocket.accept();
					if(socket != null)
						System.out.println("Client connected");
					ServerTask st = new ServerTask(socket, words);
					st.start();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if(socket != null)
						socket.close();
				}
				catch (IOException e) {
				}
			}
		}
		catch (IOException e) {
			System.out.println("Failed to bind");
			e.printStackTrace();
		}
	}
	
	
}


class ServerTask extends Thread {
	private Socket socket;
	private Vector<String> words;
	
	ServerTask(Socket socket, Vector<String> words) {
		this.socket = socket;
		this.words = words;
	}
	
	@Override
	public void run() {
			try(
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			) {
				while(true) {
					send(bw, receive(br));
				}
			}
			catch (IOException e) {
				System.out.println("Client connection termination");
			}
	}
	
	boolean receive(BufferedReader br) throws IOException {
		String word = br.readLine();
		if(word == null)
			throw new IOException();
		
		if(words.contains(word)) {
			System.out.printf("%s=YES \n",word);
			return true;
		}
		else {
			System.out.printf("%s=NO \n",word);
			return false;
		}
			
	}
	
	void send(BufferedWriter bw, boolean hasWord) throws IOException {
		if(hasWord)
			bw.write("YES \n");
		else
			bw.write("NO \n");
		bw.flush();
	}
}

/* result
 * words.txt �б� �Ϸ� 		finished reading words.txt
 * Ŭ���̾�Ʈ �����		Client connected
 * kite=YES
 * Ŭ���̾�Ʈ �����
 * friend=YES
 * pather=NO
 */
