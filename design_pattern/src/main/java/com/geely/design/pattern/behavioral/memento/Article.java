package com.geely.design.pattern.behavioral.memento;

/**
 * Created by Zhihong Song on 2021/1/14 20:45
 */

public class Article {

    private String title;
    private String context;
    private String imgs;

    public Article(String title, String context, String imgs) {
        this.title = title;
        this.context = context;
        this.imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public ArticleMemento saveToMemento(){
        ArticleMemento articleMemento = new ArticleMemento(this.title,this.context,this.imgs);
        return articleMemento;
    }

    public void undoFormMemento(ArticleMemento articleMemento){
        this.title = articleMemento.getTitle();
        this.context = articleMemento.getContext();
        this.imgs = articleMemento.getImgs();

    }


    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }
}
