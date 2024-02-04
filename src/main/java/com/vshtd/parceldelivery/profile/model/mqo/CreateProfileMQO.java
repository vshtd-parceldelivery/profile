package com.vshtd.parceldelivery.profile.model.mqo;

import com.vshtd.parceldelivery.profile.model.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Builder
public class CreateProfileMQO implements Serializable {

    private String username;
    private String password;
    private Role role;
}
