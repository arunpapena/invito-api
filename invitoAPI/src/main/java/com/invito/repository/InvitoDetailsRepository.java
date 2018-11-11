package com.invito.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.invito.entity.InvitoDetails;
import com.invito.entity.UploadedAttachment;

@Repository
public interface InvitoDetailsRepository extends CrudRepository<InvitoDetails, Integer>{

}
