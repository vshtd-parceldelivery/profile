package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.GetCourierAction;
import com.vshtd.parceldelivery.profile.mapper.CourierRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetCourierOperation extends BaseOperation<IProfile, CourierRespDTO> {

    @Autowired
    private GetCourierAction getCourier;

    @Autowired
    private CourierRespMapper courierRespMapper;

    @Transactional(readOnly = true)
    @Override
    public CourierRespDTO execute(IProfile req) {
        Courier courier = getCourier.execute(req, getCtx());
        checkNoProfileException(courier, req);
        return courierRespMapper.map(courier);
    }
}
