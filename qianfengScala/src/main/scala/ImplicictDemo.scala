//隐式引用
import java.io.File
import java.lang

import scala._
import scala.Predef._
import scala.io.Source


object ImplicictDemo extends App{
  val a:Int = 1
  println(a)

  val map = Map("a"->1)
  println(map.get("a"))
  val aa = 1 to 10
  val aaa = 1.to(10)

  //定义一个隐式类，可以把FIle转换成定义的隐式类
  implicit class RichFile(from:File){
    def read:String = Source.fromFile(from.getPath()).mkString
  }


  //使用隐式类做一个已有类功能的扩展
  val xcontents = new File("src/filetext.txt").read
  println(xcontents)



}
