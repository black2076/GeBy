package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/* title: ä�� ���α׷� */
/* condition
 * 1:1 ä��
 * Ŭ���̾�Ʈ�� ���� ���ڿ��� ������ ������ �޾� ���
 * ������ �ٽ� ���ڿ��� ������ ��
 * "\n"�� ���ٿ� ���� ������ ����
 * Ŭ���̾�Ʈ�� "bye"�� ������ ���� Ŭ���̾�Ʈ ��� ����
 */
public class ChattingServer {
	
	public static void main(String[] args) {
		CreateServer chattingServer = new CreateServer(9999);
		chattingServer.execute();
	}
}


class CreateServer {
	private int port;
	
	CreateServer(int port) {
		this.port = port;
	}
	
	void execute() {
		try (
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			if(serverSocket != null)
				System.out.println("Waiting for connection");
			
			try (
					Socket socket = serverSocket.accept();
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					Scanner sc = new Scanner(System.in);
			) {
				if(socket != null)
					System.out.println("Connected");

				while(true) {
					String clientMessage = br.readLine();

					if("bye".equals(clientMessage)) {
						System.out.println("Client terminated the connection to bye");
						break;
					}

					System.out.printf("Client: %s \n", clientMessage);
					System.out.print("Send>>");
					bw.write(sc.nextLine() + "\n");
					bw.flush();
				}
			}
			catch (IOException e) {
				System.out.println("An error has occurred");
			}
			
		}
		catch (IOException e) {
			System.out.println("Failed to connect server socket");
			e.printStackTrace();
		}		
	}
	
}

/* result
 * ������ ��ٸ��� �ֽ��ϴ�..... Waiting for connection
 * ����Ǿ����ϴ�.				Connected
 * Ŭ���̾�Ʈ: �ȳ�?	
 * ������>>�ʵ� �ȳ�?
 * Ŭ���̾�Ʈ���� bye�� ������ �����Ͽ���	 Client terminated the connection to bye
 */



