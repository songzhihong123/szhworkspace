abstract class Person {

  //抽象字段，没有初始化值
  var name:String
  //抽象方法
  def id:Int
  //具体方法
  def smile = {
    println("person can smile")
  }
}

class Employ extends Person {
  override var name = "jetty"
  override def id:Int = {
    name.hashCode
  }

  override def smile: Unit = super.smile

}

//特质还是抽象类？












