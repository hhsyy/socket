package com.hhs.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TcpSocketClient {

	public static void main(String[] args) throws IOException {
			//创建客户端
			System.out.println("客户端已启动");
			//创建tcp客户端socket（地址，端口）
			Socket socket = new Socket("192.168.1.7", 10001);
			try {
				//while循环实现会话循环
				while (true) {
					//tcp流机制
					OutputStream outputStream = socket.getOutputStream();
					//scanner输入聊天内容
					Scanner scanner = new Scanner(System.in);
					String next = scanner.next();
					//发送数据
					outputStream.write(next.getBytes());
					
					//得到输入流机制
					InputStream inputStream = socket.getInputStream();
					//字节大小
					byte[] bytes = new byte[1024];
					//读入
					int read = inputStream.read(bytes);
					//转字符
					String str = new String(bytes,0,read);
					//输出
					System.out.println("服务器："+str);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				socket.close();
			}
			
		
		
	}
}
