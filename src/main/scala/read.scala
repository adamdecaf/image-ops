package com.decaf.imageops

import java.io.File
import javax.imageio.ImageIO
import java.awt.image.BufferedImage

object Read {
  def apply(f: File): Option[BufferedImage] = try {
    Some(ImageIO.read(f))
  } catch {
    case _: Throwable => None
  }

  def apply(s: String): Option[BufferedImage] = Read(new File(s))
}
