package com.decaf.imageops
import javax.imageio.ImageIO
import java.awt.Color
import java.awt.image.BufferedImage
import scala.language.implicitConversions

// Bam: http://en.wikipedia.org/wiki/Color_quantization

object ColorQuantization {

  def colorizeBlackAndWhiteImage(image: BufferedImage): BufferedImage = {
    for (y <- (0 to image.getHeight - 1)) {
      for (x <- (0 to image.getWidth - 1)) {
        val rgb = getRGB(image.getRGB(x, y))
        val newRgb = getConstant(rgb._1, rgb._2, rgb._3)
        image.setRGB(x, y, newRgb.toInt)
      }
    }
    image
  }

  private[this] def getRGB(i: Int): Tuple3[Int, Int, Int] = {
    val c = new Color(i)
    Triple(c.getRed, c.getGreen, c.getBlue)
  }

  // Cheap way
  private[this] def getConstant(r: Double, g: Double, b: Double): Double =
    ((0.3 * r)/2 + (0.59 * g)/2 + (0.11 * b)/2)

  // Solve for sqrt((r - r2)^2 + (g - g2)^2 - (b - b2)^2) = 0
  // So, just find the inverse of each color mod 255
  // private[this] def solveEuclidianDistance(r: Int, g: Int, b: Int): Tuple3[Int, Int, Int]
}
