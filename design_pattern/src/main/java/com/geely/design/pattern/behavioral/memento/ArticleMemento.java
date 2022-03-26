package com.geely.design.pattern.behavioral.memento;

/**
 * Created by Zhihong Song on 2021/1/14 20:47
 */

public class ArticleMemento {

    private String title;
    private String context;
    private String imgs;

    public ArticleMemento(String title, String context, String imgs) {
        this.title = title;
        this.context = context;
        this.imgs = imgs;
    }
    public String getTitle() {
        return title;
    }
    public String getContext() {
        return context;
    }

    public String getImgs() {
        return imgs;
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
