package org.visiondeveloper.devarticlesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visiondeveloper.devarticlesite.domain.ArticleComment;

public interface ArticleCommentRepository extends JpaRepository<ArticleComment, Long> {
}