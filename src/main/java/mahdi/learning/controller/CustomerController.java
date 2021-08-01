package mahdi.learning.controller;

import mahdi.learning.model.Customer;
import mahdi.learning.model.Session;
import mahdi.learning.service.CustomerService;
import mahdi.learning.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;
import java.util.UUID;


@Controller
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    SessionService sessionService;


    @PostMapping("/register")
    public RedirectView register(HttpServletRequest request, RedirectAttributes attributes, HttpServletResponse response ) {
        Customer customer = new Customer();
        customer.setUser_name(request.getParameter("name"));
        customer.setPassword(request.getParameter("password"));
        Long id = customerService.save(customer);

        Session session = new Session();
        session.setCustomer_id(id);
        UUID uuid = sessionService.save(session);

        Cookie cookie = new Cookie("sc",uuid.toString());
        cookie.setHttpOnly(true);

        response.addCookie(cookie);

        attributes.addAttribute("name", request.getParameter("name"));
        return new RedirectView("/home");
    }

    @GetMapping("/home")
    public ModelAndView home(@ModelAttribute("name") String name  ) {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("home.jsp");
        mv.addObject("name",name);
        return mv;
    }

}
