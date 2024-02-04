package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.entity.Courier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class GetAllCouriersAction extends BaseAction<Pageable, Page<Courier>> {

    @Override
    public Page<Courier> execute(Pageable pageable, Ctx ctx) {
        return courierRepository.findAll(pageable);
    }
}
