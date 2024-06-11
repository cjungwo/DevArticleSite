package org.visiondeveloper.devarticlesite.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.visiondeveloper.devarticlesite.domain.Article;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;
import org.visiondeveloper.devarticlesite.dto.ArticleCommentDto;
import org.visiondeveloper.devarticlesite.repository.ArticleCommentRepository;
import org.visiondeveloper.devarticlesite.repository.ArticleRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("Business Logic - ArticleComment")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService sut;

    @Mock
    private ArticleRepository articleRepository;
    @Mock
    private ArticleCommentRepository articleCommentRepository;

    @DisplayName("Search ArticleComments")
    @Test
    void givenArticleId_whenSearchingArticleComments_thenReturnsArticleComments() {
        // Given
        Long articleId = 1L;
        given(articleRepository.findById(articleId)).willReturn(Optional.of(Article.of("title", "content", "#java")));

        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComment(articleId);

        // Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("Create ArticleComments")
    @Test
    void givenArticleCommentInfo_whenSavingArticleComment_thenSavesArticleComment() {
        // Given
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.saveArticleComment(ArticleCommentDto.of(LocalDateTime.now(), "cjungwo", LocalDateTime.now(), "cjungwo", "content"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("Update ArticleComments")
    @Test
    void givenArticleCommentIdAndInfo_whenUpdatingArticleComment_thenUpdatesArticleComment() {
        // Given
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.updateArticleComment(1L, ArticleCommentDto.of(LocalDateTime.now(), "cjungwo", LocalDateTime.now(), "cjungwo", "content"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("Delete ArticleComments")
    @Test
    void givenArticleCommentId_whenDeletingArticleComment_thenDeletesArticleComment() {
        // Given
        willDoNothing().given(articleCommentRepository).delete(any(ArticleComment.class));

        // When
        sut.deleteArticleComment(1L);

        // Then
        then(articleCommentRepository).should().delete(any(ArticleComment.class));
    }

}