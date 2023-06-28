package com.Cozy.BakendCozy.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Cozy.BakendCozy.Entity.BasicData;
import com.Cozy.BakendCozy.Entity.ContactUser;
import com.Cozy.BakendCozy.Entity.Intention;
import com.Cozy.BakendCozy.Entity.NewProspectiveClientVo;
import com.Cozy.BakendCozy.Entity.NewUserByAdminVo;
import com.Cozy.BakendCozy.Entity.Notification;
import com.Cozy.BakendCozy.Entity.RealEstateInterestProspect;
import com.Cozy.BakendCozy.Entity.User;
import com.Cozy.BakendCozy.Entity.WebPanelContactVO;
import com.Cozy.BakendCozy.Props.BCrypt;
import com.Cozy.BakendCozy.Props.EmailSender;
import com.Cozy.BakendCozy.Props.GenerateCode;
import com.Cozy.BakendCozy.Repository.IbasicDataRepository;
import com.Cozy.BakendCozy.Repository.IcontactUserRepository;
import com.Cozy.BakendCozy.Repository.IintentionRepository;
import com.Cozy.BakendCozy.Repository.InotificationRepository;
import com.Cozy.BakendCozy.Repository.IrealEstateProspectInteresRepository;
import com.Cozy.BakendCozy.Repository.IuserRepository;
import com.alibaba.fastjson.JSONObject;



