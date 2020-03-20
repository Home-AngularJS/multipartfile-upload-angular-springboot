package com.archive.service;

import com.archive.data.Document;
import com.archive.data.DocumentMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Service("archiveService")
public class ArchiveServiceImpl implements ArchiveService, Serializable {

    private static final long serialVersionUID = 8119784722798361327L;

    @Autowired
    private com.archive.dao.DocumentDao DocumentDao;

    @Override
    public DocumentMetadata save(Document document) {
        getDocumentDao().insert(document); 
        return document.getMetadata();
    }

    @Override
    public List<DocumentMetadata> findDocuments(String personName, Date date) {
        return getDocumentDao().findByPersonNameDate(personName, date);
    }

    @Override
    public byte[] getDocumentFile(String id) {
        Document document = getDocumentDao().load(id);
        if(document!=null) {
            return document.getFileData();
        } else {
            return null;
        }
    }

    public com.archive.dao.DocumentDao getDocumentDao() {
        return DocumentDao;
    }

    public void setDocumentDao(com.archive.dao.DocumentDao documentDao) {
        DocumentDao = documentDao;
    }
}
