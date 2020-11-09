package com.example.blog;

import com.example.blog.po.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    public Long insertArticle(Article article);

    public void updateArticle(Article article);

    public Article queryById(Long id);

    public List<Article> queryArticlesByPage(@Param("article") Article article, @Param("pageSize") int pageSize,
                                             @Param("offset") int offset);
}
