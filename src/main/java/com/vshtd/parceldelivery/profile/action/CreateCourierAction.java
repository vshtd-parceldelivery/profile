package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import org.springframework.stereotype.Component;

import static com.vshtd.parceldelivery.profile.model.entity.CourierStatus.DELETED;
import static com.vshtd.parceldelivery.profile.model.entity.ProfileType.COURIER;

@Component
public class CreateCourierAction extends BaseAction<ProfileCreateDTO, Courier> {

    @Override
    public Courier execute(ProfileCreateDTO req, Ctx ctx) {
        if (courierRepository.exist(req.getUsername(), DELETED)) {
            throw new RuntimeException("Courier with such username already exist!");
        }
        return Courier.builder()
                .username(req.getUsername())
                .profileType(COURIER)
                .build();
    }
}
