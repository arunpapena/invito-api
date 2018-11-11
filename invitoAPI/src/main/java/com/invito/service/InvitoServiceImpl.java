package com.invito.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.invito.entity.CameraPicture;
import com.invito.entity.InvitoDetails;
import com.invito.entity.UploadedAttachment;
import com.invito.repository.CameraPictureRepository;
import com.invito.repository.InvitoDetailsRepository;
import com.invito.repository.InvitoRepository;


@Service
public class InvitoServiceImpl implements InvitoService{

	@Autowired
	private InvitoRepository invitoRepository;
	
	@Autowired
	private CameraPictureRepository cameraPictureRepository;
	
	@Autowired
	private InvitoDetailsRepository invitoDetailsRepository;

	@Override
	public void saveQrCodeAttachment(MultipartFile[] attachments) throws IOException {
		UploadedAttachment invitoModel = new UploadedAttachment();

		if(attachments.length > 0){
			for(MultipartFile attachment: attachments){
				invitoModel.setFileName(attachment.getOriginalFilename());
				invitoModel.setFileSize(attachment.getSize());
				invitoModel.setContentType(attachment.getContentType());
				invitoModel.setBase64Data(Base64.getEncoder().encodeToString(attachment.getBytes()));
				invitoModel.setByteData(attachment.getBytes());
				invitoRepository.save(invitoModel);
			}
		}
	}

	@Override
	public void saveCameraPicture(String cameraBase64, String contentType, String fileName) {
		CameraPicture cameraPicture = new CameraPicture();
		cameraPicture.setBase64Data(cameraBase64);
		cameraPicture.setFileName(fileName);
		cameraPicture.setContentType(contentType);
		cameraPictureRepository.save(cameraPicture);
	}

	@Override
	public void saveInvitoDetails(String host, String eventName, String eventDate, String reminder,
			String eventAttachmentName) {
		InvitoDetails invitoDetails = new InvitoDetails();
		invitoDetails.setHost(host);
		invitoDetails.setEventName(eventName);
		invitoDetails.setEventDate(eventDate);
		invitoDetails.setReminder(reminder);
		invitoDetails.setEventAttachmentName(eventAttachmentName);
		
		invitoDetailsRepository.save(invitoDetails);
	}


}
