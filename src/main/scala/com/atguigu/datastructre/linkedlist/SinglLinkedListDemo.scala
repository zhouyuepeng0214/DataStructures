package com.atguigu.datastructre.linkedlist

import util.control.Breaks._

object SinglLinkedListDemo {

  def main(args: Array[String]): Unit = {

    val singlLinkedList = new SinglLinkedList

    val node10 = new HeroNode(20,"宋江","及时雨")
    val node2 = new HeroNode(3,"小陆","玉麒麟")
    val node3 = new HeroNode(4,"吴用","智多星")

    singlLinkedList.add(node2)
    singlLinkedList.add(node3)
//    singlLinkedList.add(node2)

    singlLinkedList.list()
    println()
//    val node4 = new HeroNode(3,"林冲","豹子头")
//
//    singlLinkedList.update(node4)

//    singlLinkedList.del(1)
//    singlLinkedList.del(2)
//    singlLinkedList.del(3)
//    singlLinkedList.del(33)

    singlLinkedList.addByOrder(node10)
    println("修改后")
    singlLinkedList.list()




  }

}

class SinglLinkedList {
  val head = new HeroNode(-1,"","")

  //添加的时候考虑编号问题从小到大
  def addByOrder(heroNode: HeroNode): Unit = {
    var temp = head
    var flag = false //标识 是否有重复的no
    breakable{
      while(true) {
        //就直接判断是否是尾部, 如不不是最后一个，就继续
        //否则退出
        if (temp.next == null) {
          break()
        }
        if (heroNode.no < temp.next.no) {
          break()
        } else if (heroNode.no == temp.next.no) {
          //重复，不能添加
          flag = true
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      printf("no=%d 存在",heroNode.no)
    } else {
      heroNode.next = temp.next
      temp.next = heroNode
    }
  }

  //删除
  def del(delNo : Int): Unit = {
    if (isEmpty()) {
      println("链表空，不能修改")
      return
    }
    //定义辅助变量
    //判断是temp.next.no 是否要删除
    var temp = head
    var flag = false
    breakable{
      while(true) {
        if (temp.next.no == delNo) {
          flag = true
          break()
        }
        if (temp.next.next == null) {
          break()
        }
        temp = temp.next
      }
    }
    if (flag) {
      temp.next = temp.next.next
    } else {
      printf("\n 你要删除的no=%d 不存在",delNo)
    }
  }

  //传入一个新的newHeroNode, 根据no 找到，并重置data的数据
  def update(newHeroNode : HeroNode): Unit = {
    if (isEmpty()) {
      println("链表空，不能修改")
      return
    }
    var temp = head.next
    var flag = false //标识是否找到
    breakable{
      while(true) {
        if (temp.no == newHeroNode.no) {
          flag = true
          break()
        }
        if (temp.next == null) {
          break()
        }
        temp = temp.next
      }
      //根据flag 决定下面的处理

    }
    if(flag) {
      temp.name = newHeroNode.name
      temp.nickName = newHeroNode.nickName
    } else {
      printf("\n no = %d 人物未找到",newHeroNode.no)
    }
  }

  //判断链表是否为空
  def isEmpty(): Boolean ={
    head.next == null
  }

  //遍历链表
  def list(): Unit ={
    if (isEmpty()) {
      println("链表为空")
      return
    }
    //定义一个辅助变量，帮助遍历
    var temp = head.next
    breakable{
      while(true) {
        printf("\nno=%d name=%s nickname=%s",temp.no,temp.name,temp.nickName)
        if (temp.next == null) {
          break()
        }
        //后移temp,输出下一个结点
        temp = temp.next
      }
    }
  }

  //添加结点的方法
  def add(heroNode: HeroNode): Unit = {
    //定义辅助变量，帮助定位链表尾
    var temp: HeroNode = head
    breakable{
      while (true) {
        //判断是否到尾部
        if (temp.next == null) {
          break()
        }
        temp = temp.next
      }
    }
    //即当退出while循环，就定位到尾部
    temp.next = heroNode
  }
  
}

//定义结点类
class HeroNode(hNO: Int, HName: String, hNickName: String) {

  val no = hNO
  var name = HName
  var nickName = hNickName
  var next : HeroNode = null
}

