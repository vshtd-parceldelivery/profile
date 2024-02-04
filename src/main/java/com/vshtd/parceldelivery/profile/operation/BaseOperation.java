package com.vshtd.parceldelivery.profile.operation;

import com.vshtd.parceldelivery.profile.model.ctx.Ctx;
import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import lombok.Getter;

import java.util.Objects;


@Getter
public abstract class BaseOperation<REQ, RESP> implements Operation<REQ, RESP> {

    private Ctx ctx = Ctx.builder().build();

    protected void preOperation(REQ req) {
    }

    protected void postOperation(REQ req) {
    }

    @Override
    public RESP process(REQ req) {
        preOperation(req);
        RESP resp = execute(req);
        postOperation(req);
        return resp;
    }

    protected void checkNoProfileException(IProfile profile, IProfile req) {
        if (Objects.isNull(profile)) {
            throw new RuntimeException("Such profile does not exist " + req.getUsername());
        }
    }
}
