package com.invito.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.invito.service.InvitoService;

import java.io.IOException;


import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(path="/invito")
public class InvitoController {
    	
	private static final String SUCCESS_STATUS = "200";
	private static final String SUCCESS_DESC = "Success";
	private static final String FAILURE_DESC = "Failure";
	private static final String STATUS_KEY = "status";
	private static final String DESCRIPTION_KEY = "description";
	private static final String FAILURE_STATUS = "400";

	@Autowired
	private InvitoService invitoService;
	
	@CrossOrigin
    @RequestMapping(value="/filesSelected", method=RequestMethod.POST)
    public ResponseEntity<String> saveQrCodeAttachment(@RequestParam(name = "attachment") MultipartFile[] qrCodeFiles) {
        JSONObject response = new JSONObject();
        HttpStatus httpStatus;
		try {
			invitoService.saveQrCodeAttachment(qrCodeFiles);
			response.put(STATUS_KEY, SUCCESS_STATUS);
			response.put(DESCRIPTION_KEY, SUCCESS_DESC);
			httpStatus = HttpStatus.OK;
		} catch (IOException e) {
			response.put(STATUS_KEY, FAILURE_STATUS);
			response.put(DESCRIPTION_KEY, FAILURE_DESC);
			httpStatus = HttpStatus.BAD_REQUEST;

		}
		return new ResponseEntity<>(response.toString(),httpStatus);
    }
    
	@CrossOrigin
    @RequestMapping(value="/cameraCapturedImage", method=RequestMethod.POST)
	public ResponseEntity<String> saveCameraImage(@RequestParam(name = "cameraPicBase64") String cameraPicBase64,
			@RequestParam(name = "contentType") String contentType,
			@RequestParam(name = "fileName") String fileName){
        JSONObject response = new JSONObject();
        HttpStatus httpStatus;
		try {
			invitoService.saveCameraPicture(cameraPicBase64, contentType, fileName);
			response.put(STATUS_KEY, SUCCESS_STATUS);
			response.put(DESCRIPTION_KEY, SUCCESS_DESC);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response.put(STATUS_KEY, FAILURE_STATUS);
			response.put(DESCRIPTION_KEY, FAILURE_DESC);
			httpStatus = HttpStatus.BAD_REQUEST;

		}
		return new ResponseEntity<>(response.toString(),httpStatus);
	}
	
	@CrossOrigin
    @RequestMapping(value="/saveInvito", method=RequestMethod.POST)
	public ResponseEntity<String> saveInvitoDetails(@RequestParam(name = "host", required = true) String host,
			@RequestParam(name = "eventName", required = true) String eventName,
			@RequestParam(name = "eventDate", required = true) String eventDate,
			@RequestParam(name = "reminder", required = true) String reminder,
			@RequestParam(name = "eventAttachmentName", required = false) String eventAttachmentName){
        JSONObject response = new JSONObject();
        HttpStatus httpStatus;
		try {
			invitoService.saveInvitoDetails(host, eventName, eventDate, reminder, eventAttachmentName);
			response.put(STATUS_KEY, SUCCESS_STATUS);
			response.put(DESCRIPTION_KEY, SUCCESS_DESC);
			httpStatus = HttpStatus.OK;
		} catch (Exception e) {
			response.put(STATUS_KEY, FAILURE_STATUS);
			response.put(DESCRIPTION_KEY, FAILURE_DESC);
			httpStatus = HttpStatus.BAD_REQUEST;

		}
		return new ResponseEntity<>(response.toString(),httpStatus);
	}
}
