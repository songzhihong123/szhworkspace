package com.atguigu.elastic;

import com.atguigu.elastic.bean.Article;
import com.atguigu.elastic.bean.Book;
import com.atguigu.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02(){
//        Book book = new Book();
//        book.setId(1);
//        book.setName("西游记");
//        book.setAuthor("吴承恩");
//        bookRepository.index(book);
        List<Book> books = bookRepository.findBookByNameLike("游");
        for (Book book: books
             ) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        //1、给ES中索引一个文档
        Article article = new Article(1, "好消息", "张三", "Hello World");

        //构建一个索引
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            //执行
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //测试搜索
    @Test
    public void search(){
        //查询表达式
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索功能
        Search search = new Search.Builder(json).addType("atguigu").addType("news").build();
        try {
            SearchResult execute = jestClient.execute(search);
            System.out.println(execute.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
