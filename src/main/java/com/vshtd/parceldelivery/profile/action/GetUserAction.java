package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.entity.User;
import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import org.springframework.stereotype.Component;

@Component
public class GetUserAction extends BaseAction<IProfile, User> {

    @Override
    public User execute(IProfile profile, Ctx ctx) {
        return userRepository.findByUsername(profile.getUsername());
    }
}
