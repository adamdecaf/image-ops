package com.decaf.imageops

object Boot {
  def main(args: Array[String]): Unit = {
    val maybeImage = Read("src/main/resources/test_img.png")

    // val graph = maybeImage.map(CommonColors.createColorGraph(_))
    // graph.foreach(println(_))

    // Color MinMax
    // val res = maybeImage.map(MinMaxColor.findMinMaxColor(_))
    // println(res)

    // Colorize
    val maybeBlackAndWhite = Read("src/main/resources/black-and-white.png")
    val res = maybeBlackAndWhite.map(ColorQuantization.colorizeBlackAndWhiteImage(_))
    res.foreach(Write("src/main/resources/colorized.png", _))
  }
}
