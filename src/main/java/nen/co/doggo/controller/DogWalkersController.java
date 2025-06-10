package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.dto.req.ScheduleRequest;
import nen.co.doggo.dto.req.WalkerRequest;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.WalkerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/walkers")
public class DogWalkersController {

    private final WalkerService walkerService;
//    private final UserService userService;
//    private final PostService postService;

    @GetMapping
    public String getWalkers(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());
//        model.addAttribute("current_user", user.getUser());
//        model.addAttribute("service", userService);
//        model.addAttribute("role", Role.WALKER);
//        model.addAttribute("posts", postService.getAll());

        return "walk/walkers";
    }

    @PostMapping()
    public String sendWalkerRequest(@AuthenticationPrincipal UserDetailsImpl user,
                                    WalkerRequest walkerRequest,
                                    ScheduleRequest scheduleRequest){

        walkerService.sendWalkerRequest(user.getUser(), walkerRequest, scheduleRequest);

        return "redirect:/walkers";
    }

//    @GetMapping("/addPost")
//    @PreAuthorize("hasAuthority('WALKER')")
//    public String getViewAddPost(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
//
//        model.addAttribute("current_user", user.getUser());
//        model.addAttribute("posts", postService.getAll());
//
//        return "walkers/post_add";
//    }
//
//    @PostMapping("/addPost")
//    @PreAuthorize("hasAuthority('WALKER')")
//    public String addPost(@AuthenticationPrincipal UserDetailsImpl user,
//                          PostRequest postRequest) {
//
//        postService.addPost(user.getUser(), postRequest);
//
//        return "redirect:/walkers";
//    }

}
