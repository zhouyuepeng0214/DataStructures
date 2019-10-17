package com.atguigu.datastructre.recursion

object MiGong {

  def main(args: Array[String]): Unit = {

    val map = Array.ofDim[Int](8,7)

    for (i <- 0 until 7) {
      map(0)(i) = 1
      map(7)(i) = 1
    }

    for (i <- 0 until 7) {
      map(i)(0) = 1
      map(i)(6) = 1
    }

    map(3)(1) = 1
    map(3)(2) = 1
    map(2)(2) = 1

    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) +" ")
      }
        println()
    }

    setWay(map,1,1)

    println()
    println()

    for (i <- 0 until 8) {
      for (j <- 0 until 7) {
        print(map(i)(j) +" ")
      }
      println()
    }

  }


  //编写一个方法，使用递归回溯来找路
  /**
    *
    * @param map 地图
    * @param i 小球开始的横坐标
    * @param j 小球开始的纵坐标
    */
  def setWay(map: Array[Array[Int]],i : Int,j : Int): Boolean = {

    if (map(6)(5) == 2){
      return true
    } else {
      //如果map(i)(j) == 0,说明该点没有探测过
      if (map(i)(j) == 0) {
        //思想，假设法+回溯, 假设该点是可以走通
        map(i)(j) = 2
        //开始向 下->右->上->左 探测，如果四个方向都不通，则map(i)(j)=3
        //向下
        if (setWay(map,i + 1,j)) {
          return true
        } else if (setWay(map,i,j + 1)) {
          return true
        } else if (setWay(map,i - 1,j)) {
          return true
        } else if (setWay(map,i,j - 1)) {
          return true
        } else {
          map(i)(j) = 3
          return false
        }
      } else  {
        return false
      }
    }

  }

}
