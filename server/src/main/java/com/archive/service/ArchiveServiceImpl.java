package com.archive.service;

import com.archive.dao.DocumentDao;
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
    private DocumentDao documentDao;

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

    public DocumentDao getDocumentDao() {
        return documentDao;
    }

    public void setDocumentDao(DocumentDao documentDao) {
        documentDao = documentDao;
    }
}
