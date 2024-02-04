package com.vshtd.parceldelivery.profile.model.entity;

import com.vshtd.parceldelivery.profile.model.internal.IProfile;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_info")
public class User extends BaseProfile implements IProfile {

    @Builder.Default
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus status = UserStatus.CREATED;

}
