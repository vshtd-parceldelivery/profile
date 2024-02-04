package com.vshtd.parceldelivery.profile.operation;

public interface Operation<REQ, RESP> {

    RESP execute(REQ req);

    RESP process(REQ req);

}
