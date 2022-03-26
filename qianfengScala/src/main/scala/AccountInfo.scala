class AccountInfo {
  var id = AccountInfo.newUniqueNumber

}
/*
* 这个单例对象可以称为类的伴生对象
* 而这个类也可以称为这个对象的伴生类
* 伴生对象和类可以互相访问彼此的私有属性或者方法
* */
object AccountInfo{
  private var lastNumber = 0
  private def newUniqueNumber={
    lastNumber += 1
    lastNumber
  }
}

/*object text{
  def main(args: Array[String]): Unit = {
    val obj:AccountInfo = new AccountInfo
    println(obj.id)
  }
}*/

//应用程序对象
object text extends App{
  val obj:AccountInfo = new AccountInfo
  println(obj.id)
}


