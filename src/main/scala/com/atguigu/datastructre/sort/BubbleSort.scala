package com.atguigu.datastructre.sort

import java.text.SimpleDateFormat
import java.util.Date

object BubbleSort {

  def main(args: Array[String]): Unit = {

    //创建一个80000个随机数据的数组
    val random = new util.Random()
    val arr = new Array[Int](80000)
    for (i <- 0 until 80000) {
      arr(i) = random.nextInt(8000000)
    }
    val date: Date = new Date()
    val dateFormat : SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val nowTime: String = dateFormat.format(date)
    println("排序前时间=" + nowTime) //输出时间

    bubbleSort(arr)

    val date2: Date = new Date()
    val nowTime2 = dateFormat.format(date2)
    println("排序后时间=" + nowTime2) //输出时间

  }

  def bubbleSort(arr : Array[Int]): Unit = {
   for (i <- 0 until arr.length - 1) {
     for (j <- 0 until arr.length - 1 - i) {
       if (arr(j) > arr(j + 1)) {
         val temp = arr(j)
         arr(j) = arr(j + 1)
         arr(j+ 1) = temp
       }
     }
   }
  }

}
