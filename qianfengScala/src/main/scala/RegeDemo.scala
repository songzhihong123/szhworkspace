import scala.util.matching.Regex

object RegeDemo extends App {
  //构建一个正则表达式
  val pattern1 = "[0-9]+".r
  val pattren2 = new Regex("[0-9]+")
  //如果正则表达式中含有斜杠、引号，可以用"""..."""表示
  val pattern3 = """\s+[0-9]+\s"""

  val matchStr = "99bottles,100bottles"
  //返回所有匹配项的迭代器
  for(i <- pattern1.findAllIn(matchStr)) println(i)
  //返回首个匹配项
  val first = pattern1.findFirstIn(matchStr)
  println(first)
  //检查字符串的开始是不是能匹配
  val ifStartMatch = pattern1.findPrefixMatchOf(matchStr)
  println(ifStartMatch)
  //使用传入的字符串替换首个匹配项
  val res1 = pattern1.replaceFirstIn(matchStr,"xxx")
  println(res1)
  //使用传入的字符串替换所有匹配项
  val res2 = pattern1.replaceAllIn(matchStr,"ggg")
  println(res2)







}
