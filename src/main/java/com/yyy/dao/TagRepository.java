package com.yyy.dao;

import com.yyy.pojo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 标签：持久层
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
    Tag findByName(String name);
}
