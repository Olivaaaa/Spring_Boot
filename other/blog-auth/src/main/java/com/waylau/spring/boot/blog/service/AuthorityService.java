package com.waylau.spring.boot.blog.service;

import com.waylau.spring.boot.blog.domain.Authority;

/**
 * Authority 服务接口.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年3月18日
 */
public interface AuthorityService {


    /**
     * 根据id获取 Authority
     *
     * @param Authority
     * @return
     */
    Authority getAuthorityById(Long id);
}
