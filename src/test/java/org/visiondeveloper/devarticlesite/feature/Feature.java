package org.visiondeveloper.devarticlesite.feature;

import org.visiondeveloper.devarticlesite.domain.Article;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;
import org.visiondeveloper.devarticlesite.domain.UserAccount;
import org.visiondeveloper.devarticlesite.dto.ArticleCommentDto;
import org.visiondeveloper.devarticlesite.dto.ArticleDto;
import org.visiondeveloper.devarticlesite.dto.UserAccountDto;

import java.time.LocalDateTime;

public class Feature {

    public ArticleCommentDto createArticleCommentDto(String content) {
        return ArticleCommentDto.of(
                1L,
                1L,
                createUserAccountDto(),
                content,
                LocalDateTime.now(),
                "uno",
                LocalDateTime.now(),
                "uno"
        );
    }

    public UserAccountDto createUserAccountDto() {
        return UserAccountDto.of(
                1L,
                "uno",
                "password",
                "uno@mail.com",
                "Uno",
                "This is memo",
                LocalDateTime.now(),
                "uno",
                LocalDateTime.now(),
                "uno"
        );
    }

    public ArticleComment createArticleComment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content", "hashtag"),
                createUserAccount(),
                content
        );
    }

    public UserAccount createUserAccount() {
        return UserAccount.of(
                "uno",
                "password",
                "uno@email.com",
                "Uno",
                null
        );
    }

    public Article createArticle() {
        return Article.of(
                createUserAccount(),
                "title",
                "content",
                "#java"
        );
    }

    public ArticleDto createArticleDto() {
        return createArticleDto("title", "content", "#java");
    }

    public ArticleDto createArticleDto(String title, String content, String hashtag) {
        return ArticleDto.of(1L,
                createUserAccountDto(),
                title,
                content,
                hashtag,
                LocalDateTime.now(),
                "Uno",
                LocalDateTime.now(),
                "Uno");
    }

}
