package nen.co.doggo.controller;

import lombok.RequiredArgsConstructor;
import nen.co.doggo.entity.UserEntity;
import nen.co.doggo.security.user.Role;
import nen.co.doggo.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public String getUsers(Model model){

        List<UserEntity> users = userService.getAll();
        model.addAttribute("users", users);

        return "admin/users";
    }

    @GetMapping("/user/{id}")
    public String userEdit(@PathVariable("id") UserEntity user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "admin/user_edit";
    }

    @PostMapping("/user/{id}")
    public String userSave(@RequestParam String username, @RequestParam("userId") UserEntity user,
                           @RequestParam("action") String action, @RequestParam Map<String, String> form) {
        user.setUsername(username);
        if ("yes".equals(action)) {
            user.setActive(!user.isActive());
        }

        Set<Role> newRoles = new HashSet<>();
        for (String key : form.keySet()) {
            if (Role.getStringRoles().contains(key)) {
                newRoles.add(Role.valueOf(key));
            }
        }

        user.setRoles(newRoles);

        userService.saveUser(user);

        return "redirect:/admin/users";
    }


}
