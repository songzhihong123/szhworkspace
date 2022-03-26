object ImplicitDemo3 {
  def main(args: Array[String]): Unit = {
    //特质带有一个抽象方法
    trait Adder[T]{
      def add(x:T,y:T):T
    }

    //创建一个隐式的对象
    implicit val a = new Adder[Int] {
      override def add(x: Int, y: Int): Int = x + y
    }
    //带有隐式参数的方法
    def addText(x:Int,y:Int)(implicit adder:Adder[Int])={
      adder.add(x,y)
    }

    //把隐式对象赋给了这个隐式方法
    println(addText(1,2))
    println(addText(1,2)(a))



  }
}
