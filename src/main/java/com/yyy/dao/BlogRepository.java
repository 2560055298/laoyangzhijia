package com.yyy.dao;

import com.yyy.pojo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
    @Query("select b from Blog b")
    List<Blog> findTop(Pageable pageable);

    @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
    Page<Blog> findTop(String query, Pageable pageable);

    @Transactional
    @Modifying
    @Query("update Blog set views = views + 1 where id = ?1")
    int updateViewsById(Long id);


}
