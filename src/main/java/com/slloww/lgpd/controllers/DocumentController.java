package com.slloww.lgpd.controllers;

import com.slloww.lgpd.services.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/file")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/upload")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(documentService.uploadFile(file), HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) throws IOException {
        byte[] data = documentService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/pdf")
                .header("Content-disposition", "attachment; filename=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/download/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName){
        return new ResponseEntity<>(documentService.deleteFile(fileName),HttpStatus.OK);

    }
}
