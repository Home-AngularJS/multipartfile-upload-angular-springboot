package com.s3.fileupload.dao;

import com.s3.fileupload.service.Document;
import com.s3.fileupload.service.DocumentMetadata;

import java.util.Date;
import java.util.List;

public interface IDocumentDao {
    void insert(Document document);
    List<DocumentMetadata> findByPersonNameDate(String personName, Date date);
    Document load(String uuid);
}
