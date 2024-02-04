package com.vshtd.parceldelivery.profile.model.dto;

import com.vshtd.parceldelivery.profile.model.entity.UserStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
public class UserRespDTO implements Serializable {

    private String username;
    private UserStatus status;
    private Date registrationDate;
}
