package com.vshtd.parceldelivery.profile.distribution;

import com.vshtd.parceldelivery.profile.model.mqo.CreateProfileMQO;

public interface RmqSender {

    void createProfile(CreateProfileMQO profile);
}
