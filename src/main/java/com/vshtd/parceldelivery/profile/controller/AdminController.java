package com.vshtd.parceldelivery.profile.controller;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.service.profile.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profile/admin")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")
@Tag(name = "Admin", description = "admin profile API")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/courier/create")
    @Operation(summary = "create courier")
    public CourierRespDTO createCourier(@RequestBody ProfileCreateDTO courier) {
        return adminService.createCourier(courier);
    }

    @GetMapping("/courier/all")
    @Operation(summary = "getAllCouriers")
    public Page<CourierRespDTO> getAllCouriers(@ParameterObject Pageable pageable) {
        return adminService.getAllCouriers(pageable);
    }

    @GetMapping("/user/all")
    @Operation(summary = "getAllUsers")
    public Page<UserRespDTO> getAllUsers(@ParameterObject Pageable pageable) {
        return adminService.getAllUsers(pageable);
    }

    @GetMapping("/user/{username}")
    @Operation(summary = "get user profile")
    public UserRespDTO getUser(@PathVariable(name = "username") String username) {
        return adminService.getUser(username);
    }

    @GetMapping("/courier/{username}")
    @Operation(summary = "get courier profile")
    public CourierRespDTO getCourier(@PathVariable(name = "username") String username) {
        return adminService.getCourier(username);
    }
}
