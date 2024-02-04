package com.vshtd.parceldelivery.profile.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProfileCreateDTO implements Serializable {

    private String username;
    private String password;
}
