package com.vshtd.parceldelivery.profile.mapper;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import org.springframework.stereotype.Component;

@Component
public class CourierRespMapper implements Mapper<Courier, CourierRespDTO> {

    @Override
    public CourierRespDTO map(Courier courier) {
        return CourierRespDTO.builder()
                .username(courier.getUsername())
                .registrationDate(courier.getRegistrationDate())
                .status(courier.getStatus())
                .build();
    }
}
