class PersonS {
  //val修饰的属性系统会自动生产get方法，
  val id:String = "1234";

  def getId():String = {
    println("**************")
    this.id
  }
  // var修饰的属性，系统会自动生产get/set方法
  var name:String = "tom";
  //private var修饰的属性，系统会自动的生成private修饰的get/set方法
  //相当于类的私有字段
  private var gender:Int = 0;
  //private[this] 修饰的属性，系统不会生成get/set方法
  //只有当前对象可以访问该属性
  private[this] var age:Int = 0;

//  def compare(obj:PersonS):Int = {
//    this.age = obj.age
//  }

}


object test{
  def main(args: Array[String]): Unit = {
    var per:PersonS = new PersonS()
//    println(per.id)
    println(per.getId())
    per.name = "zhansgan"
    println(per.name)
  }
}

