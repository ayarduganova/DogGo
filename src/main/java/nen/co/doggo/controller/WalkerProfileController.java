package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.UserService;
import nen.co.doggo.service.WalkerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walker-profile")
public class WalkerProfileController {

    private final UserService userService;
    private final WalkerService walkerService;

    @GetMapping
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("walker", walkerService.getWalkerByUser(user.getUser()));

        return "profile/walker";
    }

//    @GetMapping("/editProfile")
//    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
//                                    Model model) {
//
//        model.addAttribute("user", user.getUser());
//        model.addAttribute("walker", walkerService.getWalkerByUser(user.getUser()));
//
//        return "profile/walker_edit";
//    }
//
//    @PostMapping("/editProfile")
//    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
//                                    @Valid UserRequest userRequest,
//                                    BindingResult bindingResult,
//                                    Model model) {
//
//        model.addAttribute("user", user.getUser());
//        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));
//
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
//            return "profile/person_profile_edit";
//        }
//
//        userService.editProfileInfo(user.getUser(), userRequest);
//
//        return "redirect:/profile";
//    }

}
