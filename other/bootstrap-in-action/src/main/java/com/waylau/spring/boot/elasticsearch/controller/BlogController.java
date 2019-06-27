package com.waylau.spring.boot.elasticsearch.controller;

import com.waylau.spring.boot.elasticsearch.domain.Blog;
import com.waylau.spring.boot.elasticsearch.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//博客控制器
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public List<Blog> list(@RequestParam(value = "title") String title,
                           @RequestParam(value = "summary") String summary,
                           @RequestParam(value = "content") String content,
                           @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
                           @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        Pageable pageable = new PageRequest(pageIndex, pageSize);
        Page<Blog> page = blogRepository.findDistinctBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);

        return page.getContent();
    }
}
