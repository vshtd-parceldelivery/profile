package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.CreateCourierAction;
import com.vshtd.parceldelivery.profile.action.SendCreateProfileAction;
import com.vshtd.parceldelivery.profile.mapper.CourierRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import com.vshtd.parceldelivery.profile.repository.CourierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.vshtd.parceldelivery.profile.model.entity.Role.ROLE_COURIER;

@Component
public class CreateCourierOperation extends BaseOperation<ProfileCreateDTO, CourierRespDTO> {

    @Autowired
    private CreateCourierAction createCourier;

    @Autowired
    private CourierRespMapper courierRespMapper;

    @Autowired
    private SendCreateProfileAction sendCreateProfile;

    @Autowired
    private CourierRepository courierRepository;

    @Transactional
    @Override
    public CourierRespDTO execute(ProfileCreateDTO req) {
        Courier courier = createCourier.execute(req, getCtx());
        getCtx().setRole(ROLE_COURIER);
        return courierRespMapper.map(courierRepository.save(courier));
    }

    @Override
    protected void postOperation(ProfileCreateDTO req) {
        sendCreateProfile.execute(req, getCtx());
    }
}
