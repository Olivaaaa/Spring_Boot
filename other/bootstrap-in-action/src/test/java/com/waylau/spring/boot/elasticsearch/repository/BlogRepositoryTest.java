package com.waylau.spring.boot.elasticsearch.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import com.waylau.spring.boot.elasticsearch.domain.Blog;


/**
 * BlogRepository 测试类.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年3月12日
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogRepositoryTest {
    @Autowired
    private BlogRepository blogRepository;

    //测试数据
    @Before
    public void initRRepositoryData() {
        //清除所有数据
        blogRepository.deleteAll();

        blogRepository.save(new Blog("登鹳雀楼", "王之涣的登鹳雀楼", "白日依山尽"));
        blogRepository.save(new Blog("相思", "王维的相思", "红豆生南国"));
        blogRepository.save(new Blog("静夜思", "李白的静夜思", "床前明月光"));

    }

    @Test
    public void testFindDistinctBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "红豆";
        Page<Blog> page = blogRepository.findDistinctBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(2);

        System.out.println("------------");
        for (Blog blog : page.getContent()) {
            System.out.println(blog.toString());
        }
        System.out.println("------------");


    }
}
