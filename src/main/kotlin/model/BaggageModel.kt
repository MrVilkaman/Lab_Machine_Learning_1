package model

import java.awt.Color

/**
 * Created by Zahar on 22.10.16.
 */

open class BaggageModel(val ds: Int, val dm: Int, val objClass: Int)

class BaggageModelColored(ds: Int, dm: Int, val color: Color) : BaggageModel(ds, dm, 0)