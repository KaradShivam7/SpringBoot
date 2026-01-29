package flipcart.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import flipcart.order.entity.car;



@RestController
public class car_controller {
	
	@Autowired
	private car car;
	
	@GetMapping("/get-id")
	public String getid() {
		return car.getid();
	}

}
