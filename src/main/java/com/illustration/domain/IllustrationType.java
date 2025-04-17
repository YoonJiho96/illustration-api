package com.illustration.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "illustration_type")
public class IllustrationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "illustration_id", nullable = false)
    private Illustration illustration;

    @ManyToOne
    @JoinColumn(name = "type_info_id", nullable = false)
    private IllustrationTypeInfo typeInfo;
}
