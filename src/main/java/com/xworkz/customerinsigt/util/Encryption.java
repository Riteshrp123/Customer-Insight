package com.xworkz.customerinsigt.util;

import java.util.Base64;

public class Encryption {
	
	public static String encrypt(String value) {
		byte[] messageBytes = value.getBytes();
		 String secretKey = "secretkey1234567";
		byte[] keyBytes = secretKey.getBytes();

		byte[] encryptedBytes = new byte[messageBytes.length];
		for (int i = 0; i < messageBytes.length; i++) {
			encryptedBytes[i] = (byte) (messageBytes[i] ^ keyBytes[i % keyBytes.length]);
		}

		String encryptedMessage = Base64.getEncoder().encodeToString(encryptedBytes);

		return encryptedMessage;
	}

}
