package org.visiondeveloper.devarticlesite.feature;

import org.visiondeveloper.devarticlesite.domain.Article;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;
import org.visiondeveloper.devarticlesite.domain.UserAccount;
import org.visiondeveloper.devarticlesite.dto.ArticleCommentDto;
import org.visiondeveloper.devarticlesite.dto.ArticleDto;
import org.visiondeveloper.devarticlesite.dto.ArticleWithCommentsDto;
import org.visiondeveloper.devarticlesite.dto.UserAccountDto;

import java.time.LocalDateTime;
import java.util.Set;

public class Feature {

    public static ArticleCommentDto createArticleCommentDto(String content) {
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

    public static UserAccountDto createUserAccountDto() {
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

    public static ArticleComment createArticleComment(String content) {
        return ArticleComment.of(
                Article.of(createUserAccount(), "title", "content", "hashtag"),
                createUserAccount(),
                content
        );
    }

    public static UserAccount createUserAccount() {
        return UserAccount.of(
                "uno",
                "password",
                "uno@email.com",
                "Uno",
                null
        );
    }

    public static Article createArticle() {
        return Article.of(
                createUserAccount(),
                "title",
                "content",
                "#java"
        );
    }

    public static ArticleDto createArticleDto() {
        return createArticleDto("title", "content", "#java");
    }

    public static ArticleDto createArticleDto(String title, String content, String hashtag) {
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

    public static ArticleWithCommentsDto createArticleWithCommentsDto() {
        return ArticleWithCommentsDto.of(
                1L,
                createUserAccountDto(),
                Set.of(),
                "title",
                "content",
                "#java",
                LocalDateTime.now(),
                "uno",
                LocalDateTime.now(),
                "uno"
        );
    }
}
