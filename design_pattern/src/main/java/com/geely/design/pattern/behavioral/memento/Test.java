package com.geely.design.pattern.behavioral.memento;

/**
 * Created by Zhihong Song on 2021/1/14 20:56
 * 备忘录模式
 */

public class Test {

    public static void main(String[] args) {

        ArticleMementoManager articleMementoManager = new ArticleMementoManager();

        Article article = new Article("设计模式A","手记内容A","手记图片A");

        ArticleMemento articleMemento = article.saveToMemento();
        articleMementoManager.addMemento(articleMemento);

        System.out.println("标题："+articleMemento.getTitle()+" 内容：" + articleMemento.getContext()+" 图片：" + articleMemento.getTitle()+" 已经存档");
        System.out.println("手记完整信息：" + article);

        System.out.println("修改手记start");
        article.setTitle("设计模式B");
        article.setContext("手记内容B");
        article.setImgs("手记图片B");
        System.out.println("修改手记end");
        System.out.println("手记完整信息：" + article);

        articleMementoManager.addMemento(article.saveToMemento());

        article.setTitle("设计模式C");
        article.setContext("手记内容C");
        article.setImgs("手记图片C");

        System.out.println("暂存回退start");
        System.out.println("回退出栈1次");

        articleMemento = articleMementoManager.getMemento();
        article.undoFormMemento(articleMemento);

        System.out.println("回退出栈2次");

        articleMemento = articleMementoManager.getMemento();
        article.undoFormMemento(articleMemento);

        System.out.println("暂存回退end");
        System.out.println("手记完整信息：" + article);



    }

}
