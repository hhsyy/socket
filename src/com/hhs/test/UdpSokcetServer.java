package com.hhs.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSokcetServer {
	
	public static void main(String[] args) {
		System.out.println("服务器已启动");
		try {
			DatagramSocket datagramSocket = new DatagramSocket(10000);
			byte[] bytes = new byte[1024];
			DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
			datagramSocket.receive(datagramPacket);
			String  ip = datagramPacket.getAddress().getHostAddress();
			int port = datagramPacket.getPort();
			System.out.println(datagramPacket.getData().toString());
			System.out.println(ip + port);
			datagramSocket.close();
 		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
