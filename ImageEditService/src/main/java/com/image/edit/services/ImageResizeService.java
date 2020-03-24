package com.image.edit.services;
import java.io.File;
import java.io.FileOutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.image.edit.models.resize.ResizeRequest;

@Service
public class ImageResizeService {

	@Autowired
	private TransImageData transImageData;

//	public ObjectMapper resize(ResizeRequest req) throws Exception {
//
//		//byte[] imageData = transImageData.getStringToByte(req.getImageBinary());
//		String temp = transImageData.getDecodeString(req.getImageBinary());
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		byteArrayConvertToImageFile(temp);
//
////		objectMapper.writeValue(new File("target/car.json"), car);
////		return objectMapper.writeValue(new File("target/car.json"), car);
//
//		return objectMapper;
//	}

	public void testFIle(ResizeRequest req) throws Exception {
		byteArrayConvertToImageFile(transImageData.getDecodeString(req.getImageBinary()));
	}

	private void byteArrayConvertToImageFile(String imagedata) throws Exception {
		//テストイメージ保存
		File test =  new File("/Users/sgs/Desktop/testimage.png");
		test.createNewFile();

		//イメージの中にデータ入力
		FileOutputStream image = new FileOutputStream(imagedata);
		image.write(imagedata.getBytes());
		image.close();
	}

}
