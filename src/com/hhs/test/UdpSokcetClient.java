package com.hhs.test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpSokcetClient {

	public static void main(String[] args) throws IOException {
		
		//������Ϣ��ת���ֽ�
		String info = "my name is hhs";
		byte[] bytes = info.getBytes();
		//����udp socket
		DatagramSocket datagramSocket = new DatagramSocket();
		//ȷ�����ӵ�ַ
		InetAddress inetAddress = InetAddress.getByName("192.168.1.7");
		//����udp���ݸ�ʽ  ���������ݳ��ȣ�ip��ַ���˿ڣ�
		DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
				inetAddress, 10000);
		//��������
		datagramSocket.send(datagramPacket);
		//�ر�����
		datagramSocket.close();

		System.out.println("�ѷ���");
		
	}

}
