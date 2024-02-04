package com.vshtd.parceldelivery.profile.action;

import com.vshtd.parceldelivery.profile.repository.CourierRepository;
import com.vshtd.parceldelivery.profile.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseAction<REQ, RESP> implements Action<REQ, RESP> {

    @Autowired
    protected CourierRepository courierRepository;

    @Autowired
    protected UserRepository userRepository;

}

