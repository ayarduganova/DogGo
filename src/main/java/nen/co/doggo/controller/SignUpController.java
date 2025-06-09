package nen.co.doggo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import static nen.co.doggo.alert.AlertMessage.INVALID_DATA;
import static nen.co.doggo.alert.AlertMessage.USER_EXIST;

@Controller
@RequiredArgsConstructor
public class SignUpController {

    private final UserService userService;

    @GetMapping("/signUp")
    public String signUp() {
        return "sign/signup";
    }

    @PostMapping("/signUp")
    public String signUp(@Valid UserRequest userRequest,
                         BindingResult bindingResult,
                         Model model){

        model.addAttribute("userRequest", userRequest);

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "sign/signup";
        }

        if (userService.exist(userRequest.username())){
            model.addAttribute("message", USER_EXIST);
            return "sign/signup";
        }

        userService.signUp(userRequest);
        return "redirect:/signIn";
    }

    @GetMapping("/signIn-error")
    public String loginError(Model model) {
        model.addAttribute("message", INVALID_DATA);
        return "sign/signin";
    }

    @GetMapping("/main")
    public String main() {
        return "main";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/signIn?logout";
    }

}

