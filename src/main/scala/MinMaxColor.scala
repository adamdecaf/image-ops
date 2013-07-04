package com.decaf.imageops
import java.awt.image.BufferedImage

case class ColorMinMax(
  min: Int,
  max: Int
)

object MinMaxColor {
  def findMinMaxColor(image: BufferedImage): ColorMinMax = {
    var min = Int.MaxValue
    var max = Int.MinValue

    for (y <- (0 to image.getHeight - 1)) {
      for (x <- (0 to image.getWidth - 1)) {
        val rgb = image.getRGB(x, y)
        if (rgb < min) (min = rgb)
        if (rgb > max) (max = rgb)
      }
    }

    ColorMinMax(min, max)
  }
}
