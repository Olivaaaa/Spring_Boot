package com.waylau.spring.boot.elasticsearch.domain;
//可序列化接口

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "blog", type = "blog")//文档
public class Blog implements Serializable {

    private static final long serialVersionUID = 1;

    @Id
    private String id;
    private String title;
    private String summary;
    private String content;

    protected Blog() {

    }

    public Blog(String title, String summary, String content) {
        this.title = title;
        this.summary = summary;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return String.format("Blog[id='%s',title='%s',summary='%s',content='%s']", id, title, summary, content);
    }
}
