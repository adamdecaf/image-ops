package com.decaf.imageops

import javax.imageio.ImageIO
import java.awt.image.BufferedImage

object CommonColors {
  def createColorGraph(image: BufferedImage): ColorGraph = {
    val totalPixels = image.getHeight * image.getWidth
    var pairs = Set.empty[ColorPair]

    for (y <- (0 to image.getHeight - 1)) {
      for (x <- (0 to image.getWidth - 1)) {
        val hex = image.getRGB(x, y)
        val pair = pairs.find(_.color == hex) match {
          case None =>
            val p = ColorPair("", hex, 1, 1D / totalPixels)
            pairs += p
            p

          case Some(p) =>
            val pp = p.copy(count = p.count + 1,
                            percent = (1D / totalPixels) + p.percent)
            pairs -= p
            pairs += pp
            pp
        }
        pairs
      }
    }
    ColorGraph(pairs)
  }
}
