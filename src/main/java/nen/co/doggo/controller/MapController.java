package nen.co.doggo.controller;

import nen.co.doggo.security.user.UserDetailsImpl;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapController {

    @GetMapping("/map")
    public String getMap(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());

        return "map/map";
    }

}
