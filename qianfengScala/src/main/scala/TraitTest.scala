//定义个带有抽象方法的特质
trait Iterator[A] {
  def hasNext:Boolean
  def next():A
}
//定义一个带有实现的特质
trait ConsoleLogger{
  def log(mes:String)={
    println(mes)
  }
}


//定义一个类实现这个特质
class IntInerator(to:Int) extends Iterator[Int] with ConsoleLogger {
  private var current = 0
  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext){
      log("has Next")
      val t = current
      current  += 1
      t
    }else 0
  }
}





object TraitTest{
  def main(args: Array[String]): Unit = {
    val obj:IntInerator = new IntInerator(10)
    println(obj.next())
    println(obj.next())
    println(obj.next())
  }
}




