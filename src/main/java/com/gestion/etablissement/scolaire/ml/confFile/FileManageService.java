package com.gestion.etablissement.scolaire.ml.confFile;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

public class FileManageService {
	public static void saveFile( String fileName, MultipartFile multipartFile) {
		Path uploadPath = ConstUtil.CUSTOM_PATH;
		System.out.println("uploadPath: " + uploadPath);
		
		System.out.println("uploadPath: " + uploadPath.getFileSystem());
		try {
		if (!Files.exists(uploadPath)) {
		Files.createDirectories(uploadPath);
		System.out.println("uploadPath: " + uploadPath);
		}
		
		try (InputStream inputStream = multipartFile.getInputStream()) {
		Path filePath = uploadPath.resolve(fileName);
		System.out.println("filePath: " + filePath.toFile().getAbsolutePath());
		Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (Exception ioe) {
		System.out.println("Could not save image file: " + fileName);
		//LoggingUtils.error(ioe);
		}
		} catch (Exception e) {
		//LoggingUtils.error(e);
		}
}
private static String getExtension(String fileName) {
	return fileName.substring(fileName.lastIndexOf("."));
}
public static String generateFileName(String originalFileName, String msisdn) {
//return msisdn +"_"+ UUID.randomUUID().toString() + getExtension(originalFileName);
	return msisdn + UUID.randomUUID().toString().replace("-", "") + getExtension(originalFileName);
}
}
