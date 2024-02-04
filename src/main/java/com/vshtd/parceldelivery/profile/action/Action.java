package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;

public interface Action<REQ, RESP> {

    RESP execute(REQ req, Ctx ctx);

}
