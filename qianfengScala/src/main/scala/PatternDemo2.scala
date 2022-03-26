import scala.util.Random

object PatternDemo2 {
  def main(args: Array[String]): Unit = {
    /*//做一个信息的甄别
    abstract class Notification
    //定义不同信息的样例类
    case class Email(sender:String,title:String,body:String) extends Notification
    case class SMS(caller:String,message:String) extends Notification
    case class VoiceRecording(contactName:String,link:String) extends Notification

    //信息的识别
    def showNotification(notification: Notification):String = {
      notification match {
        case Email(sender,title,_) if(sender == "zhangsan") => "you get a Email message from "+sender
        case SMS(caller,message) => "you gte a SMS message from "+caller
        case VoiceRecording(contactName,link) => "you get a VoiceRecording message from "+contactName
        case _=> "you get a message not important"
      }

    }

    //创建一条信息
    val email= Email("zhangsan","important","something")
    println(showNotification(email))
    val email1= Email("lisi","important","something")
    println(showNotification(email1))*/

    //类型匹配
    val arr = Array("bbb",1,2.3,'a')
    //随机取数据中的一个元素
    val obj = arr(Random.nextInt(4))
    println(obj)
    obj match {
      case x:Int => println(x)
      case s:String => println(s.toUpperCase())
      case d:Double =>println(Int.MaxValue)
      case _=> println("fail")
    }



  }
}
