package com.atguigu.datastructre.sort

import java.text.SimpleDateFormat
import java.util.Date

import util.control.Breaks._

object QuickSort {

  def main(args: Array[String]): Unit = {

//    val array = Array(-9,78,0,23,-567,70 )
//    println(array.mkString(","))
//    quickSort(0,array.length - 1,array)
//    println(array.mkString(","))

    val random = new util.Random()
    val array = new Array[Int](8000000)
    for (i <- 0 until 8000000) {
      array(i) = random.nextInt(8000000)//1-8000000随机数
    }
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间=" + date) //输出时间


    quickSort(0,array.length-1,array)//快速排序

    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2) //输出时间

  }


  def quickSort(left : Int,right : Int,arr : Array[Int]): Unit = {
    var l = left
    var r = right

    var midVal = arr(l + (r - l) / 2)
    var temp = 0

    //下面的while 完成任务是
    // 将比 midVal 小的数放在其左边 , 将 比 midVal 大的数放在其右边
    breakable{
      //如果 l < r 说明任务可以继续
      while (l < r) {
        while (arr(l) < midVal) {
          l += 1
        }

        while(arr(r) > midVal) {
          r -= 1
        }
        //如果 l >=r 说明已经完成了将所有比midVal 小的数放在左边，将比midVal 大的数放在右边
        if(l >= r) {
          break()
        }
        temp = arr(l)
        arr(l) = arr(r)
        arr(r) = temp

        //防止死循环
        if (arr(l) == midVal) {
          l += 1
        }

        //防止死循环
        if(arr(r) == midVal) {
          r -= 1
        }
      }
    }

    //防止死循环
    if(l == r) {
      l += 1
      r -= 1
    }

    //向左递归
    if(left < r) {
      quickSort(left,r,arr)
    }
    //向左递归
    if(right > l) {
      quickSort(l,right,arr)
    }

  }

}
