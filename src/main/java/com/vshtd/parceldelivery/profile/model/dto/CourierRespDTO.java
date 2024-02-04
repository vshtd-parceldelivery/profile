package com.vshtd.parceldelivery.profile.model.dto;

import com.vshtd.parceldelivery.profile.model.entity.CourierStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Builder
public class CourierRespDTO implements Serializable {

    private String username;
    private CourierStatus status;
    private Date registrationDate;
}
