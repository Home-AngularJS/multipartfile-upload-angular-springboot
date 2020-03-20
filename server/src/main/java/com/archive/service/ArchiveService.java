package com.archive.service;

import com.archive.data.Document;
import com.archive.data.DocumentMetadata;

import java.util.Date;
import java.util.List;

public interface ArchiveService {
    DocumentMetadata save(Document document);
    List<DocumentMetadata> findDocuments(String personName, Date date);
    byte[] getDocumentFile(String id);
}
