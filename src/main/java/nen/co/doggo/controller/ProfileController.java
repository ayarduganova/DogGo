package nen.co.doggo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.DogRequest;
import nen.co.doggo.dto.UserRequest;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.DogService;
import nen.co.doggo.service.UserService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final UserService userService;
    private final DogService dogService;

    @GetMapping
    public String getProfile(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));

        return "profile/standart_profile";
    }

    @GetMapping("/editProfile")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));

        return "profile/person_profile_edit";
    }

    @PostMapping("/editProfile")
    public String editPersonProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                    @Valid UserRequest userRequest,
                                    BindingResult bindingResult,
                                    Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "profile/person_profile_edit";
        }

        userService.editProfileInfo(user.getUser(), userRequest);

        return "redirect:/profile";
    }

    @GetMapping("/addDog")
    public String getViewAddDog(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));

        return "profile/dog_profile_edit";
    }

    @PostMapping("/addDog")
    public String addDog(@AuthenticationPrincipal UserDetailsImpl user,
                         @Valid DogRequest dogRequest,
                         BindingResult bindingResult,
                         Model model) {

        model.addAttribute("user", user.getUser());

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "profile/dog_profile_edit";
        }

        dogService.addDog(user.getUser(), dogRequest);

        return "redirect:/profile?tab=d";
    }

    @GetMapping("/editDog/{id}")
    public String editDogProfile(@PathVariable("id") Long dogId,
                                 Model model,
                                 @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("dog", dogService.getDogById(dogId));
        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));
        model.addAttribute("user", user.getUser());

        return "profile/dog_profile_edit";
    }

    @PostMapping("/editDog")
    public String editDogProfile(@AuthenticationPrincipal UserDetailsImpl user,
                                 @RequestParam("dogId") Long dogId,
                                 @Valid DogRequest dogRequest,
                                 BindingResult bindingResult,
                                 Model model) {

        model.addAttribute("dogs", dogService.getDogsByUser(user.getUser()));
        model.addAttribute("user", user.getUser());

        if (bindingResult.hasErrors()) {
            model.addAttribute("message", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "profile/dog_profile_edit";
        }

        dogService.editDog(dogId, dogRequest);

        return "redirect:/profile";
    }

}
