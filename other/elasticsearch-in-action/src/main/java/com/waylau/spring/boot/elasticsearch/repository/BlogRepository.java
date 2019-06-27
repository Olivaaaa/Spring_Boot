package com.waylau.spring.boot.elasticsearch.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.waylau.spring.boot.elasticsearch.domain.Blog;

/**
 * Blog 存储库.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年3月12日
 */
public interface BlogRepository extends ElasticsearchRepository<Blog, String> {
    /**
     * 根据用户名分页查询用户列表
     *
     * @param name
     * @param pageable
     * @return
     */
//Distinct是去重，By是条件，contain是包含
    Page<Blog> findDistinctBlogByTitleContainingOrSummaryContainingOrContentContaining(String title, String summary, String content, Pageable pageable);
}
