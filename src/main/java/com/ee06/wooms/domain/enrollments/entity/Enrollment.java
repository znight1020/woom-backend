package com.ee06.wooms.domain.enrollments.entity;

import com.ee06.wooms.domain.users.entity.User;
import com.ee06.wooms.domain.wooms.entity.Wooms;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Entity
@Table(name = "wooms_enrollments")
public class Enrollment {
    @EmbeddedId
    private Pk pk;

    @MapsId("userUuid")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_uuid", columnDefinition = "BINARY(16)")
    private User user;

    @MapsId("woomUuid")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wooms_uuid", columnDefinition = "BINARY(16)")
    private Wooms wooms;

    private String userNickname;

    private EnrollmentStatus status;

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    @Getter
    @Embeddable
    public static class Pk implements Serializable {
        @Column(name = "user_uuid", columnDefinition = "BINARY(16)")
        private UUID userUuid;
        @Column(name = "wooms_uuid", columnDefinition = "BINARY(16)")
        private UUID woomUuid;
    }
}
