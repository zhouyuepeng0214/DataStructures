package com.atguigu.datastructre.linkedlist


import util.control.Breaks._

object CircleSingleLinkedListDemo {

  def main(args: Array[String]): Unit = {

    val josephu = new Josephu
    josephu.addBoy(5)
    josephu.list()


    josephu.countBoy(2,2,5) // 3-5-2-1-4
  }

}

class Josephu {

  //构建一个环形链表
  //创建一个first 小孩
  var first :Boy = null

  //开始玩小孩出圈小游戏
  def countBoy(startNo :Int,countNum : Int,nums : Int): Unit = {
    if (startNo <= 0 || countNum <= 0 || startNo > nums || isEmpty()) {
      println("参数有误")
      return
    }

    //先将 temp 定位到 first 的前一个节点, 然后再后面我们将temp 一直再 first 后面

    var temp = first
    breakable {
      while(true) {
        if (temp.next == first) {
          break()
        }
        temp = temp.next
      }
    }

    //直再 first 后面
    // 增加，定位到startNO 这个小孩 移动 (startNO -1)
    // temp 一直再 fisrt 前, 以后可以优化

    for (i <- 0 until  startNo - 1) {
      first = first.next
      temp = temp.next
    }

    //开始数数, 如果数 m 下，first 应该移动 m-1 次 , 让 temp 一直跟在 first 后面
    breakable{
      while (true) {
        for (i <- 0 until countNum - 1) {
          first = first.next
          temp = temp.next
        }
        //这时 first 就指向要出圈小孩
        printf("\n出圈小孩no=%d",first.no)

        first = first.next
        temp.next = first
        //判断是否只有一个小孩
        if (temp == first) {
          break()
        }
      }
    }
    printf("\n最后一个小孩no=%d",first.no)

  }


  def isEmpty(): Boolean = {
    first == null
  }

  def list(): Unit ={
    if (isEmpty()) {
      println("没有小孩")
      return
    }

    var temp = first
    breakable{
      while (true) {
        println(temp.no)
        if (temp.next == first) {
          break()
        }
        temp = temp.next
      }
    }
  }

  def addBoy(nums : Int): Unit = {
    var curBoy : Boy = null
    for (no <- 1 to nums) {
      val boy = new Boy(no)
      if (no == 1) {//如果是一个小孩
        first = boy
        curBoy = boy
      } else {//从第二个小孩
        boy.next = first
        curBoy.next = boy
        curBoy = boy
      }
    }
  }
}

class Boy (bNo : Int) {
  val no = bNo
  var next : Boy = null
}
