package com.atguigu.datastructre.search


import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks

object BinarySearch {

  def main(args: Array[String]): Unit = {

    val ints: Array[Int] = Array(1, 4, 5, 8, 9, 11, 19, 45)
    //                                0  1  2  3 4  5  6  7  8  9  10  11  12  13  14
    //    val ints: Array[Int] = Array(1, 1, 1, 4, 5, 8, 8, 8, 8, 9, 11, 19, 45, 45, 45)

    val i: Int = binarySearch1(ints, 9)

    println(i)
    println(ints.length)

  }

  // todo 二分查找 要求：有序
  def binarySearch(arr: Array[Int], left: Int, right: Int, findVal: Int): Int = {
    if (left > right || findVal < arr(left) || findVal > arr(right)) {
      -1
    }
    // todo mid=low+(high-low)/2 可以防止溢出
    val midIndex = left + (right - left) / 2

    if (findVal < arr(midIndex)) {
      binarySearch(arr, left, midIndex - 1, findVal)
    } else if (findVal > arr(midIndex)) {
      binarySearch(arr, midIndex + 1, right, findVal)
    } else {
      midIndex
    }
  }

  // todo 非递归实现
  def binarySearch1(arr : Array[Int],findVal : Int): Int = {
    var left = 0
    var right = arr.length - 1
    while (left <= right) {
      var midIndex = left + ((right - left) >>1)
      if (findVal < arr(midIndex)) {
        right = midIndex - 1
      } else if (findVal > arr(midIndex)) {
        left = midIndex + 1
      } else {
        // todo 此处必须加return
        return midIndex
      }
    }
    return -1
  }

  def binarySearch2(arr: Array[Int], left: Int, right: Int, findVal: Int): ArrayBuffer[Int] = {
    if (left > right || findVal < arr(left) || findVal > arr(right)) {
      -1
    }
    //(0 + 14)/2=7
    val midIndex = left + (right - left) / 2
    if (findVal < arr(midIndex)) {
      binarySearch2(arr, left, midIndex - 1, findVal)
    } else if (findVal > arr(midIndex)) {
      binarySearch2(arr, midIndex + 1, right, findVal)
    } else {
      val ints: ArrayBuffer[Int] = ArrayBuffer[Int]()
      var temp: Int = midIndex - 1
      Breaks.breakable {
        while (true) {
          if (temp < 0 || arr(temp) != findVal) {
            Breaks.break()
          }
          if (arr(temp) == findVal) {
            ints.append(temp)
          }
          temp -= 1
        }
      }
      ints.append(midIndex)
      temp = midIndex + 1
      Breaks.breakable {
        while (true) {
          if (temp > arr.length - 1 || arr(temp) != findVal) {
            Breaks.break()
          }
          if (arr(temp) == findVal) {
            ints.append(temp)
          }
          temp += 1
        }
      }
      ints
    }
  }
}


