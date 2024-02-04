package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.model.internal.GetProfileInO;
import com.vshtd.parceldelivery.profile.operation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private CreateCourierOperation createCourier;

    @Autowired
    private GetAllCouriersOperation getAllCouriers;

    @Autowired
    private GetAllUsersOperation getAllUsers;

    @Autowired
    private GetUserOperation getUser;

    @Autowired
    private GetCourierOperation getCourier;

    @Override
    public CourierRespDTO createCourier(ProfileCreateDTO courier) {
        return createCourier.process(courier);
    }

    @Override
    public Page<CourierRespDTO> getAllCouriers(Pageable pageable) {
        return getAllCouriers.process(pageable);
    }

    @Override
    public Page<UserRespDTO> getAllUsers(Pageable pageable) {
        return getAllUsers.execute(pageable);
    }

    @Override
    public UserRespDTO getUser(String username) {
        return getUser.process(GetProfileInO.builder()
                .username(username)
                .build());
    }

    @Override
    public CourierRespDTO getCourier(String username) {
        return getCourier.process(GetProfileInO.builder()
                .username(username)
                .build());
    }
}
