package com.vshtd.parceldelivery.profile.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin extends BaseProfile {

    @Builder.Default
    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private AdminStatus status = AdminStatus.ACTIVE;
}
