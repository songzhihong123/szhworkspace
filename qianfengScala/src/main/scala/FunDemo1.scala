object FunDemo1 extends App {
  val multiply = (x:Int) => {x*5}

  //闭包函数
  var factor = 5
  val multiply2 = (x:Int) => {x*factor}
  println(multiply2(10))
  factor = 10
  println(multiply2(10))
}
