package com.vshtd.parceldelivery.profile.mapper;

import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserRespMapper implements Mapper<User, UserRespDTO> {

    @Override
    public UserRespDTO map(User user) {
        return UserRespDTO.builder()
                .username(user.getUsername())
                .status(user.getStatus())
                .registrationDate(user.getRegistrationDate())
                .build();
    }
}
