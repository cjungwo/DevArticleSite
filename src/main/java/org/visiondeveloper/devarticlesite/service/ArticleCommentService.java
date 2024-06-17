package org.visiondeveloper.devarticlesite.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;
import org.visiondeveloper.devarticlesite.dto.ArticleCommentDto;
import org.visiondeveloper.devarticlesite.repository.ArticleCommentRepository;
import org.visiondeveloper.devarticlesite.repository.ArticleRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return articleCommentRepository.findByArticle_Id(articleId)
                .stream()
                .map(ArticleCommentDto::from)
                .toList();
    }

    public void saveArticleComment(ArticleCommentDto dto) {
        try {
            articleCommentRepository.save(dto.toEntity(articleRepository.getReferenceById(dto.articleId())));
        } catch (EntityNotFoundException e) {
            log.warn("Failed Saving Comment. Not found article - dto: {}", dto);
        }
    }

    public void updateArticleComment(ArticleCommentDto dto) {
        try {
            ArticleComment articleComment = articleCommentRepository.getReferenceById(dto.id());
            if (dto.content() != null) { articleComment.setContent(dto.content()); }
        } catch (EntityNotFoundException e) {
            log.warn("Failed updating Comment. Not found article - dto: {}", dto);
        }
    }

    public void deleteArticleComment(Long articleCommentId) {
        articleCommentRepository.deleteById(articleCommentId);
    }
}
