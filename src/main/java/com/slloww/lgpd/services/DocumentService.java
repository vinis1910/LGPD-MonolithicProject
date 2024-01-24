package com.slloww.lgpd.services;

import com.slloww.lgpd.models.Client;
import com.slloww.lgpd.models.Document;
import com.slloww.lgpd.repositories.ClientRepository;
import com.slloww.lgpd.repositories.DocumentRepository;
import com.slloww.lgpd.util.DocumentUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private ClientRepository clientRepository;


    public String uploadFile(MultipartFile file) throws IOException {;
        //Optional<Client> client = clientRepository.findById(clientId);
        Document document = documentRepository.save(Document.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .fileData(DocumentUtils.compressImage(file.getBytes()))
                //.client(client.get())
                .build());
        //nao esta relacionando o documneto com o cliente quando faz upload(tirei , Long clientId do parametro)
        //client.get().getDocument().add(document);
        //clientRepository.save(client.get());
        if (document != null) {
            return "File uploaded successfully: " + file.getOriginalFilename();
        }
        return "Error uploading file. Client not found or document could not be saved.";
    }

    @Transactional
    public byte[] downloadDocument(String name){
        Optional<Document> file = documentRepository.findByName(name);
        return DocumentUtils.decompressImage(file.get().getFileData());

    }
}
