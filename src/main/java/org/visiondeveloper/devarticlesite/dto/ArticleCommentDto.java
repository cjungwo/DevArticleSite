package org.visiondeveloper.devarticlesite.dto;

import org.visiondeveloper.devarticlesite.domain.Article;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;
import org.visiondeveloper.devarticlesite.domain.UserAccount;

import java.time.LocalDateTime;

/**
 * DTO for {@link org.visiondeveloper.devarticlesite.domain.ArticleComment}
 */
public record ArticleCommentDto(
        Long id,
        Long articleId,
        UserAccountDto userAccountDto,
        String content,
        LocalDateTime createdAt,
        String createdBy,
        LocalDateTime modifiedAt,
        String modifiedBy
) {

  public static ArticleCommentDto of(Long articleId, UserAccountDto userAccountDto, String content) {
    return ArticleCommentDto.of(null, articleId, userAccountDto, content, null, null, null, null);
  }

  public static ArticleCommentDto of(Long id, Long articleId, UserAccountDto userAccountDto, String content, LocalDateTime createdAt, String createdBy, LocalDateTime modifiedAt, String modifiedBy) {
    return new ArticleCommentDto(id, articleId, userAccountDto, content, createdAt, createdBy, modifiedAt, modifiedBy);
  }

  public static ArticleCommentDto from(ArticleComment entity) {
    return new ArticleCommentDto(
            entity.getId(),
            entity.getArticle().getId(),
            UserAccountDto.from(entity.getUserAccount()),
            entity.getContent(),
            entity.getCreatedAt(),
            entity.getCreatedBy(),
            entity.getModifiedAt(),
            entity.getModifiedBy()
    );
  }

  public ArticleComment toEntity(Article article, UserAccount userAccount) {
    return ArticleComment.of(
            article,
            userAccount,
            content
    );
  }

}
