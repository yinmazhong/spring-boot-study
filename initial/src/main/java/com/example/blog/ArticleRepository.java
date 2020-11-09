package com.example.blog;

import com.example.blog.po.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Long> {

    public List<Article> findByUserId(Long userId);

    @Query("select art from com.example.blog.bean.Article art where title=:title")
    public List<Article> queryByTitle(@Param("title") String title);
}

