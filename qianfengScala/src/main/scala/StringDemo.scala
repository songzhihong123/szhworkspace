object StringDemo {
  def main(args: Array[String]): Unit = {
    //插值器 f   s    raw
    //s字符串插值器
    val name = "jreey"
    val res = s"Hello,$name"
    println(res)
    //对${}里面的表达式进行运算
    val res1 = s"1+1=${1+1}"
    println(res1)
    //f插值器  是对字符串进行格式化的
    val height = 1.9d
    val name1 = "tom"
    val res2 = f"$name1 is $height%2.2f meiters tall"
    println(res2)
    //raw插值器  类似于s插值器，不会其中的内容做转换
    val str = s"a\nb"
    println(str)
    val str2 = raw"a\nb"
    println(str2)

  }
}
