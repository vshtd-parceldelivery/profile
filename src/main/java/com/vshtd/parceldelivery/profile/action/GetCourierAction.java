package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import org.springframework.stereotype.Component;

@Component
public class GetCourierAction extends BaseAction<IProfile, Courier> {

    @Override
    public Courier execute(IProfile req, Ctx ctx) {
        return courierRepository.findByUsername(req.getUsername());
    }
}
