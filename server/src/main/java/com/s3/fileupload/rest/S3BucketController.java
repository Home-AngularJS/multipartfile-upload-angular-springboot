package com.s3.fileupload.rest;

import com.s3.fileupload.service.Document;
import com.s3.fileupload.service.IArchiveService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.UUID;

@Controller
public class S3BucketController {

    private static final Logger LOG = Logger.getLogger(S3BucketController.class);

    @Autowired
    IArchiveService archiveService;

    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public ResponseEntity<?> uploadFile(@RequestParam(value="file") MultipartFile file) {
        try {
            Document document = new Document(file.getBytes(), file.getOriginalFilename(), new Date(), UUID.randomUUID().toString());
            archiveService.save(document);
            return new ResponseEntity<>(document.getMetadata(), HttpStatus.OK);
        } catch (RuntimeException re) {
            LOG.error("Error while uploading.", re);
            throw re;
        } catch (Exception e) {
            LOG.error("Error while uploading.", e);
            throw new RuntimeException(e);
        }
    }
}
