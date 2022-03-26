import java.io.PrintWriter

import scala.io.Source

object FileDemo extends App {
  /*//读取文件
  val source = Source.fromFile("src/filetext.txt")
  //获取文件行迭代器
  val  lines = source.getLines()
  for(line <- lines) println(line)
  //关闭流
  source.close()*/
  /*//读取文件的字符
  val source = Source.fromFile("src/filetext.txt")
  val iter = source.buffered
  var sum = 0

  while(iter.hasNext){
    if(iter.head == 'a'){
      sum += 1
    }
    println(iter.next())
  }

  println("sum ="+sum)
  source.close()*/

  /*//读取网络文件
  val source = Source.fromURL("http://1000phone.com")
  val lines = source.getLines()
  for(line <- lines) println(line)
  source.close()*/

  //写文件
  val out = new PrintWriter("fileresult.txt")
  for(i <- 1 to 100) out.println(i)
  out.close()



}






































