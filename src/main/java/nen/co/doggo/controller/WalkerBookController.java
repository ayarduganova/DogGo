package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.entity.WalkRequestEntity;
import nen.co.doggo.entity.WalkRequestStatus;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.WalkerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('WALKER')")
@RequestMapping("/walker-books")
public class WalkerBookController {

    private final WalkerService walkerService;

    @GetMapping
    public String getBooks(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());

        List<WalkRequestEntity> requests = walkerService.getWalkRequestsForWalker(user.getUser().getWalker().getId());
        model.addAttribute("requests", requests);

        return "walk/walk_book";
    }

    @GetMapping("/confirm/{id}")
    public String confirmBook(@AuthenticationPrincipal UserDetailsImpl user,
                              @PathVariable("id") Long requestId,
                              Model model) {

        model.addAttribute("user", user.getUser());
        List<WalkRequestEntity> requests = walkerService.getWalkRequestsForWalker(user.getUser().getWalker().getId());
        model.addAttribute("requests", requests);

        walkerService.approveStatus(requestId);
        return "walk/walk_book";
    }

    @GetMapping("/reject/{id}")
    public String rejectBook(@AuthenticationPrincipal UserDetailsImpl user,
                             @PathVariable("id") Long requestId,
                              Model model) {

        model.addAttribute("user", user.getUser());
        List<WalkRequestEntity> requests = walkerService.getWalkRequestsForWalker(user.getUser().getWalker().getId());
        model.addAttribute("requests", requests);

        walkerService.rejectStatus(requestId);
        return "walk/walk_book";
    }

}
