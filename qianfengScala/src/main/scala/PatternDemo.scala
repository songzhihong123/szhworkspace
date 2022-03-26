object PatternDemo {
  def main(args: Array[String]): Unit = {
    //常量模式匹配
    //常量字面值的匹配
    val site = "qianfeng.com"

    site match {
      case "qianfeng1.com" => println("success")
        //相当于java中的default，不需要break
      case _ => println("fail")
    }
    //常量变量的匹配 一定要用大写
    val QIANFENG = "qianfeng.com"
    val qianfeng = "qian.com"//不能用小写表示
    site match {
      case QIANFENG => println("success")
      //相当于java中的default，不需要break
      case _ => println("fail")
    }
  //变量模式的匹配
  //对变量进行的重新的赋值
    // val QIANFENG = "qianfeng.com"
    val qianfeng1 = "qian.com"//不能用小写表示
    site match {
      case qianfeng1 => println(qianfeng1 +"success")
      //相当于java中的default，不需要break
      case _ => println("fail")
    }

  //通配符模式的匹配 下划线表示通配符

    val list = List(1,2,3)
    list match {
      case List(_,_,3) => println("success3")
      case _ => println("fail3")
    }



  }
}
