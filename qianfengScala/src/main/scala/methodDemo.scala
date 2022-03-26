object methodDemo extends App {
  //方法的嵌套：方法体里面又定义其他的方法
  //阶乘问题
  def factorial(x:Int):Int = {
    def fact(x: Int, accumulator: Int): Int = {
      if (x <= 1) accumulator
      else fact(x - 1, x * accumulator)
    }
    fact(x,1)
  }

  println(factorial(5))

  //方法的多态：方法可以通过类型实现参数化，类似范型
  def listOfDuplicates[A](x:A,length:Int):List[A] = {
    if(length <1 )
      Nil
    else
      x :: listOfDuplicates(x,length-1)
  }

  println(listOfDuplicates[Int](3,5))
  println(listOfDuplicates[String]("ss",5))



}
