trait Logger1{
  def log(msg:String)
}
//子特质实现父特质里的抽象方法
trait ConsoleLogger1 extends Logger1{
  override def log(mes: String): Unit = println(mes)
}
//给日志加上时间戳
trait TimestapLogger extends ConsoleLogger1{
  override def log(mes: String): Unit = super.log(s"${java.time.Instant.now()}$mes")
}
//如果日志过长。对日志进行截断显示
trait ShortLogger extends ConsoleLogger1{
  var maxLength = 15
  override def log(mes: String): Unit = super.log(
    if(mes.length <= maxLength) mes
    else s"${mes.substring(0,maxLength-3)}..."
  )
}
class Account{
  protected var banlance:Double = 0.0
}

class SaveAccount extends Account with ConsoleLogger1 {
  def withdraw(amount:Double) ={
    if(amount > banlance) log("Insufficent funds")
    else banlance = banlance - amount
  }
}
//特质可以为我们的类提供可以堆叠的改变
object TraitTest2  {
  def main(args: Array[String]): Unit = {
//    var acc1 = new SaveAccount with ConsoleLogger1 with TimestapLogger with ShortLogger
//    var acc2 = new SaveAccount with ConsoleLogger1 with ShortLogger with TimestapLogger
//      acc1.withdraw(100)
//      acc2.withdraw(100)

    var acc1 = new SaveAccount with ConsoleLogger1
    acc1.withdraw(100)
    var acc2 = new SaveAccount with ConsoleLogger1 with TimestapLogger
    acc2.withdraw(100)
    var acc3 = new SaveAccount with ConsoleLogger1 with ShortLogger
    acc3.withdraw(100)




  }


}
