package com.yyy.dao;

import com.yyy.pojo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 分类：持久层
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
    Type findByName(String name);
}
