package com.hhs.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSokcetClient {

	public static void main(String[] args) throws IOException {
		
		//发送信息并转成字节
		String info = "my name is hhs";
		byte[] bytes = info.getBytes();
		//创建udp socket
		DatagramSocket datagramSocket = new DatagramSocket();
		//确定连接地址
		InetAddress inetAddress = InetAddress.getByName("192.168.1.7");
		//创建udp数据格式  （数据数据长度，ip地址，端口）
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
				inetAddress, 10000);
		//发送数据
		datagramSocket.send(datagramPacket);
		//关闭连接
		datagramSocket.close();

		System.out.println("已发送");
		
	}

}
