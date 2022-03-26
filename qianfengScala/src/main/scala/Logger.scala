/*
* 单例对象
* 可以充当工具类，可以定义一些工具函数和常量
* 单例对象不能带参数
* 第一次调用的时候初始化
* */
object Logger {
  //相当于java中的静态方法
  def log(mes:String):Unit = {
    println(s"INFO:$mes")
  }
}

class Test{
  def method():Unit={
    Logger.log("hello,zhi")
  }
}

object LoggerText{
  def main(args: Array[String]): Unit = {
    Logger.log("hello,song")
    val obj:Test = new Test
    obj.method()
  }
}





