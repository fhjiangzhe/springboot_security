package com.example.repository.elasticsearch;

import com.example.domain.elasticsearch.UserBindElsEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Service;

/**
 * Created by JiangZhe on 16/8/15.
 */
@Service("userBindElsRepository")
public interface UserBindRepository extends ElasticsearchRepository<UserBindElsEntity, Integer> {
}
