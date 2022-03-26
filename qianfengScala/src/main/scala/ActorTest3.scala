import scala.actors.{Actor, Future}
import scala.collection.mutable.ListBuffer
import scala.io.Source

//统计文本中单词出现的次数
//首先统计每个文本中各个单词出现的频率
case class SubmitTask(f:String)
case object StopTask
//统计一个文本中单词出现的频率

class ActorTest3 extends Actor{

  override def act(): Unit = {
    while(true){
      receive{
        case SubmitTask(r) => {
          //把文件的一行内容作为一个元素存入List
          val lines = Source.fromFile(r).getLines().toList
          //文件中的每个单词作为一个新的元素存入List
          val words = lines.flatMap(_.split(" "))
          println(words)
          //得到一个一个的map，当前文本中的单词和想要单词出现的次数
          val result = words.map((_,1)).groupBy(_._1).mapValues(_.size)
         /* val res1 = words.map((_,1))
          println("------")
          println(res1)
          println("------")
          val res2 = res1.groupBy(_._1)
          println("*******")
          println(res2)
          println("*******")*/
          println(result)
          sender ! result
        }
        case StopTask => exit()
      }
    }
  }
}

object ActorTest3{
  def main(args: Array[String]): Unit = {
    //把要分析的任务提交给actor
    val replys = new ListBuffer[Future[Any]]
    val results = new ListBuffer[Map[String,Int]]
    val files = Array("D:\\Spring Boot workplace\\qianfengScala\\wordcount1.txt","D:\\Spring Boot workplace\\qianfengScala\\wordcount2.txt")
    for(i <- files){
      val actor = new ActorTest3
      actor.start()
      val reply = actor !! SubmitTask(i)
      //把处理结果统一放到replys
      replys += reply
    }
    //对多个文件的处理结果进行汇总
    while(replys.size > 0){
      //判断结果是否可取
      val done= replys.filter(_.isSet)
      for(res <- done){
        results += res.apply().asInstanceOf[Map[String,Int]]
        replys -= res
      }
      Thread.sleep(5000)
    }
    //对各个分析结果进行最后的汇总
    val res2 = results.flatten.groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
    println(res2)

  }
}





