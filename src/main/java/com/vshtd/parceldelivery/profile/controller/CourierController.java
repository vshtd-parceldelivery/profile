package com.vshtd.parceldelivery.profile.controller;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.service.profile.CourierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/profile/courier")
@PreAuthorize("hasAuthority('ROLE_COURIER')")
@Tag(name = "Courier", description = "courier profile API")
public class CourierController {

    @Autowired
    private CourierService courierService;

    @GetMapping
    @Operation(summary = "get courier own profile")
    public CourierRespDTO get(Principal principal) {
        return courierService.get(principal.getName());
    }

}
