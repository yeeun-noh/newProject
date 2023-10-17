package com.example.board.domain.comment;

import com.example.board.domain.BaseEntity;
import com.example.board.domain.member.Member;
import com.example.board.domain.post.Post;
import lombok.*;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

    @Id
    @Column(name = "COM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "password")
    private String password;

    @ManyToOne(fetch = FetchType.LAZY) //N:1
    @JoinColumn(name = "COM_PARENT_ID")
    private Comment parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY) //1:N
    private List<Comment> child = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEM_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public Comment(Long id, String content, String password, Comment parent, Member member, Post post) {
        this.id = id;
        this.content = content;
        this.password = password;
        this.parent = parent;
        this.member = member;
        this.post = post;
    }
}
