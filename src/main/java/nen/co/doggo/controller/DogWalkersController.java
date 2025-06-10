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

    @GetMapping
    public String getWalkers(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());
        model.addAttribute("walkers", walkerService.getApprovedRequests());

        return "walk/walkers";
    }

    @PostMapping()
    public String sendWalkerRequest(@AuthenticationPrincipal UserDetailsImpl user,
                                    WalkerRequest walkerRequest,
                                    ScheduleRequest scheduleRequest){

        walkerService.sendWalkerRequest(user.getUser(), walkerRequest, scheduleRequest);

        return "redirect:/walkers";
    }

}
