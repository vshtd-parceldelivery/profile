package com.vshtd.parceldelivery.profile.model.internal;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetProfileInO implements IProfile {

    private String username;
}
