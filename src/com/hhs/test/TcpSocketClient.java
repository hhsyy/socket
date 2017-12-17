package com.hhs.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpSocketClient {

	public static void main(String[] args) throws IOException {
			//�����ͻ���
			System.out.println("�ͻ���������");
			//����tcp�ͻ���socket����ַ���˿ڣ�
			Socket socket = new Socket("192.168.1.7", 10001);
			try {
				//whileѭ��ʵ�ֻỰѭ��
				while (true) {
					//tcp������
					OutputStream outputStream = socket.getOutputStream();
					//scanner������������
					Scanner scanner = new Scanner(System.in);
					String next = scanner.next();
					//��������
					outputStream.write(next.getBytes());
					
					//�õ�����������
					InputStream inputStream = socket.getInputStream();
					//�ֽڴ�С
					byte[] bytes = new byte[1024];
					//����
					int read = inputStream.read(bytes);
					//ת�ַ�
					String str = new String(bytes,0,read);
					//���
					System.out.println("��������"+str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				socket.close();
			}
			
		
		
	}
}
