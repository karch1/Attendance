/**
 * 
 */
package com.attendance.attendance;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author user
 *
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
