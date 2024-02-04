package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.entity.User;
import org.springframework.stereotype.Component;

import static com.vshtd.parceldelivery.profile.model.entity.ProfileType.USER;
import static com.vshtd.parceldelivery.profile.model.entity.UserStatus.DELETED;


@Component
public class CreateUserAction extends BaseAction<ProfileCreateDTO, User> {

    @Override
    public User execute(ProfileCreateDTO req, Ctx ctx) {
        if (userRepository.exist(req.getUsername(), DELETED)) {
            throw new RuntimeException("User with such username already exist!");
        }
        return User.builder()
                .username(req.getUsername())
                .profileType(USER)
                .build();
    }
}
