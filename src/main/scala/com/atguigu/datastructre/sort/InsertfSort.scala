package com.atguigu.datastructre.sort

import java.text.SimpleDateFormat
import java.util.Date

object InsertfSort {

  def main(args: Array[String]): Unit = {

    //    val array = Array(101, 34, 119, 1,-1,89,-23)
    //    println(array.mkString("-"))
    //    insertSort(array)
    //    println(array.mkString(","))

    val random = new util.Random()
    val arr = new Array[Int](8000000)
    for (i <- 0 until arr.length) {
      arr(i) = random.nextInt(8000000) //1-8000000随机数
    }
    val now: Date = new Date()
    val dateFormat: SimpleDateFormat =
      new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date = dateFormat.format(now)
    println("排序前时间=" + date) //输出时间

    insertSort(arr) //插入排序

    val now2: Date = new Date()
    val date2 = dateFormat.format(now2)
    println("排序后时间=" + date2) //输出时间


  }

  //val array = Array(101, 34, 119, 1,-1,89,-23)

  def insertSort(arr: Array[Int]): Unit = {

    for (i <- 0 until arr.length - 1) {
      var insertIndex = i
      var insertVal = arr(i + 1)

      while (insertIndex >= 0 && insertVal < arr(insertIndex)) {
        arr(insertIndex + 1) = arr(insertIndex)
        insertIndex -= 1
      }
      arr(insertIndex + 1) = insertVal
    }
  }

  /**
    * 快排
    * 时间复杂度:平均时间复杂度为O(nlogn)
    * 空间复杂度:O(logn)，因为递归栈空间的使用问题
    */
  def quickSort(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case base :: tail => //非空集合
      val (left, right) = tail.partition(_ < base) //将列表尾部分成比首部元素小的部分和比首部元素大的部分
      quickSort(left) ::: base :: quickSort(right) //组合成一个新的列表——sort(比首部小的部分)+首部+sort(比首部大的部分)
  }


  /**
    * scala中的:: , +:, :+, :::, +++, 等操作;
    */
  object listTest {
    def main(args: Array[String]): Unit = {
      val list = List(1, 2, 3)
      // todo :: 用于的是向队列的头部追加数据,产生新的列表, x::list,x就会添加到list的头部
      println(4 :: list) //输出: List(4, 1, 2, 3)
      // .:: 这个是list的一个方法;作用和上面的一样,把元素添加到头部位置; list.::(x);
      println(list.::(5)) //输出: List(5, 1, 2, 3)
      // :+ 用于在list尾部追加元素; list :+ x;
      println(list :+ 6) //输出: List(1, 2, 3, 6)
      // +: 用于在list的头部添加元素;
      val list2 = "A" +: "B" +: Nil //Nil Nil是一个空的List,定义为List[Nothing]
      println(list2) //输出: List(A, B)
      // todo ::: 用于连接两个List类型的集合 list ::: list2
      println(list ::: list2) //输出: List(1, 2, 3, A, B)
      // ++ 用于连接两个集合，list ++ list2
      println(list ++ list2) //输出: List(1, 2, 3, A, B)
    }
  }


}
