package org.visiondeveloper.devarticlesite.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article; // Article (ID)
    private String content;

    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime modifiedAt;
    private String modifiedBy;
}
