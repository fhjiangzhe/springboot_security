package com.example.repository;

import com.example.domain.mongo.ImpdataMyMastersMain;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by JiangZhe on 16/8/1.
 */
public interface MasterRepository extends MongoRepository<ImpdataMyMastersMain,String> {
}
