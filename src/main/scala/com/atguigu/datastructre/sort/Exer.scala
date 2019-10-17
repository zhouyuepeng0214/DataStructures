package com.atguigu.datastructre.sort

object Exer {

  def main(args: Array[String]): Unit = {

    val array = Array(-9, 78, 0, 23, -567, 70)
    println(array.mkString(","))
    insertSort1(array)
//    selectSort1(array)
    //bubleSort1(array)
    println(array.mkString(","))

  }

  def bubleSort1(arr: Array[Int]): Unit = {
    for (i <- 0 until arr.length - 1) {
      for (j <- 0 until arr.length - 1 - i) {
        if (arr(j) > arr(j + 1)) {
          val temp = arr(j)
          arr(j) = arr(j + 1)
          arr(j + 1) = temp
        }
      }
    }
  }

  def selectSort1(arr : Array[Int]): Unit = {
    for(i <- 0 until arr.length - 1) {
      var minIndex = i
      for(j <- i + 1 until arr.length) {
        if(arr(minIndex) > arr(j)) {
          minIndex = j
        }
      }
      if (minIndex != i) {
        val temp = arr(i)
        arr(i) = arr(minIndex)
        arr(minIndex) = temp
      }
    }
  }

  //val array = Array(-9, 78, 0, 23, -567, 70)
  def insertSort1(arr : Array[Int]): Unit = {
    for(i <- 0 until arr.length - 1) {
      var insertIndex = i
      val insertVal = arr(i + 1)
      while(insertIndex >= 0 && insertVal < arr(insertIndex)) {
        arr(insertIndex + 1) = arr(insertIndex)
        insertIndex -= 1
      }
      arr(insertIndex + 1) = insertVal
    }
  }


}
