package org.visiondeveloper.devarticlesite.repository.querydsl;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.visiondeveloper.devarticlesite.domain.Article;
import org.visiondeveloper.devarticlesite.domain.QArticle;

import java.util.List;

public class CustomArticleRepositoryImpl extends QuerydslRepositorySupport implements CustomArticleRepository {

    public CustomArticleRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<String> findAllDistinctHashtags() {
        QArticle article = QArticle.article;

        return from(article)
                .distinct()
                .select(article.hashtag)
                .where(article.hashtag.isNotNull())
                .fetch();

    }
}
