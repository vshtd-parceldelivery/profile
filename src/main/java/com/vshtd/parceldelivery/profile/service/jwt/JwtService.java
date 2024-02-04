package com.vshtd.parceldelivery.profile.service.jwt;

import io.jsonwebtoken.Claims;

public interface JwtService {

    Claims getClaims(String jwt);

    boolean isValidJwt(String jwt);
}
