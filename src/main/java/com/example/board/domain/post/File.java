package com.example.board.domain.post;

import com.example.board.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File extends BaseTimeEntity {

    @Id
    @Column(name = "FILE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UPLOAD_FILE_NAME")
    private String uploadFileName;

    @Column(name = "STORE_FILE_NAME")
    private String storeFileName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @Builder
    public File(String uploadFileName, String storeFileName, Post post) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
        this.post = post;
    }
}
