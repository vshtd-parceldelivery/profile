package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllUsersAction extends BaseAction<Pageable, Page<User>> {

    @Override
    public Page<User> execute(Pageable pageable, Ctx ctx) {
        return userRepository.findAll(pageable);
    }
}
