package com.global.hr.booksproject.service;

import com.global.hr.booksproject.entity.Auther;
import com.global.hr.booksproject.error.FileStorageException;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileUploadService {
    @Autowired
    private AutherService autherService;

    private Path fileStorageLocation;

    @Value("${file.upload.base-path}")
    private String basePath;

    public String storeFile(File file, Long id, String pathType) {


        // create uploaded path
        this.fileStorageLocation = Paths.get(basePath + pathType).toAbsolutePath().normalize();

        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception ex) {
            throw new FileStorageException("Could not create the directory where the uploaded files will be stored.",
                    ex);
        }

        String fileName = StringUtils.cleanPath(id + "-" + file.getName());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            // Copy file to the target location (Replacing existing file with the same name)
            Path targetLocation = this.fileStorageLocation.resolve(fileName);
            InputStream targetStream = new FileInputStream(file);
            Files.copy(targetStream, targetLocation, StandardCopyOption.REPLACE_EXISTING);

            uploadImage(id, basePath + pathType + "/" + fileName);

            return fileName;
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public void uploadImage(Long id, String imagePath){
        System.out.println(imagePath);
        if(imagePath.contains("authers")){
            Auther auther = autherService.findById(id);
            if(auther != null){
                auther.setImagePath(imagePath);
                autherService.update(auther);
            }
        }
    }

    public File convertMultiPartFileToFile(final MultipartFile multipartFile) {
        Logger log = org.slf4j.LoggerFactory.getLogger(FileUploadService.class);
        final File file = new File(multipartFile.getOriginalFilename());
        try (final FileOutputStream outputStream = new FileOutputStream(file)) {
            outputStream.write(multipartFile.getBytes());
        } catch (final IOException ex) {
            log.error("Error converting the multi-part file to file= ", ex.getMessage());
        }
        return file;
    }
}
