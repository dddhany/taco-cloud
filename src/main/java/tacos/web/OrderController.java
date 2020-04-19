package tacos;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import lombok.extern.slf4j.Slf4j;
import tacos.data.OrderRepository;

@Slf4j
@Controller
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	private OrderRepository orderRepo;
	
	@GetMapping("/current")
	public String orderForm(Model model) {
		model.addAttribute("order", new Order());
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors errors
			, SessionStatus sessionStatus, @AuthenticationPrincipal User user) {
		if(errors.hasErrors()) {
			return "orderForm";
		}
		order.setUser(user);
		orderRepo.save(order);
		sessionStatus.setComplete();
		return "redirect:/";
	}
}
