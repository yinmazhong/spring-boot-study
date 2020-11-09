package com.example.blog;

import com.example.blog.Dao.ArticleDao;
import com.example.blog.po.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Aplication.class)
public class ArticleDaoTest {
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleMapper mapper;

    @Test
    public void testInsert(){
        Article article = new Article();
        article.setTitle("测试标题");
        article.setSummary("测试摘要");
        article.setUserId(1L);
        article.setStatus(1);
        article.setType(1);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setPublicTime(new Date());
        articleDao.insertArticle(article);
    }

    @Test
    public void testQuery(){
        List<Article> articleList  = articleRepository.queryByTitle("测试标题");
        assertTrue(articleList.size()>0);
    }

    @Test
    public void testMybatisInsert(){
        Article article = new Article();
        article.setTitle("测试标题2");
        article.setSummary("测试摘要2");
        article.setUserId(10L);
        article.setStatus(1);
        article.setCreateTime(new Date());
        article.setUpdateTime(new Date());
        article.setPublicTime(new Date());
        mapper.insertArticle(article);
    }

    @Test
    public void testMybatisQuery(){
        Article article = mapper.queryById(10L);
        assertNotNull(article);
    }

    @Test
    public void testUpdate() {
        Article article = mapper.queryById(1L);
        article.setPublicTime(new Date());
        article.setUpdateTime(new Date());
        article.setStatus(2);
        mapper.updateArticle(article);
    }

    @Test
    public void testQueryByPage(){
        Article article = new Article();
        article.setUserId(1L);
        List<Article> list = mapper.queryArticlesByPage(article,10,0);
        assertTrue(list.size()>0);
    }
}
