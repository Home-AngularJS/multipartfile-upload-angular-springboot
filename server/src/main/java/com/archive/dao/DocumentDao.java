package com.archive.dao;

import com.archive.data.Document;
import com.archive.data.DocumentMetadata;

import java.util.Date;
import java.util.List;

public interface DocumentDao {
    void insert(Document document);
    List<DocumentMetadata> findByPersonNameDate(String personName, Date date);
    Document load(String uuid);
}
