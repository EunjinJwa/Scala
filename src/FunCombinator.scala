object FunCombinator {


  /**
    * Function Combinator
    * : A Combinator is a function which builds program fragment from program fragment
    */

  def main(args: Array[String]): Unit = {

    mapExam

    foreachExam

    forExam

    filterExam

    partitionExam

    zipExam

    findExam

    dropExam

    foldLeftExam

    flattenExam

    flatMapExam


  }

  /**
    * map
    * 리스트의 모든 원소를 함수에 적용한 결과값으로 이루어진 새 리스트를 반환한다.
    */
  def mapExam = {
    val numList = List(1,2,3,4,5,6,7,8,9)
    println(numList.map((i:Int) => i + "억"))    // 새 List 를 반환
    println(numList)      // 기존 List의 값은 영향 없음

    val line = "123, 456, 789"
    val cols = line.split(",").map(_.trim)     // Array
    println(cols.mkString(","))

  }

  /**
    * forEach
    * map과 비슷하지만 반환하는 값이 없고, 상태를 변화시키기위해 사용함
    * 일반적으로 collection 내 모든 값에 대한 특정 작업을 수행시키기 위해 사용된다.
    */
  def foreachExam={
    val numList = List(1,2,3,4,5,6,7,8,9)
    val dbNumList = numList.foreach((i:Int) => i * 2)
    println(s"$dbNumList << foreach는 반환하는 값이 없으므로")

  }

  /**
    * for
    * for는 foreach와 같이 반환값이 없이 List의 원소를 순환하며 특정 작업을 수행한다.
    */
  def forExam = {
    val list = List((1, 1), (2, 2), (3, 3), (4, 4))
    val resullt = for(item <- list){
      println( item )
    }
    println(resullt)   // for 는 반환값이 없으므로 result는 빈값임.

    // yield  : yield 연결자를 통해 변환된 자료 구조를 원소로 하는 List를 반환할 수 있다.
    val result2 = for(item <- list) yield {
      (item._1 *item._2)
    }
    println(result2)
 }

  /**
    * filter / filterNot
    * 전달된 함수가 참인 원소들로 이루어진 리스트를 반환한다.
    */
  def filterExam = {
    val list = List(1,2,3,4,5,6,7,8,9,10)
    val filterList = list.filter( (i:Int) => i%2 == 0 )
    println(filterList)
  }

  /**
    * partition
    * 함수의 조건을 충족하는 원소의 List와 조건을 충족하지 못하는 원소의 List를 모두 반환
    * (Tuple2 의 형태)
    */
  def partitionExam = {
    val list = List(1,2,3,4,5,6,7,8,9)
    val result = list.partition( _ % 2 == 0)
    println(result)     // (List(2, 4, 6, 8),List(1, 3, 5, 7, 9))
    println(s"조건 충족 result : ${result._1}")    // List(2, 4, 6, 8)
    println(s"조건 불충족 result : ${result._2}")    // List(1, 3, 5, 7, 9)
  }


  /**
    * zip
    *  : 두 List의 원소들의 쌍(tuple)로 이루어진 단일 List를 반환한다.
    */
  def zipExam = {
    val zipList = List(1,2,3).zip(List("a","b","c"))
    println(zipList)        // List((1,a), (2,b), (3,c))

    /** zipWithIndex */
    // Index 값으로 활용할 수 있는 정보와 함께 단일 List를 구성하여 반환한다.
    val list = List("a","b","c","d","e","f","g","h","i")
    val indexList = list.zipWithIndex
    println(indexList)        // List((a,0), (b,1), (c,2), (d,3), (e,4), (f,5), (g,6), (h,7), (i,8))
    println(zipList.zipWithIndex)   // List(((1,a),0), ((2,b),1), ((3,c),2))

    /** unzip */
    // 원소가 tuple2로 구성된 List 에서 원소를 분리한 두 개의 List를 반환한다.
    val unzipList = zipList.unzip
    println(unzipList)      // (List(1, 2, 3),List(a, b, c))

  }

  /**
    * find
    * find는 List에서 함수의 조건을 만족하는 가장 첫 원소를 반환한다.
    */
  def findExam = {
    val list = List(1,2,3,4,5,6,7,8,9)
    val resultList = list.find((i:Int) => i > 5)   // find( _ > 5 ) 로 대체 가능
    println(resultList)     // Some(6)

    val resultList2 = list.find( _%2 == 0)
    println( resultList2 )    // Some(2)

  }


  /**
    * drop
    * : 첫 n 개의 원소를 버린다.
    * dropRight
    * : 뒤쪽 n 개의 원소를 버린다.
    */
  def dropExam = {
    val list = List(1,2,3,4,5,6,7,8,9,10)

    val dropList = list.drop(3)
    println(dropList)      // List(4, 5, 6, 7, 8, 9, 10)

    val dropRightList = list.dropRight(2)
    println(dropRightList)      // List(1, 2, 3, 4, 5, 6, 7, 8)

    /** dropWhile */
      // 함수 조건에 만족하는 원소를 제거한다.
      // 함수 조건을 최초로 거짓으로 반환하는 지점 까지만 동작한다.
    val dropWhileList = list.dropWhile(_%5 != 0)
    println(dropWhileList)        // List(5, 6, 7, 8, 9, 10)

  }


  /**
    * foldLeft / foleRight
    * 시작값을 정의하고, 함수의 연산 결과를 시작 값에 누적시켜, 모든 원소에 대한 연산 결과가 누적된 결과 값을 반환받는다.
    */
  def foldLeftExam = {
    val list = List(10,20,30,40,50,60,70,80,90,100)

    /** foldLeft */
    val result = list.foldLeft(0){
      (m: Int, n: Int) => println(s"m : $m, n : $n");
                            m + n
    }
    println(s"> $result")

    /** foldRight */
      // List 원소 역순으로 진행함
    val result2 = list.foldRight(0){
      (m: Int, n: Int) => println(s"m : $m, n : $n");
        m + n
    }
  }

  /**
    * flatten
    * 내포 단계를 하나 둘여서 내포된 List의 원소를 상위 List로 옮겨준다.
    */
  def flattenExam = {
    val pList = List( List(1,2,3), List("a","b","c"), List(7.0,8.0,9.0) )
    val result = pList.flatten
    println(result)     // List(1, 2, 3, a, b, c, 7.0, 8.0, 9.0)

    result.foreach( i => println( s"$i is ${i.getClass}" ))
  }

  /**
    * flatMap
    * : map 과 flatten 을 합성한 것.
    * 내포 List 에 적용할 수 있는 함수를 중첩된 리스트 안의 리스트에 적용해서 나온 결과를 하나의 List 로 합쳐준다.
    */
  def flatMapExam = {
    val list = List(List(2, 3), List(4, 5))
    val result = list.flatMap(f => f)
    println(result) // List(2, 3, 4, 5)

    val result2 = list.flatMap(
      f => f.map(_ * 10)
    )
    println(result2) // List(20, 30, 40, 50)

  }



}
