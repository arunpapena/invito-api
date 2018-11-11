package com.invito.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invito.entity.CameraPicture;
import com.invito.entity.UploadedAttachment;

@Repository
public interface CameraPictureRepository extends CrudRepository<CameraPicture, Integer>{

}
