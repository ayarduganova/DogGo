package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.entity.WalkRequestEntity;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.WalkerService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {

    private final WalkerService walkerService;

    @GetMapping
    public String getBooks(@AuthenticationPrincipal UserDetailsImpl user, Model model) {

        model.addAttribute("user", user.getUser());

        List<WalkRequestEntity> requests = walkerService.getWalkRequestsForUser(user.getUser().getId());
        model.addAttribute("requests", requests);

        return "walk/book";
    }

}
