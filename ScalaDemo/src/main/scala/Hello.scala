class Add(){

  def cal(aa:Int,bb:Int): Unit ={
    println("Sum:"+(aa+bb));
  }
}

class Sub(){
  def cal(aa:Int,bb:Int){
    println("Diff:" + (aa - bb))
  }
}

class oper extends Add(){

}

class arr(){
  def arrFun(getEle:Int):Int={
    var inc=0;var count=9;
    var arrOfEle=new Array[Int](10);
    for(inc <- 0 to count){
        arrOfEle(inc)=inc;
    }
    return arrOfEle(getEle);
  }
}

object Hello {
  def main(args: Array[String]): Unit = {
    val addOb=new Add()
    addOb.cal(4,1);

    val subOb=new Sub();
    subOb.cal(5,10);

    val operOb=new oper();
    operOb.cal(15,10);

    val arrOb=new arr();
    arrOb.arrFun(6)
    addOb.cal(arrOb.arrFun(6),arrOb.arrFun(8) )

    val colsOb=new cols();
    colsOb.scalaList();
    colsOb.scalaSet();
    colsOb.scalaMap();

    var a=new traitEg();
    a.showText();
  }
}

class cols(){
  def scalaList()={
    val intList: List[Int] = List(1, 2, 3, 4, 5)
    println("List Head: "+intList.head);
    val twoDimList: List[List[Int]] = List(List(1, 2, 3), List(4, 5, 6), List(7, 8, 9));
    println("List Tail: "+twoDimList.tail);
  }

  def scalaSet()={
    val intSet: Set[Int] = Set(1, 2, 3, 4, 5)
    println("Set: "+intSet)
  }

  def scalaMap()={
    var intStringMap:Map[Int,String]=Map()
    intStringMap =intStringMap+(1 -> "Apples")
    intStringMap =intStringMap+(2 -> "Ball")
    intStringMap =intStringMap+(3 -> "Cat")
    println("Map: "+intStringMap)
  }
}

trait simpleTrait{
  def showText()
}

class traitEg extends simpleTrait{
  def showText(): Unit ={
    println("The Trait executed");
  }
}