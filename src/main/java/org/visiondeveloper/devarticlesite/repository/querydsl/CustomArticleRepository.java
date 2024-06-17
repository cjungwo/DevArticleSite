package org.visiondeveloper.devarticlesite.repository.querydsl;

import java.util.List;

public interface CustomArticleRepository {
    List<String> findAllDistinctHashtags();
}
