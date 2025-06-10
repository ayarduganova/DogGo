package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.security.user.Role;
import nen.co.doggo.security.user.UserDetailsImpl;
import nen.co.doggo.service.UserService;
import nen.co.doggo.service.WalkerService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;
    private final WalkerService walkerService;

    @GetMapping("/users")
    public String getUsers(Model model, @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("users", userService.getAll());
        model.addAttribute("user", user.getUser());

        return "admin/users";
    }

    @GetMapping("/user/{id}")
    public String userEdit(@PathVariable("id") UserEntity user, Model model,
                           @AuthenticationPrincipal UserDetailsImpl currentUser) {

        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("users", userService.getAll());
        model.addAttribute("current_user", currentUser.getUser());

        return "admin/user_edit";
    }

    @PostMapping("/user")
    public String userEdit(@RequestParam("userId") UserEntity user,
                           @RequestParam("block_action") String blockAction,
                           @RequestParam Map<String, String> form,
                           @RequestParam("btn_action") String btnAction) {


        userService.editUser(user, blockAction, form, btnAction);

        return "redirect:/admin/users";
    }

    @GetMapping("/requests")
    public String getRequests(Model model, @AuthenticationPrincipal UserDetailsImpl user) {

        model.addAttribute("current_user", user.getUser());
        model.addAttribute("requests", walkerService.getRequests());

        return "admin/requests";
    }

    @PostMapping("/requests")
    public String approveForm(@RequestParam("requestId")Long walkerFormId,
                              @RequestParam("action") String action){

        if (action.equals("approve")) {
            walkerService.approveForm(walkerFormId);
        } else if (action.equals("reject")) {
            walkerService.rejectForm(walkerFormId);
        }

        return "redirect:/admin/requests";
    }

}

