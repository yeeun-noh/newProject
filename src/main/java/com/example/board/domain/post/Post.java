package com.example.board.domain.post;

import com.example.board.domain.BaseEntity;
import com.example.board.domain.member.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {

    @Id
    @Column(name = "POST_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "VIEW_COUNT")
    private int viewCount;

    @Enumerated(EnumType.STRING)
    private PostCategory category; // NOTICE, BOARD

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_ID")
    private Member member;

    @Builder
    public Post(String title, String content, int viewCount, PostCategory category, Member member) {
        this.title = title;
        this.content = content;
        this.viewCount = viewCount;
        this.category = category;
        this.member = member;
    }
}
