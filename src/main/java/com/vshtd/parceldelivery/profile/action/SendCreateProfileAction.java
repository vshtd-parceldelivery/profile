package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.distribution.RmqSender;
import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.mqo.CreateProfileMQO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SendCreateProfileAction extends BaseAction<ProfileCreateDTO, Void> {

    @Autowired
    private RmqSender rmqSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Void execute(ProfileCreateDTO req, Ctx ctx) {
        rmqSender.createProfile(CreateProfileMQO.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .role(ctx.getRole())
                .build());
        return null;
    }
}
