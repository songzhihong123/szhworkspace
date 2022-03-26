class User(val name:String,val password:String) {

}


object User{
  def apply(name:String,password:String): User = new User(name,password)

//  def apply(val name: String,val password: String): User = new User(val name,val password)
  
  def unapply(arg: User): Option[(String, String)] = {
    if(arg == null) None else {Some(arg.name,arg.password)}
  }
}


object userTest{
  def main(args: Array[String]): Unit = {
//    val obj:User = new User("zhangsan","123456")
    val obj = User("zhanshan","123456")
    println("result:"+obj.isInstanceOf[User])
//    val list = Array(1,2,3,4)
    obj match {
      case User(name,password) => println(name+":"+password)
      case _ => println("None")
    }

  }

}



