package com.example.repository.elasticsearch;

import com.example.domain.elasticsearch.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Created by JiangZhe on 16/8/15.
 */
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
}
