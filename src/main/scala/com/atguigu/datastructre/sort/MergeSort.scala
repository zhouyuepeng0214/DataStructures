package com.atguigu.datastructre.sort

object MergeSort {

  def main(args: Array[String]): Unit = {

    val arr = Array(9,8,7,6,5,4,3,2,1)
    println(arr.mkString(","))
    val temp = new Array[Int](arr.length)

    mergeSort(arr,0,arr.length - 1,temp)
    println(arr.mkString(","))



  }


  def mergeSort(arr : Array[Int],left : Int,right : Int,temp : Array[Int]): Unit = {

    if (left < right) {//该条件满足，才能继续分
      val midIndex = left + (right - left) / 2
      mergeSort(arr,left,midIndex,temp)  //向左递归分解
      mergeSort(arr,midIndex + 1,right,temp)  //向右递归分解
      merge(arr,left,midIndex,right,temp)
    }

  }

  /**
    *
    * @param arr
    * @param left  表示第一个有序序列的最左边的下标
    * @param mid  表示 第一个有序序列的最右边的下标， mid + 1就是第二个有序序列的左下标
    * @param right  第二个有序序列的最右边下标
    * @param temp  临时数组，中转数组，大小需要 和 arr.length 一样
    */
  def merge(arr: Array[Int], left: Int, mid: Int, right: Int, temp: Array[Int]) {

    var i = left // i 就是 第一个有序序列的最左边的下标
    var j = mid + 1 // j 第二个有序序列的左下标
    var t = 0 // t就是temp数组下标

    //工作 （阅读其他人代码）

    //=================== 第一个阶段
    // 如果： i <= mid && j <= right 满足说明 两个有序序列，都没有处理完成
    while (i <= mid && j <= right) {
      //如果第一个有序序列的当前元素小于第2个有序序列的当前元素
      //则将 第一个有序序列的当前元素 拷贝到 temp
      // t+=1  i +=1  j 不动
      if (arr(i) <= arr(j)) {
        temp(t) = arr(i)
        t += 1
        i += 1
      } else { //如果第2个有序序列的当前元素小于第1个有序序列的当前元素,则将 第2个有序序列的当前元素 拷贝到 temp, t+=1 j + =1 ,i不动
        temp(t) = arr(j)
        t += 1
        j += 1
      }
    }

    //================================
    //第二个阶段，看哪个有序序列有剩余数据，将依次拷贝到 temp
    while (i <= mid) { //说明第一个有序序列有剩余
      temp(t) = arr(i)
      t += 1
      i += 1
    }
    while (j <= right) {
      //说明第2个有序序列有剩余
      temp(t) = arr(j)
      t += 1
      j += 1
    }

    //=========================
    //第三个阶段，将 temp的数据拷贝给 arr
    //因为合并的过程，并不是只有一次，而是有很多次
    //理解一下，拷贝时候是一个段(区间)！！！
    t = 0
    var tempLeft = left
    while (tempLeft <= right) {
      arr(tempLeft) = temp(t)
      t += 1
      tempLeft += 1
    }
  }
}
