package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.model.internal.GetProfileInO;
import com.vshtd.parceldelivery.profile.operation.CreateUserOperation;
import com.vshtd.parceldelivery.profile.operation.GetUserOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private CreateUserOperation createUser;

    @Autowired
    private GetUserOperation getUser;

    @Override
    public UserRespDTO createUser(ProfileCreateDTO user) {
        return createUser.process(user);
    }

    @Override
    public UserRespDTO get(String username) {
        return getUser.process(GetProfileInO.builder()
                .username(username)
                .build());
    }
}
