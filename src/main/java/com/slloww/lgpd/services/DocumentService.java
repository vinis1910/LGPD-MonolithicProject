package com.slloww.lgpd.services;

import com.slloww.lgpd.models.Document;
import com.slloww.lgpd.repositories.DocumentRepository;
import com.slloww.lgpd.util.DocumentUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final DocumentRepository documentRepository;


    public String uploadFile(MultipartFile file) throws IOException {
        Document document = documentRepository.save(Document.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(DocumentUtils.compressImage(file.getBytes()))
                .build());
        if(document!=null) return "File uploaded successfully: " + file.getOriginalFilename();
        return null;
    }

    @Transactional
    public byte[] downloadDocument(String name){
        Optional<Document> file = documentRepository.findByName(name);
        return DocumentUtils.decompressImage(file.get().getFileData());

    }
}
