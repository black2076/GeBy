package home.kbj.java.chapter15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/* title: ���� ���, �����带 �̿��Ͽ� ����� ��� �ۼ� */
/* condition
 * ������ ������� �����Ӱ� ������ Ŭ���̾�Ʈ�� �޽����� �ְ���� �� �ֵ��� �����带 �̿�
 * <Enter>Ű�� �Է��ϸ� ��뿡�� �ٷ� ����
 * ��� ������ ������ ������ ���α׷� ���� 
 */
public class RealChatServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChatServer cs = new ChatServer(9999);
		cs.execute();
	}

}

class ChatServer {
	private int port;
	
	ChatServer(int port) {
		this.port = port;
	}
	
	void execute() {
		try (
				ServerSocket serverSocket = new ServerSocket(port);
		) {
			try(
					Socket socket = serverSocket.accept();
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
					Scanner sc = new Scanner(System.in);
			) {
				if(socket != null)
					System.out.println("Connection completed from Client");
				
				// receive
				Thread t = new Thread(new ReceiveServerThread(socket));
				t.start();
				
				// send
				String sendMessage = null;
				while(true) {
					if("bye".equals(sendMessage))
						break;
					System.out.print("Send>>");
					sendMessage = sc.nextLine();
					bw.write(sendMessage + "\n");
					bw.flush();
					System.out.printf("Server : %s\n", sendMessage);
				}
				
			}
			catch(Exception e) {
				System.exit(1);
			}
		}
		catch(IOException e) {
			System.out.println("Bind Exception");
			e.printStackTrace();
		}
	}

}

class ReceiveServerThread implements Runnable {
	private Socket socket;
	
	ReceiveServerThread(Socket socket) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
			try (
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			) {
				String line;
				while((line = br.readLine()) != null) {
					if("bye".equals(line)) {
						break;
					}
					System.out.printf("\nClient : %s\n", line);
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
	}

}


/* result
 * Ŭ���̾�Ʈ�κ��� ���� �Ϸ�		Connection completed from Client
 * ���� : �ȳ�
 * Ŭ���̾�Ʈ : �ڹ� ���δ� �� �Ǵ�?
 * ���� : �׷� �󸶳� ��մµ�.....
 * Ŭ���̾�Ʈ : ��¥?
 */