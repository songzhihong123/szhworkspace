


object CaseclassDemo {
  def main(args: Array[String]): Unit = {
    //定义一个样例类
    //样例类一定以就自带有apply方法
    //构造函数的参数默认public val修饰的
    case class Message(send:String,recipient:String,bpdy:String)

    //创建一个样例类对象
    val message1 =  Message("Jetty","tom","hello")
    println(message1.send)
//    message1.send = "like"
    //样例类的比较， 基于值或者结构的比较，而不是基于引用比较
    val message2 =  Message("Jetty","tom","hello")
    //true
    if(message1 == message2) println("same") else println("differernt")

    //样例类的拷贝
    val message3 = message1.copy()
    println(message3.send,message3.recipient,message3.bpdy)
    if(message1 == message3) println(true) else println(false)

    //不完全拷贝，部分参数赋值

    val message4 = message1.copy(send = "hanmeiemi")
    println(message4)



  }
}







