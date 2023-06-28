package com.Cozy.BakendCozy.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Cozy.BakendCozy.Entity.Archive;
import com.Cozy.BakendCozy.Props.GenerateCode;
import com.Cozy.BakendCozy.Props.MediaUploader;
import com.Cozy.BakendCozy.Repository.IarchiveRepository;
import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/api/archives")
@CrossOrigin
public class ArchiveService {

	@Autowired
	IarchiveRepository Irepository;
	
	//aqui se suben los archivos a la carpeta de imagen
	@PostMapping( "/uploadFile")
	public JSONObject loadImgbyArchive(@RequestBody Archive archive) throws java.io.IOException {
		//se crea la instancia para llamar la funcion de subir los archivos
		MediaUploader mediaUploader =new MediaUploader();
		JSONObject jsonResponse = new JSONObject();
		
		GenerateCode code =new GenerateCode();
		String codeByPiture=code.main(null);
		
		//setter api 
		String base64Image = archive.getPath();
		String nameByPhotoCategory=archive.getName();
		Integer sessionIdInteger=archive.getSessionid();
		String typeByArchiveString= archive.getType(); //true or false
		
		String fileName="";
		String extensionByArchiveString="";
		
	
		if(base64Image.length()<0 ||  nameByPhotoCategory.length()<0 || sessionIdInteger<0 ) {
			jsonResponse.put("status", "error");
			jsonResponse.put("message"," Se han enviado datos incompletos. Asegúrate de completar todos los campos requeridos antes de enviar el JSON." );
		   return jsonResponse ;
		}
				
		long dateString=System.currentTimeMillis();
		
				 
		
		try {
			if(  typeByArchiveString.equals("video")) {
				fileName = codeByPiture.concat("_VIDEO_COZY.mp4");
				mediaUploader.saveBase64ByVideo(base64Image, nameByPhotoCategory+dateString+ fileName);
				extensionByArchiveString="video";
				
			}else {
				fileName = codeByPiture.concat("_PITURE_COZY.jpg");
				mediaUploader.saveBase64Image(base64Image, nameByPhotoCategory+dateString+ fileName,sessionIdInteger );
				extensionByArchiveString="photo";
				
			}
				
				String nameByPhotoString=nameByPhotoCategory+dateString+ fileName;
				archive.setName(nameByPhotoString);
				    archive.setPath("archive/photo/"+nameByPhotoString);
				    archive.setType(extensionByArchiveString);
				    archive.setSessionid(sessionIdInteger);
				    Irepository.save(archive);
			jsonResponse.put("status", "success");
			jsonResponse.put("message", "La archivo se subió exitosamente.");
		  return  jsonResponse;
		} catch (IOException e) {
			jsonResponse.put("status", "error");
			jsonResponse.put("message", e.getMessage());
		   return jsonResponse ;
		}
	}

	@GetMapping("/find/{id}")
	public List<Archive> findByArchiveId(@PathVariable("id") Integer id) {
		return Irepository.findByarchiveId(id);
	}

	@PostMapping("/save")
	public Archive saveByArchive(@RequestBody Archive archive) {
		return Irepository.save(archive);
	}

	@PutMapping("/update")
	public Archive updateByArchive(@RequestBody Archive archive) {
		return Irepository.save(archive);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteArchiveById(@PathVariable("id") Integer id) {
		Optional<Archive> state;
		state = Irepository.findById(id);
		if (state.isPresent()) {
			Irepository.delete(state.get());
		}
	}
	
}
