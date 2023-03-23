package com.example.studentregistration.utils;


import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Component
public class FileStorageUtils {

   private String courseStoragePath;
   private String userHome= System.getProperty("user.home");

    public String storeFile(MultipartFile multipartFile)throws IOException{
        String directoryPath=userHome +courseStoragePath;
        File directoryFile=new File(directoryPath);
        if(!directoryFile.exists()) {
            directoryFile.mkdirs();
        }else{
            System.out.println("*****Directory Already exists******");
        }
        String fileStorageLocation = directoryPath + File.separator+ UUID.randomUUID() + "-" + multipartFile.getOriginalFilename();
        File fileToSave = new File(fileStorageLocation);
        multipartFile.transferTo(fileToSave);
        return fileStorageLocation;
    }
}
