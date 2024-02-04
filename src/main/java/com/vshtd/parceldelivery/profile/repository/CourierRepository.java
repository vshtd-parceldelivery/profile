package com.vshtd.parceldelivery.profile.repository;

import com.vshtd.parceldelivery.profile.model.entity.Courier;
import com.vshtd.parceldelivery.profile.model.entity.CourierStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CourierRepository extends JpaRepository<Courier, Long> {

    @Query(value = "select case when count(c) > 0 then true else false end from Courier c " +
            "where c.username = :username and c.status <> :deleted")
    boolean exist(@Param(value = "username") String username,
                  @Param(value = "deleted") CourierStatus deleted);

    @Query(value = "select c from Courier c where c.username = :username")
    Courier findByUsername(@Param(value = "username") String usernameS);
}
