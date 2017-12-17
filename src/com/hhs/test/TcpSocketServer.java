package com.hhs.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpSocketServer {

	public static void main(String[] args) throws IOException {
		//����������
		System.out.println("������������");
		//����tcp�����socket
		ServerSocket serverSocket = new ServerSocket(10001);
		//���ܿͻ���socket
		Socket accept = serverSocket.accept();
		try {
			while (true) {
				//�õ�����������
				InputStream inputStream = accept.getInputStream();

				byte[] bytes = new byte[1024];
				
				int read = inputStream.read(bytes);
				
				String str = new String(bytes,0,read);
				
				System.out.println("�ͻ��ˣ�"+str);
				
				//���͸��ͻ���
				OutputStream outputStream = accept.getOutputStream();
				
				Scanner scanner = new Scanner(System.in);
				
				String next = scanner.next();
				
				outputStream.write(next.getBytes());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			accept.close();

			serverSocket.close();
		}

	}

}