@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class UserService {

	@Autowired
	IuserRepository userRepository;
	
	@Autowired
	IbasicDataRepository ibasicDataRepository;
	
	@Autowired
	IcontactUserRepository icontactUserRepository;
	
	@Autowired
	IrealEstateProspectInteresRepository iporspect;
	
	@Autowired
	IintentionRepository iinteresRepository;
	
	@Autowired
	InotificationRepository inotificationRepository;
	
	BCrypt bcript=new BCrypt();
	EmailSender emailSend =new EmailSender();
	@Value("${mail.recipientEmail}")
	private static  String recipientEmail;

	@Value("${mail.subject}")
	private static String subject;

	@Value("${mail.body}")
	private static String bodyEmail;
	
	
	
	//admin
		@PostMapping(path = "/saveBynewClientOfAdmin")
		public  JSONObject saveBynewClientOfAdmin(@RequestBody NewUserByAdminVo client)  {
					
			User user = new User();
			BasicData basicData = new BasicData();
			ContactUser contactUser = new ContactUser();
			Intention interest = new Intention();
			RealEstateInterestProspect prospect = new RealEstateInterestProspect();
			GenerateCode code = new GenerateCode();
			String codeByCozy = code.main(null);

			Date currentDate = new Date();
			JSONObject jsonResponse = new JSONObject();

			try {
			    // Datos de contacto
			    contactUser.setCellphone(client.getCellphone());
			    contactUser.setEmail(client.getEmail());
			    contactUser.setResidenceCity(client.getCityOfResidence());
			    contactUser.setResidenceCountry(client.getCountryOfResidence());
			    contactUser.setResidenceAddress(client.getResidentialAddress());
			    ContactUser contactUserById = icontactUserRepository.save(contactUser);

			    // Datos básicos
			    basicData.setName(client.getFirstName());
			    basicData.setLastName(client.getLastName());
			    basicData.setBirthDate(client.getDateOfBirth());
			    basicData.setBirthCountry(client.getCountryOfBirth());
			    basicData.setBirthCity(client.getCityOfBirth());
			    basicData.setStatus("Activo");
			    	    
			    //otros datos
			     basicData.setEntryDate(client.getEntryDate());
			    basicData.setEntryOrigin(client.getEntryOrigin());
			    basicData.setIdentificationType(client.getIdentificationType());
			    basicData.setIdentificationNumber(client.getIdentificationNumber());
			    basicData.setStatus(client.getState());
			    basicData.setCozyCode(codeByCozy);
			    BasicData basicDataById = ibasicDataRepository.save(basicData);
			    
			    
			    if (basicDataById.getId() != null) {
			        // Crear usuario
			        user.setUser(client.getUser());
			        user.setIdBasicData(basicDataById.getId());
			        user.setIdContact(contactUserById.getId());
			        user.setIdRol(client.getIdRol());
			        user.setPassword(bcript.hashpw(client.getPassword(), bcript.gensalt()));
			        user.setStatus("Activo");
			        User userById = userRepository.save(user);

			        if (userById.getUserId() != null) {
			            jsonResponse.put("status", "success");
			            jsonResponse.put("message", "Se ha enviado el formulario con éxito.");
			            return jsonResponse;
			        } else {
			            jsonResponse.put("status", "error");
			            jsonResponse.put("message", "Error al crear el usuario.");
			            return jsonResponse;
			        }
			    } else {
			        jsonResponse.put("status", "error");
			        jsonResponse.put("message", "Error al crear los datos básicos.");
			        return jsonResponse;
			    }
			} catch (Exception e) {
			    jsonResponse.put("status", "error");
			    jsonResponse.put("message", e.toString());
			    return jsonResponse;
			}
			
			
			
		}
		
		
		@GetMapping("/userFilterById/{id}")
		public ResponseEntity<Map<String, List<?>>> getuserFilterById(@PathVariable("id") Integer userId) {
		    List<RealEstateInterestProspect> prospectByFilter = iporspect.findById(userId);
		    List<User> usersByFilter = new ArrayList<>();
		    List<BasicData> basicDataByFilter = new ArrayList<>();
		    List<ContactUser> contactUserByFilter = new ArrayList<>();

		    for (RealEstateInterestProspect prospect : prospectByFilter) {
		        List<User> userData = userRepository.findByuserId(prospect.getUserId());
		        usersByFilter.addAll(userData);

		        for (User user : userData) {
		            List<BasicData> basicData = ibasicDataRepository.findById(user.getIdBasicData());
		            basicDataByFilter.addAll(basicData);

		            List<ContactUser> contactUserData = icontactUserRepository.findById(user.getIdContact());
		            contactUserByFilter.addAll(contactUserData);
		        }
		    }

		    Map<String, List<?>> dataMap = new HashMap<>();
		    dataMap.put("prospetByInterest", prospectByFilter);
		    dataMap.put("basicData", basicDataByFilter);
		    dataMap.put("contactUser", contactUserByFilter);
		    dataMap.put("users", usersByFilter);

		    return ResponseEntity.ok(dataMap);
		}

		
		
		@GetMapping("/userFilterByIdAll")
		public ResponseEntity<Map<String, List<?>>> getinterestFilterUserByIdAll() {
		    List<User> interestFilter = userRepository.findAll();

		    Map<String, List<?>> dataMap = new HashMap<>();
		    List<RealEstateInterestProspect> prospectByFilter = new ArrayList<>();
		    List<User> usersByFilter = new ArrayList<>();
		    List<BasicData> basicDataByFilter = new ArrayList<>();
		    List<ContactUser> contactUserByFilter = new ArrayList<>();

		    for (User user : interestFilter) {
		        List<RealEstateInterestProspect> data = iporspect.findById(user.getUserId());
		        prospectByFilter.addAll(data);

		        for (RealEstateInterestProspect prospect : data) {
		            List<User> userData = userRepository.findByuserId(prospect.getUserId());
		            usersByFilter.addAll(userData);

		            for (User user1 : userData) {
		                List<BasicData> basicData = ibasicDataRepository.findById(user1.getIdBasicData());
		                basicDataByFilter.addAll(basicData);

		                List<ContactUser> contactUserData = icontactUserRepository.findById(user1.getIdContact());
		                contactUserByFilter.addAll(contactUserData);
		            }
		        }
		    }

		    dataMap.put("prospetByInterest", prospectByFilter);
		    dataMap.put("basicData", basicDataByFilter);
		    dataMap.put("contactUser", contactUserByFilter);
		    dataMap.put("intention", interestFilter);
		    dataMap.put("users", usersByFilter);

		    return ResponseEntity.ok(dataMap);
		}

		
	
	
	@DeleteMapping(path = "/deleteByprospectByid/{id}")
	public String deleteByprospectByid(@PathVariable("id") Integer userId) {
			User user = userRepository.findById(userId).orElse(null);
	        if (user != null) {
	            user.setStatus("delete");
	            user = userRepository.save(user);
	        }
	 	        return "se envio el registro ha archivo para ser eliminado";
	    	
	}
	
	
	
	@GetMapping("/interestFilterPotentialClientsAll")
    public ResponseEntity<Map<String, List<?>>> getinterestFilterPotentialClientsAll() {
        List<Intention> interestFilter;
     
            interestFilter = iinteresRepository.findAll();
          
        Map<String, List<?>> dataMap = new HashMap<>();
        List<RealEstateInterestProspect> prospectByFilter = new ArrayList<>();
        List<User> usersByFilter = new ArrayList<>();
        List<BasicData> basicDataByFilter = new ArrayList<>();
        List<ContactUser> contactUserByFilter = new ArrayList<>();
        
        for (Intention intention : interestFilter) {
            List<RealEstateInterestProspect> data = iporspect.findById(intention.getProspectRealEstateId());
            prospectByFilter.addAll(data);
            
            for (RealEstateInterestProspect prospect : data) {
                List<User> userData = userRepository.findByuserId(prospect.getUserId());
                usersByFilter.addAll(userData);
                
                for (User user : userData) {
                    List<BasicData> basicData = ibasicDataRepository.findById(user.getIdBasicData());
                    basicDataByFilter.addAll(basicData);
                    
                    List<ContactUser> contactUserData = icontactUserRepository.findById(user.getIdContact());
                    contactUserByFilter.addAll(contactUserData);
                }
            }
        }
        
        dataMap.put("prospetByInterest", prospectByFilter);
        dataMap.put("basicData", basicDataByFilter);
        dataMap.put("contactUser", contactUserByFilter);
        dataMap.put("intention", interestFilter);
        dataMap.put("users", usersByFilter);
        
        return ResponseEntity.ok(dataMap);
    }
	
	
	 @GetMapping("/interestFilterPotentialClients/{interest}")
	    public ResponseEntity<Map<String, List<?>>> getData(@PathVariable("interest") String filter) {
		 List<Intention> interestFilter;
	        if (filter == null || filter.isEmpty()) {
	            interestFilter = iinteresRepository.findAll();
	        } else {
	            interestFilter = iinteresRepository.findByIntentionContaining(filter);
	        }
	        
	        List<RealEstateInterestProspect> prospectByFilter = new ArrayList<>();
	        for (Intention intention : interestFilter) {
	            List<RealEstateInterestProspect> data =  iporspect.findById(intention.getProspectRealEstateId());
	            prospectByFilter.addAll(data);
	        }
	        
	        List<User> usersByFilter = new ArrayList<>();
	        for (RealEstateInterestProspect prospect : prospectByFilter) {
	            List<User> data = userRepository.findByuserId(prospect.getUserId());
	            usersByFilter.addAll(data);
	        }
	        
	        List<BasicData> basicDataByFilter = new ArrayList<>();
	        for (User user : usersByFilter) {
	            List<BasicData> data = ibasicDataRepository.findById(user.getIdBasicData());
	            basicDataByFilter.addAll(data);
	        }
	        
	        List<ContactUser> contactUserByFilter = new ArrayList<>();
	        for (User user : usersByFilter) {
	            List<ContactUser> data = icontactUserRepository.findById(user.getIdContact());
	            contactUserByFilter.addAll(data);
	        }
	        
	        Map<String, List<?>> dataMap = new HashMap<>();
	        dataMap.put("prospectByInterest", prospectByFilter);
	        dataMap.put("basicData", basicDataByFilter);
	        dataMap.put("contactUser", contactUserByFilter);
	        dataMap.put("intention", interestFilter);
	        dataMap.put("users", usersByFilter);
	        
	        return ResponseEntity.ok(dataMap);
	    }
	    
	
	
	
	
	public  String  getInterestByContact(WebPanelContactVO contact)  {
		List<Intention> intentionList = contact.getInterest();
	    StringBuilder stringBuilder = new StringBuilder();

	    for (Intention intention : intentionList) {
	        stringBuilder.append(intention.getIntention()).append(",");
	    }

	    if (stringBuilder.length() > 0) {
	        stringBuilder.setLength(stringBuilder.length() - 1);
	    }

	    return stringBuilder.toString();
		
	}
	
	//admin
	@PostMapping(path = "/saveBynewProspectiveClient")
	public  JSONObject  newProspectiveClient(@RequestBody NewProspectiveClientVo client)  {
				
		User user = new User();
		BasicData basicData = new BasicData();
		ContactUser contactUser = new ContactUser();
		Intention interest = new Intention();
		RealEstateInterestProspect prospect = new RealEstateInterestProspect();
		GenerateCode code = new GenerateCode();
		String codeByCozy = code.main(null);

		Date currentDate = new Date();
		JSONObject jsonResponse = new JSONObject();

		try {
		    // Datos de contacto
		    contactUser.setCellphone(client.getCellphone());
		    contactUser.setEmail(client.getEmail());
		    contactUser.setResidenceCity(client.getCityOfResidence());
		    contactUser.setResidenceCountry(client.getCountryOfResidence());
		    contactUser.setResidenceAddress(client.getResidentialAddress());
		    ContactUser contactUserById = icontactUserRepository.save(contactUser);

		    // Datos básicos
		    basicData.setName(client.getFirstName());
		    basicData.setLastName(client.getLastName());
		    basicData.setBirthDate(client.getDateOfBirth());
		    basicData.setBirthCountry(client.getCountryOfBirth());
		    basicData.setBirthCity(client.getCityOfBirth());
		    basicData.setStatus("Activo");
		    	    
		    //otros datos
		     basicData.setEntryDate(client.getEntryDate());
		    basicData.setEntryOrigin(client.getEntryOrigin());
		    basicData.setIdentificationType(client.getIdentificationType());
		    basicData.setIdentificationNumber(client.getIdentificationNumber());
		    basicData.setStatus(client.getState());
		    basicData.setCozyCode(codeByCozy);
		    BasicData basicDataById = ibasicDataRepository.save(basicData);
		    
		    
		    if (basicDataById.getId() != null) {
		        // Crear usuario
		        user.setUser(client.getEmail());
		        user.setIdBasicData(basicDataById.getId());
		        user.setIdContact(contactUserById.getId());
		        user.setIdRol(1);
		        user.setPassword(bcript.hashpw(client.getFirstName(), bcript.gensalt()));
		        user.setStatus("Activo");
		        User userById = userRepository.save(user);

		        if (userById.getUserId() != null) {
		            // Prospecto de interés en bienes raíces
		   
		        	prospect.setRealEstateId(client.getPropertyInterest()); //propiedad de interes id
		        	prospect.setApartmentHouse(client.getApartmentOrHouse());
		        	prospect.setCoOwnership(client.getCoOwnership());
		        	prospect.setCityLocation(client.getLocationCityOrMunicipality());
		        	prospect.setCountryLocation(client.getLocationCountry());
		        	prospect.setAddressLocation(client.getLocationAddress());
		        	prospect.setBudget(client.getBudget());
		        	prospect.setIntentionMessage(client.getIntentionsMessage());
		        	prospect.setComment(client.getInterestComment());
		            prospect.setUserId(userById.getUserId());
		            prospect.setIntentionMessage(client.getIntentionsMessage());
		            prospect.setRealEstateId(client.getPropertyInterest());
		            prospect.setIntentionType(client.getIntentionsType());    
		            RealEstateInterestProspect prospectById = iporspect.save(prospect);

		            // Guardar intereses elegidos
		            interest.setProspectRealEstateId(prospectById.getId());
		            interest.setIntention(client.getInterest());
		            iinteresRepository.save(interest);
		       
		            jsonResponse.put("status", "success");
		            jsonResponse.put("message", "Se ha enviado el formulario con éxito.");
		            return jsonResponse;
		        } else {
		            jsonResponse.put("status", "error");
		            jsonResponse.put("message", "Error al crear el usuario.");
		            return jsonResponse;
		        }
		    } else {
		        jsonResponse.put("status", "error");
		        jsonResponse.put("message", "Error al crear los datos básicos.");
		        return jsonResponse;
		    }
		} catch (Exception e) {
		    jsonResponse.put("status", "error");
		    jsonResponse.put("message", e.toString());
		    return jsonResponse;
		}
		
		
		
	}

	
	//public
	@PostMapping(path = "/saveByContact")
	public  JSONObject  saveByWebPanelContact(@RequestBody WebPanelContactVO contact)  {
		
		User user = new User();
		Notification notificactio =new Notification();
		BasicData basicData = new BasicData();
		ContactUser contactUser = new ContactUser();
		Intention interest = new Intention();
		RealEstateInterestProspect prospect = new RealEstateInterestProspect();
		GenerateCode code = new GenerateCode();
		String codeByCozy = code.main(null);

		Date currentDate = new Date();
		JSONObject jsonResponse = new JSONObject();

		try {
		    // Datos de contacto
		    contactUser.setCellphone(contact.getCellPhone());
		    contactUser.setComment(contact.getIntentions());
		    contactUser.setEmail(contact.getEmail());
		    ContactUser contactUserById = icontactUserRepository.save(contactUser);

		    // Datos básicos
		    basicData.setName(contact.getName());
		    basicData.setCozyCode(codeByCozy);
		    basicData.setEntryDate(currentDate);
		    basicData.setEntryOrigin("Web");
		    basicData.setStatus("Activo");
		    BasicData basicDataById = ibasicDataRepository.save(basicData);

		    if (basicDataById.getId() != null) {
		        // Crear usuario
		        user.setUser(contact.getEmail());
		        user.setIdBasicData(basicDataById.getId());
		        user.setIdContact(contactUserById.getId());
		        user.setIdRol(1);
		        user.setPassword(bcript.hashpw(contact.getName(), bcript.gensalt()));
		        user.setStatus("Activo");
		        User userById = userRepository.save(user);

		        if (userById.getUserId() != null) {
		            // Prospecto de interés en bienes raíces
		       //     prospect.setComment(contact.getIntentions());
		            prospect.setUserId(userById.getUserId());
		            prospect.setIntentionMessage(contact.getIntentions());

		            // Si el ID de la propiedad es negativo, se establece en 1 para indicar que no hay propiedad asociada
		            prospect.setRealEstateId(contact.getRealEstateId() < 0 ? 1 : contact.getRealEstateId());
		            RealEstateInterestProspect prospectById = iporspect.save(prospect);

		            // Guardar intereses elegidos
		            if (!contact.getInterest().isEmpty()) {
		                interest.setProspectRealEstateId(prospectById.getId());
		                interest.setIntention(this.getInterestByContact(contact));
		                iinteresRepository.save(interest);
		            }

		            // Enviar correo de notificación
		            String recipientEmail = "dipasag@gmail.com";
		            String subject = "¡Hola nuevo interesado!";
		            String body = "Revisa tu bandeja hay un nuevo interesado.";
		            emailSend.sendEmail(recipientEmail, subject, body);
		            
		            //enviar notificacion
		            LocalDateTime localDateTime = LocalDateTime.now();
		            Timestamp timestamp = Timestamp.valueOf(localDateTime);
		            notificactio.setRealEstateInterestProsId( prospectById.getId());
		            notificactio.setUserId(userById.getUserId());
		            notificactio.setMessage("Nuevo interesado ha enviado una solicitud");
		            notificactio.setTimestamp(timestamp );
		            notificactio.setRead(false);
		            inotificationRepository.save(notificactio);

		            jsonResponse.put("status", "success");
		            jsonResponse.put("message", "Se ha enviado el formulario con éxito.");
		            return jsonResponse;
		        } else {
		            jsonResponse.put("status", "error");
		            jsonResponse.put("message", "Error al crear el usuario.");
		            return jsonResponse;
		        }
		    } else {
		        jsonResponse.put("status", "error");
		        jsonResponse.put("message", "Error al crear los datos básicos.");
		        return jsonResponse;
		    }
		} catch (Exception e) {
		    jsonResponse.put("status", "error");
		    jsonResponse.put("message", e.toString());
		    return jsonResponse;
		}
		
		
	}
	
	
	@GetMapping(path = "/findAll")
	public List<User> findAllByUser(){
		return userRepository.findAll();
	}
	
	@GetMapping(path = "/find/{id}")
	public List<User> findByUserId(@PathVariable("id") Integer id) {
		return userRepository.findByuserId(id);
	}

	@PostMapping(path = "/save")
	public User saveByUser(@RequestBody User user) {
		
		if (user.getPassword().length()<0) {
			return user;
		}
		
		user.setPassword(bcript.hashpw(user.getPassword(), bcript.gensalt()));
		return userRepository.save(user);
	}

	@PutMapping(path = "/update")
	public User updateByUser(@RequestBody User user) {

		return userRepository.save(user);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteUserById(@PathVariable("id") Integer id) {
		Optional<User> state;
		state = userRepository.findById(id);
		if (state.isPresent()) {
			userRepository.delete(state.get());
		}
	}

}
