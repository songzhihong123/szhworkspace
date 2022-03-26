package com.geely.design.pattern.behavioral.memento;

import java.util.Stack;

/**
 * Created by Zhihong Song on 2021/1/14 20:53
 */

public class ArticleMementoManager {

    private final Stack<ArticleMemento> ARTICLE_MEMENTO_STACK = new Stack<>();

    public ArticleMemento getMemento(){
        return ARTICLE_MEMENTO_STACK.pop();
    }

    public void addMemento(ArticleMemento articleMemento){
        ARTICLE_MEMENTO_STACK.push(articleMemento);
    }

}
