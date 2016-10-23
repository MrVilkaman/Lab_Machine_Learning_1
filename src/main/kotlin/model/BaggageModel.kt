package model

import java.awt.Color

/**
 * Created by Zahar on 22.10.16.
 */

open class BaggageModel(val ds: Float, val dm: Float, val objClass: Int)

class BaggageModelColored(ds: Float, dm: Float, val color: Color,val colorSub: Color) : BaggageModel(ds, dm, 0)