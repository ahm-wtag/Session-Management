package mahdi.learning.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SessionController {

    @GetMapping("/")
    public String login() {
        return "login.jsp";
    }


}
