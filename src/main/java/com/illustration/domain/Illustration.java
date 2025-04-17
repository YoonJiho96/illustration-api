package com.illustration.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "illustration")
public class Illustration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // CharacterInfo와의 연관 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "character_id", nullable = false)
    private CharacterInfo character;

    // Theme과의 연관 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theme_id", nullable = false)
    private Theme theme;

    // IllustrationType과의 연관 관계
    @OneToMany(mappedBy = "illustration", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IllustrationType> illustrationTypes = new ArrayList<>();

    // 추가 필드 예시
    @Column(nullable = false)
    private String imageUrl;

    @Column(length = 500)
    private String description;
}
