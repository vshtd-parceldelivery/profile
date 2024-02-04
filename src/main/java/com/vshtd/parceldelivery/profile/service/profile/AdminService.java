package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AdminService {

    CourierRespDTO createCourier(ProfileCreateDTO courier);

    Page<CourierRespDTO> getAllCouriers(Pageable pageable);

    Page<UserRespDTO> getAllUsers(Pageable pageable);

    UserRespDTO getUser(String username);

    CourierRespDTO getCourier(String username);
}
