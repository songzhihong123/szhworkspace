/*class ConstrucrorDemo {
  var a:Int = 0;
  println("Contruvror Study")
  //定义辅助构造函数
  def this(a1:Int){
    //首先要调用主构造函数或者其他的辅助构造函数
    this()
    this.a = a1
  }

}*/
//定义一个带有参数的主构造函数
/*class ConstrucrorDemo(var b:Int) {
  var a:Int = b;
  println("Contruvror Study")

}*/
class ConstrucrorDemo(b:Int) {
  var a:Int = b
  println("Contruvror Study")
//  定义个辅助构造函数
  def this(a1:Int,b1:Int){
    this(b1)
    this.a = a1
  }

}

//定义一个私有的主构造函数
/*class ConstrucrorDemo private (b:Int) {
  var a:Int = b
  println("Contruvror Study")
  //  定义个辅助构造函数
  def this(a1:Int,b1:Int){
    this(b1)
    this.a = a1
  }

}*/


//类默认有一个无参的构造函数
//主构造函数会会执行类中定义的所有语句
//主构造函数和辅助构造函数

object ConstrucrorText{
  def main(args: Array[String]): Unit = {
//    val obj:ConstrucrorDemo = new ConstrucrorDemo()
val obj:ConstrucrorDemo = new ConstrucrorDemo(123)
    println(obj.a)
  }

}

