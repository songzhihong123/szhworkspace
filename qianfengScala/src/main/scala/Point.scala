class Point(val xc:Int,val yc:Int) {
  var x:Int = xc
  var y:Int = yc
  def move(dx:Int,dy:Int) = {
    x = x + dx
    y = y + dy
    //打印移动后的坐标
    println("X:"+x+":Y"+y)
  }

}
/*
* 继承了父类的所有属性和方法
* 如果要重写父类的非抽象方法，要用override
* 重写父类的抽象方法，可以用overrride也可以不用
* final修饰的类、属性、方法不能重写
* */
class Locations(override val xc:Int,override val yc:Int,val zc :Int) extends Point(xc,yc){
    var z:Int = zc
  def move(dx:Int,dy:Int,dz:Int): Unit ={
    x = x + dx
    y = y + dy
    z = z + dz
    //打印移动后的位置坐标
    println("X:"+x+" Y"+y+" Z:"+z)
  }
}

object textClass extends App{
  val obj:Locations = new Locations(5,6,7)
  obj.move(1,2,3)
  val obj1 = new Point(2,3)
  //判断对象是不是属于给定的类
  println(obj.isInstanceOf[Locations])
  //类型的强制转换
  println(obj.asInstanceOf[Point])
  //获取某个类的信息
  println(classOf[Locations])
}















