package com.vshtd.parceldelivery.profile.repository;

import com.vshtd.parceldelivery.profile.model.entity.User;
import com.vshtd.parceldelivery.profile.model.entity.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select case when count(u) > 0 then true else false end from User u " +
            "where u.username = :username and u.status <> :deleted")
    boolean exist(@Param(value = "username") String username,
                  @Param(value = "deleted") UserStatus deleted);

    @Query(value = "select u from User u where u.username = :username")
    User findByUsername(@Param(value = "username") String username);

}
