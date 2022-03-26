object HFunDemo extends App {
  //传入参数是函数
  val arr = Array(1,2,3,4,5)
  val fun = (x:Int) => x*2
  val res = arr.map(fun)
  println(res.toBuffer)
  //传入匿名函数
  val res1 = arr.map((x:Int) => x*2)
  val res2 = arr.map(_*2)

  //返回值是函数
  def urlBuilder(ssl:Boolean,domianName:String):(String,String) => String ={
  val schema = if(ssl) "https://" else "http://"
    (endpoint:String,query:String)=>s"$schema$domianName/$endpoint?$query"
  }
  val domainName = "www.1000phone.com"
  def getUrl:(String,String) => String = urlBuilder(true,domainName)
  val endpoint = "users"
  val query = "id=1"
  val res3 = getUrl(endpoint,query)
  println(res3)


}
