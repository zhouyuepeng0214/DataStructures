package com.atguigu.datastructre.sort

import java.text.SimpleDateFormat
import java.util.Date

import scala.util.Random

object SelectSort {

  def main(args: Array[String]): Unit = {

    val array = Array(101, 34, 119, 1,-1,89,900)

//    println(array.mkString(","))
//
//    selectSort(array)
//
//    println(array.mkString(","))

    val random: Random = new util.Random()
    val arr: Array[Int] = new Array[Int](800000)

    for (i <- 0 until arr.length) {
      arr(i) = random.nextInt(8000000)
    }
//    println(arr.mkString("-"))

    val date: Date = new Date()

    val format: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date1: String = format.format(date)
    println("排序前:" + date1)

    selectSort(arr)
//    println(arr.mkString("-"))

    val date2: Date = new Date()

    val date3: String = format.format(date)
    println("排序后:" + date3)


  }

  //思路
  //    1.假设  minVal = arr(0), minIndex = 0
  //    2.然后 和后面的所有元素进行比较
  //     3.如果发现有比 minVal  更小的，就做相应更新
  //    4.当遍历完毕后，将真正最小值和 arr(0) 交换
  def selectSort(arr : Array[Int]): Unit ={

    for (i <- 0 until arr.length - 1) {
      var minIndex = i
      for (j <- i + 1 until arr.length) {
        if (arr(minIndex) > arr(j)) {
          minIndex = j
        }
      }
      if (minIndex != i) {
        var temp = arr(minIndex)
        arr(minIndex) = arr(i)
        arr(i) = temp
      }
    }
  }

}
