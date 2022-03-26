import scala.actors.Actor

//定义样例类，封装我们发送的消息内容以及接受的消息内容
case class SyncMsg(id:Int,msg:String)
case class AsyncMsg(id:Int,msg:String)
case class ReplyMsg(id:Int,msg:String)

//定义一个actor 去处理同步和异步消息

class SecondActor extends Actor{
  override def act(): Unit = {
    while(true){
      receive{
        //处理同步消息
        case SyncMsg(id,msg) => {
          println(id+" sync "+msg)
          Thread.sleep(5000)
          sender ! ReplyMsg(8,"finished")
        }
        //处理异步消息
        case AsyncMsg(id,msg) => {
          println(id+" async "+msg)
          Thread.sleep(5000)
          sender ! ReplyMsg(9,"finished")
        }
      }
    }
  }
}




object ActorTest2 {
  def main(args: Array[String]): Unit = {
    val actor = new SecondActor
    actor.start()
    //发送一个异步无返回值消息,不阻塞
//   val reply1 =  actor ! AsyncMsg(1,"hello,actor")
//    println(reply1)

    //发送一个同步消息 阻塞，等消息发回来之后才会往下执行
//    val reply = actor !? SyncMsg(2,"HELLO,ACTOR!")
//    println("同步消息发送完成")
//    println(reply)

    //发送一个异步带有返回值的消息
    val reply3 = actor !! AsyncMsg(3,"Hello,hello")
    println("异步消息发送完成")
    //监测返回结果是否可用
    println(reply3.isSet)
    //会阻塞 ，因为结果如果不出来的话会一直等待
    val res = reply3()
    println(reply3.isSet)
    println(res)



  }
}
