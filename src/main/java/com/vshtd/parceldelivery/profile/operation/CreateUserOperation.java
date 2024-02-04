package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.CreateUserAction;
import com.vshtd.parceldelivery.profile.action.SendCreateProfileAction;
import com.vshtd.parceldelivery.profile.mapper.UserRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.ProfileCreateDTO;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.model.entity.User;
import com.vshtd.parceldelivery.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import static com.vshtd.parceldelivery.profile.model.entity.Role.ROLE_USER;

@Component
public class CreateUserOperation extends BaseOperation<ProfileCreateDTO, UserRespDTO> {

    @Autowired
    private CreateUserAction createUser;

    @Autowired
    private UserRespMapper userRespMapper;

    @Autowired
    private SendCreateProfileAction sendCreateProfile;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public UserRespDTO execute(ProfileCreateDTO req) {
        User user = createUser.execute(req, getCtx());
        getCtx().setRole(ROLE_USER);
        return userRespMapper.map(userRepository.save(user));
    }

    @Override
    protected void postOperation(ProfileCreateDTO req) {
        sendCreateProfile.execute(req, getCtx());
    }
}
