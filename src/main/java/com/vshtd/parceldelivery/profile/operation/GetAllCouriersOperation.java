package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.action.GetAllCouriersAction;
import com.vshtd.parceldelivery.profile.mapper.CourierRespMapper;
import com.vshtd.parceldelivery.profile.model.dto.CourierRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GetAllCouriersOperation extends BaseOperation<Pageable, Page<CourierRespDTO>> {

    @Autowired
    private GetAllCouriersAction getAllCouriers;

    @Autowired
    private CourierRespMapper courierRespMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<CourierRespDTO> execute(Pageable pageable) {
        return getAllCouriers.execute(pageable, getCtx())
                .map(courier -> courierRespMapper.map(courier));
    }
}
