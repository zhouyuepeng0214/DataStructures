package com.atguigu.datastructre.recursion

object HanoiTower {

  def main(args: Array[String]): Unit = {

    hanoiTower(5,'A','B','C')

  }

  def  hanoiTower(nums : Int,a: Char,b : Char,c : Char): Unit = {

    //如果只有一个盘
    if (nums ==1) {
      printf("\n从%c->%c",a,c)
    } else { //两个或两个以上
      //将最上的所有盘A->B,要借助c塔
      hanoiTower(nums - 1,a,c,b)
      //将最下面的盘 A->C
      printf("\n从%c->%c",a,c)
      //将B上的所有盘B->C,要借助A塔
      hanoiTower(nums - 1,b,a,c)

    }

  }

}
