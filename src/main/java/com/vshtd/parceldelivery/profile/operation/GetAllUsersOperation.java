package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.GetAllUsersAction;
import com.vshtd.parceldelivery.profile.mapper.UserRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.UserRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetAllUsersOperation extends BaseOperation<Pageable, Page<UserRespDTO>> {

    @Autowired
    private GetAllUsersAction getAllUsers;

    @Autowired
    private UserRespMapper userRespMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<UserRespDTO> execute(Pageable pageable) {
        return getAllUsers.execute(pageable, getCtx())
                .map(user -> userRespMapper.map(user));
    }
}
