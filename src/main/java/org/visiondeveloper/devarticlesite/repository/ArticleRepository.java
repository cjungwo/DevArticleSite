package org.visiondeveloper.devarticlesite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.visiondeveloper.devarticlesite.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}