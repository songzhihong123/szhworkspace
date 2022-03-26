object ImplicitDemo2 extends App {
  var a:Int = 10;
  var b:Double = 100.99
  b = 100
  b = a
  //自己定义一个隐式转换函数，Double -> Int
  implicit def doubleToInt(x:Double) = x.toInt

  //编译器系统会在某些情况下查看当前作用域内有没有合适的隐式转换
  //可以编译通过了
  a = b
  a = 10.00
  println(a)



}
