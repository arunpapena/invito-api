package com.invito.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public interface InvitoService {
	
	public void saveQrCodeAttachment(MultipartFile[] attachments) throws IOException;

	public void saveCameraPicture(String cameraBase64, String contentType, String fileName);

	public void saveInvitoDetails(String host, String eventName, String eventDate, String reminder, String eventAttachmentName);
}
