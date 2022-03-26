sealed abstract class Furniture
case class Couch() extends Furniture
case class Chair() extends Furniture


object SealesDemo  {

  def findPlaceToSit(furniture: Furniture):String = furniture match {
    case a:Couch => "life on the couch"
    case b:Chair => "sit on the chair"
//    case _: => ""
  }

  val chair = Chair()

  def main(args: Array[String]): Unit = {
    println(findPlaceToSit(chair))
  }


}
