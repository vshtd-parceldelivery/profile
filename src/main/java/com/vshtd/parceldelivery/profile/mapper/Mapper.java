package com.vshtd.parceldelivery.profile.mapper;

public interface Mapper<FROM, TO> {

    TO map(FROM value);
}
