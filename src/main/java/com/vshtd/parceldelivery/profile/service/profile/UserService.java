package com.vshtd.parceldelivery.profile.service.profile;

import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;

public interface UserService {

    UserRespDTO createUser(ProfileCreateDTO user);

    UserRespDTO get(String username);
}
