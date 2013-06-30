package com.decaf.imageops

// todo: generalize the color param, it's too picky right now.
case class ColorPair(
  name: String,
  color: Int,
  count: Int,
  percent: Double
)

case class ColorGraph(
  colors: Set[ColorPair]
)
