package com.xworkz.customerinsigt.util;

import java.util.Base64;

public class Decryption {
	
	public static String decrypt(String encryptedMessage) {
		byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);
		String secretKey = "secretkey1234567";
		byte[] keyBytes = secretKey.getBytes();

		byte[] decryptedBytes = new byte[encryptedBytes.length];
		for (int i = 0; i < encryptedBytes.length; i++) {
			decryptedBytes[i] = (byte) (encryptedBytes[i] ^ keyBytes[i % keyBytes.length]);
		}

		String decryptedMessage = new String(decryptedBytes);

		return decryptedMessage;
	}
}
