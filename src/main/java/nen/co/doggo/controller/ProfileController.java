package nen.co.doggo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;
//    private final DogService dogService;
//    private final WalkerService walkerService;

    @GetMapping
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());

//        model.addAttribute("dogs", dogService.getDogs(user.getUser()));
//        model.addAttribute("service", userService);
//        if(user.getUser().getWalkerEntity() != null){
//            model.addAttribute("walker", walkerService.getWalkerEntityByUser(user.getUser()));
//        }

        return "profile/standart_profile";
    }

    @GetMapping("/editPerson")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    Model model) {

        model.addAttribute("user", user.getUser());

        return "profile/person_profile_edit";
    }

    @PostMapping("/editPerson")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    @Valid UserRequest userRequest,
                                    BindingResult bindingResult,
                                    Model model) {

        model.addAttribute("user", user.getUser());

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "profile/person_profile_edit";
        }

        userService.editProfileInfo(user.getUser(), userRequest);

        return "redirect:/profile";
    }
//
//    @GetMapping("/editDog/{id}")
//    public String editDogProfile(@PathVariable("id") Long dogId, Model model, @AuthenticationPrincipal UserDetailsImpl user) {
//
//        model.addAttribute("dog", dogService.getDogById(dogId));
//        model.addAttribute("dogs", dogService.getDogs(user.getUser()));
//        model.addAttribute("current_user", user.getUser());
//
//        return "profile/dog_profile_edit";
//    }
//
//    @PostMapping("/editDog")
//    public String editDogProfile(@RequestParam("dogId") Long dogId,
//                                 DogRequest dogRequest) {
//
//        dogService.editDog(dogId, dogRequest);
//
//        return "redirect:/profile?tab=d";
//    }
//
//    @GetMapping("/addDog")
//    public String getViewAddDog(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
//
//        model.addAttribute("current_user", user.getUser());
//        model.addAttribute("dogs", dogService.getDogs(user.getUser()));
//
//        return "profile/dog_profile_edit";
//    }
//
//    @PostMapping("/addDog")
//    public String addDog(@AuthenticationPrincipal UserDetailsImpl user,
//                         DogRequest dogRequest) {
//
//        dogService.addDog(user.getUser(), dogRequest);
//
//        return "redirect:/profile?tab=d";
//    }
//
//    @GetMapping("/editWalker")
//    public String editWalkerProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
//
//        model.addAttribute("current_user", user.getUser());
//        if(user.getUser().getWalkerEntity() != null){
//            model.addAttribute("walker", walkerService.getWalkerEntityByUser(user.getUser()));
//        }
//
//        return "profile/walker_profile_edit";
//    }
//
//    @PostMapping("/editWalker")
//    public String editWalkerProfile(@AuthenticationPrincipal UserDetailsImpl user,
//                                    WalkerRequest walkerRequest) {
//
//        walkerService.editWalker(walkerRequest, user.getUser());
//
//        return "redirect:/profile?tab=w";
//    }

}
