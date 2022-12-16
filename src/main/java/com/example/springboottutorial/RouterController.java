package com.example.springboottutorial;


import com.example.springboottutorial.payload.UserPayload;
import com.example.springboottutorial.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;

@Controller
public class RouterController {

    @Autowired private UserService userService;

    @GetMapping("/")
    public ModelAndView home(ModelMap map) {
        map.put("data", Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        return new ModelAndView("index", map);
    }

    @GetMapping("/product/detail/{id}")
    public ModelAndView productDetail(@PathVariable int id) {
        // lay ra product by id
        // tra ve model view (1 trang moi)
        return new ModelAndView("product-detail");
    }

    @GetMapping("/user-profile")
    public ModelAndView profile(ModelMap map) {
        map.addAttribute("user", new UserPayload());
        return new ModelAndView("profile/wizard", map);
    }

    @PostMapping("/user-profile")
    public ModelAndView updateProfile(ModelMap map, @ModelAttribute UserPayload payload, HttpServletRequest request) throws IOException {
        userService.save(payload, request);
        return new ModelAndView("index", map);
    }
}
