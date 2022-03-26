trait Logger2{
  def log2(msg:String)
  def info(msg:String){log2("INFO:"+msg)}
  def server(msg:String){log2("SEVERE:"+msg)}
  def warn(msg:String){log2("WARN:"+msg)}
}

class Account2{
  protected var banlance:Double = 150
}

class SaveAccount2 extends Account2 with Logger2{
  override def log2(msg: String): Unit = println(msg)
  def withdraw2(amount:Double): Unit ={
    if(amount > banlance) server("钱不够了..") else{
      banlance = banlance - amount
      info("取钱成功...")
    }

  }
}


object TraitText3 {
  def main(args: Array[String]): Unit = {
  val acc = new SaveAccount2
    acc.withdraw2(100)
  }
}
