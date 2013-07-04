package com.decaf.imageops

import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

object Write {
  def apply(f: File, image: BufferedImage): Unit =
    ImageIO.write(image, "png", f)

  def apply(s: String, image: BufferedImage): Unit =
    Write(new File(s), image)
}
