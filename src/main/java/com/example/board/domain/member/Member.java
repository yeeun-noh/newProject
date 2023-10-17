package com.example.board.domain.member;

import com.example.board.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@ToString
@Table(name = "MEMBER")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 PROTECTED 생성
public class Member extends BaseTimeEntity {

    @Id
    @Column(name = "MEM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ID", length = 100, unique = true, nullable = false)
    private String loginId;

    @Column(name = "PW", nullable = false)
    private String password;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", length = 20, nullable = false)
    private MemberRole role; // ADMIN, MANAGER, USER

    @Builder
    public Member(String loginId, String password, String name, MemberRole role) {
        this.loginId = loginId;
        this.password = password;
        this.name = name;
        this.role = role;
    }
}
