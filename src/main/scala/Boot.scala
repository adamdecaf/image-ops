package com.decaf.imageops

object Boot {
  def main(args: Array[String]): Unit = {
    val maybeImage = Read("src/main/resources/test_img.png")
    val graph = maybeImage.map(CommonColors.createColorGraph(_))

    graph.foreach { g =>
      println(g)
    }
  }
}
