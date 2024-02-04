package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.internal.GetProfileInO;
import com.vshtd.parceldelivery.profile.operation.GetCourierOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourierServiceImpl implements CourierService {

    @Autowired
    private GetCourierOperation getCourier;

    @Override
    public CourierRespDTO get(String username) {
        return getCourier.process(GetProfileInO.builder()
                .username(username)
                .build());
    }
}
