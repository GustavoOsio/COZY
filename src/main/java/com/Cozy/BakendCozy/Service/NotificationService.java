package com.Cozy.BakendCozy.Service;

import java.util.List;

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

import com.Cozy.BakendCozy.Entity.Notification;
import com.Cozy.BakendCozy.Repository.InotificationRepository;


@RestController
@RequestMapping("/api/notification")
@CrossOrigin
public class NotificationService {
	
	@Autowired
	InotificationRepository Irepository;

	@GetMapping(path = "/find/{id}")
	public List<Notification> findByNotificationId(@PathVariable("id") Integer id) {
		return Irepository.findById(id);
	}
	


	@PostMapping(path = "/save")
	public Notification saveByNotification(@RequestBody Notification data) {
		return Irepository.save(data);
	}

	@PutMapping(path = "/update")
	public Notification updateByParameters(@RequestBody Notification data) {
		return Irepository.save(data);
	}

	@DeleteMapping(path = "/delete/{id}")
	public void deleteNotificationById(@PathVariable("id") Integer id) {
		  List<Notification> dataList = Irepository.findById(id);
		    if (!dataList.isEmpty()) {
		    	Notification state = dataList.get(0);
		        Irepository.delete(state);
		    }
	}
	

}
