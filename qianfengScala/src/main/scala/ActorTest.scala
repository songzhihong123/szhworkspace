import scala.actors.Actor

/*//类似于java中的Thread
class FirstActor extends Actor{
  //相当于java中的run()
  override def act(): Unit = {
    while(true){
      receive{
        case "start" =>{
          println("starting")
          Thread.sleep(1000)
          println("started")
        }
        case "stop" =>{
          println("stopping")
          Thread.sleep(1000)
          println("stopped")
        }
      }
    }
  }
}*/

//使用react，使用react更高效，可以实现线程的重复利用，类似于java中的线程池
class FirstActor extends Actor{
  //相当于java中的run()
  override def act(): Unit = {
    loop{
      react{
        case "start" =>{
          println("starting")
          Thread.sleep(1000)
          println("started")
        }
        case "stop" =>{
          println("stopping")
          Thread.sleep(1000)
          println("stopped")
        }
      }
    }
  }
}


object ActorTest{
  def main(args: Array[String]): Unit = {
    //构建一个actor对象
    val actor = new FirstActor
    //启动actor
    actor.start()
    //给actor发送消息
    // !发送异步消息，没有返回值
    // !? 发送的同步消息，一直阻塞，等待返回值
    // !! 发送异步消息，有返回值Fuyure{Any}
    for(i <- 1 to 3){
      actor ! "start"
      actor ! "stop"
    }



  }

}
