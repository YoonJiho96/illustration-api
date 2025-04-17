package com.illustration.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(
        name = "character_alias",
        uniqueConstraints = @UniqueConstraint(columnNames = {"character_id", "alias"})
)
public class CharacterAlias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterInfo character;

    @Column(nullable = false, length = 50)
    private String alias;
}
