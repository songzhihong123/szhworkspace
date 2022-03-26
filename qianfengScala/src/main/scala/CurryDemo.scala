object CurryDemo extends App{
//创建一个普通的方法
  def add(x:Int,y:Int) = {x + y}
  println(add(1,2))
//柯里化后的方法
  def curryadd(x:Int)(y:Int) = x+ y
  println(curryadd(1)(2))

  //模拟柯里化的实现过程
  def first(x:Int):Int =>Int = (y:Int) => x + y
  val second = first(1)
  val res = second(2)
  println(res)

  val one = curryadd(1)_
  println(one(2))
  val two = curryadd(2)_
  println(two(3))

  val list = Array(1,2,3,4)
  val res1 = list.foldLeft(0)(_+_)
  println(res1)

}
