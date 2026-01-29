package flipcart.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import flipcart.order.entity.car;

@RestController
@RequestMapping("/car")
public class carcontroller1 {
	
	@Autowired
	private car car;
	
	@GetMapping("/get-id")
	public String getid() {
		return car.getid();
	}

}
