package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;

public interface CourierService {

    CourierRespDTO get(String username);
}
