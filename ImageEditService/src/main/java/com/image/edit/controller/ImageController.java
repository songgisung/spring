package com.image.edit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.image.edit.models.resize.ResizeRequest;
import com.image.edit.models.resize.ResizeResponse;

@RestController
public class ImageController {

	@RequestMapping(method = RequestMethod.POST, value = "/resize")
	public ResponseEntity<ResizeResponse> imageReSize(@RequestBody ResizeRequest resizeReq){

		System.out.println(resizeReq.getImageName());
		ResizeResponse resizeRes = new ResizeResponse();
		return new ResponseEntity<ResizeResponse> (resizeRes, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/test")
	public String test(){

		return "hello test api";
	}

}
