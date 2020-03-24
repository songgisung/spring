package com.image.edit.services;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import org.springframework.stereotype.Service;

@Service
public class TransImageData {

	public byte[] getStringToByte (String imageBinaryString) throws Exception {

		String target = imageBinaryString;
        byte[] targetBytes = target.getBytes("UTF-8");

        // base64 decoding
        Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(targetBytes);

		return decodedBytes;
	}

	public String getByteToString (byte[] imageByte) throws Exception {

		Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(imageByte);

		return encodedString;
	}

	public String getDecodeString (String base64String) throws Exception {
        // base64 decoding
		Decoder decoder = Base64.getDecoder();
        byte[] decodeByte = decoder.decode(base64String);

        return "test";
        //return decodeByte.toString();
	}

	public void test(String imageString) throws Exception {
		String target = imageString;
        byte[] targetBytes = target.getBytes("UTF-8");

        // Base64 encoding
        Encoder encoder = Base64.getEncoder();

        // Encoder#encode(byte[] src) :: byte
        byte[] encodedBytes = encoder.encode(targetBytes);
        System.out.println(new String(encodedBytes));

        // Encoder#encodeToString(byte[] src) :: string
        String encodedString = encoder.encodeToString(targetBytes);
        System.out.println(encodedString);

        // Base64 decoding
        Decoder decoder = Base64.getDecoder();

        // Decoder#decode(bytes[] src)
        byte[] decodedBytes1 = decoder.decode(encodedBytes);
        // Decoder#decode(String src)
        byte[] decodedBytes2 = decoder.decode(encodedString);

        // decoding 文字列　
        String decodedString = new String(decodedBytes1, "UTF-8");
        System.out.println(decodedString);

        System.out.println(new String(decodedBytes2, "UTF-8"));

	}
}
