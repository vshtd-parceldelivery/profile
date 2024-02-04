package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.GetUserAction;
import com.vshtd.parceldelivery.profile.mapper.UserRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import com.vshtd.parceldelivery.profile.model.entity.User;
import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetUserOperation extends BaseOperation<IProfile, UserRespDTO> {

    @Autowired
    private GetUserAction getUser;

    @Autowired
    private UserRespMapper userRespMapper;

    @Transactional(readOnly = true)
    @Override
    public UserRespDTO execute(IProfile req) {
        User user = getUser.execute(req, getCtx());
        checkNoProfileException(user, req);
        return userRespMapper.map(user);
    }
}
