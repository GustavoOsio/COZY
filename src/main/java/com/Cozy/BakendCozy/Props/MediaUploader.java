package com.Cozy.BakendCozy.Props;

import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import com.Cozy.BakendCozy.Entity.Archive;
import com.Cozy.BakendCozy.Repository.IarchiveRepository;

import java.io.File;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.Base64;
import java.util.Properties;

import java.nio.file.Files;

import java.nio.file.StandardOpenOption;
import java.util.Base64;

@Service
public class MediaUploader {
	
	//ruta de archivo donde quedaran los archivos
	static 
	Properties prop = new Properties();
	
	@Autowired
	IarchiveRepository archiveRepository;
	
	Archive archive = new Archive();
	
	private  String FILE_PATH_BY_ARCHIVE = prop.getProperty("WINDOWS_FILE_PATH"); // RUTA EN WINDOWS
	
	 // RUTA VPS solo se activa en el entorno vps
//	private  String FILE_PATH_BY_ARCHIVE =  prop.getProperty("VPS_FILE_PATH");
	
	private  String FILE_PATH_BY_ARCHIVE_DEBUG = "D://PROYECTOS SPRING//BakendArreglo//archivo";
	
	//Guardar imagen en carpeta
	public void saveBase64Image(String base64Image, String fileName, Integer idsession) throws IOException {
	    byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
	    String path_rute_photoString=FILE_PATH_BY_ARCHIVE_DEBUG+"//photo";
	    	    
	    // ruta final de la imagen
	    File targetFolder = new File(path_rute_photoString);
	    if (!targetFolder.exists()) {
	        targetFolder.mkdirs(); // Crea la carpeta si no existe
	    }

	    File targetFile = new File(targetFolder, fileName);
	    FileUtils.writeByteArrayToFile(targetFile, decodedBytes);
		    
	}
	
	//Guardar Video en carpeta
		public void saveBase64ByVideo(String base64Image, String fileName) throws IOException {
		    byte[] decodedBytes = Base64.getDecoder().decode(base64Image);
		    String path_rute_photoString=FILE_PATH_BY_ARCHIVE_DEBUG+"//video";
		    	    
		    // ruta final de la imagen
		    File targetFolder = new File(path_rute_photoString);
		    if (!targetFolder.exists()) {
		        targetFolder.mkdirs(); // Crea la carpeta si no existe
		    }

		    File targetFile = new File(targetFolder, fileName);
		    FileUtils.writeByteArrayToFile(targetFile, decodedBytes);
			    
		}
	
		public boolean isVideoByBase64(String base64Data) {
		    if (base64Data != null && !base64Data.isEmpty()) {
		        // Obtener el encabezado del base64
		        String[] part = base64Data.split(",");
		        if (part.length > 0) {
		            String head = part[0];
		            
		            // Verificar si el encabezado indica un tipo de video
		            if (head.contains("video/")) {
		                return true;
		            }
		        }
		    }
		    
		    return false;
		}


	    public static String convertToBase64(String filePath) throws IOException {
	        File file = new File(filePath);
	        byte[] fileContent = FileUtils.readFileToByteArray(file);
	        String base64String = Base64Utils.encodeToString(fileContent);
	        return base64String;
	    }
	
	

}
