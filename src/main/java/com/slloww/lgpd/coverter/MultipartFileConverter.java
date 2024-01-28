package com.slloww.lgpd.coverter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Slf4j
@Component
public class MultipartFileConverter {

    public File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }catch (IOException e){
            log.error("Error converting multipartFile to File", e);
        }
        return convertedFile;
    }
}
