package com.hhs.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcpSocketServer {

	public static void main(String[] args) throws IOException {
		//启动服务器
		System.out.println("服务器已启动");
		//创建tcp服务端socket
		ServerSocket serverSocket = new ServerSocket(10001);
		//接受客户端socket
		Socket accept = serverSocket.accept();
		try {
			while (true) {
				//得到输入流机制
				InputStream inputStream = accept.getInputStream();

				byte[] bytes = new byte[1024];
				
				int read = inputStream.read(bytes);
				
				String str = new String(bytes,0,read);
				
				System.out.println("客户端："+str);
				
				//发送给客户端
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
