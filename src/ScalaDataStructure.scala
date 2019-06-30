object ScalaDataStructure {


  def main(args: Array[String]): Unit = {

    /**
      * List
      */
    val numList = List(1, 2, 3, 4)
    println(numList)
    /**
      * Set
      * 중복값을 무시함
      */
    val numSet = (1, 1, 2)
    println(numSet)

    /**
      * Map
      * key - value 형식
      */
    val map = Map( 1->2, "ba"->"bo")
    println(map)

    /**
      * tuple
      * 여러 아이템을 묶을 때 활용 가능
      * 중복을 허용함.
      */
    val hostPort = (("localhost", 80), ("dev",8081))
    println(hostPort)
    // tuple의 값 조회
    println(hostPort._2)

    // tuple2
    val tuple = ("ba", "bo", "test", "test", 1)
    println(tuple)
    println(tuple._4)

    // 패턴매칭
    val tuple2 = ("localhost", 80)
    tuple2 match {
      case ("localhost", port) => println(s"> port : $port")
      case(host, port) => println("patternMatch")
    }

    /**
      * Option Class
      */
    val numMap = Map("one"->1, "two"->2)
    println(numMap.get("two"))      // Some(2) 로 출력됨
    println(numMap.get("three"))    // None 으로 출력됨

    // 값이 없을경우 사용할 수 있는 getOrElse
    println(numMap.getOrElse("three",3))      // 3 으로 출력됨
    println(numMap.getOrElse("two", None))  // 2 로 출력됨

    // 패턴 매칭
    numMap.get("one") match {
      case Some(n) => println(s">re : n : $n / n + n = ${n+n}")
      case None => println(">re : None")
    }

    numMap.get("six") match {
      case Some(n) => println(s">re : n : $n / n + n = ${n+n}")
      case None => println(">re : None")
    }


















  }
}
