package com.vshtd.parceldelivery.profile.controller;

import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.service.profile.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/profile/user")
@Tag(name = "User", description = "user profile API")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @Operation(summary = "registration user profile")
    public UserRespDTO registration(@RequestBody ProfileCreateDTO user) {
        return userService.createUser(user);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @Operation(summary = "get user own profile")
    public UserRespDTO get(Principal principal) {
        return userService.get(principal.getName());
    }
}
