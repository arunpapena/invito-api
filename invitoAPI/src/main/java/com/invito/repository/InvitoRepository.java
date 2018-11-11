package com.invito.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invito.entity.UploadedAttachment;

@Repository
public interface InvitoRepository extends CrudRepository<UploadedAttachment, Integer>{

}
