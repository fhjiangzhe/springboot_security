package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

/**
 * Created by JiangZhe on 16/5/21.
 */
@NoRepositoryBean
public interface BaseRepository<T,ID extends Serializable>  extends JpaRepository<T,ID>, JpaSpecificationExecutor<T> {
}
