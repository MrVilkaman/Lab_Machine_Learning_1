package model

import java.awt.Color

/**
 * Created by Zahar on 22.10.16.
 */

open class BaggageModel(val ds: Double, val dm: Double, val objClass: Int, val number:Int = -1)

class BaggageModelColored(ds: Double, dm: Double, val color: Color, val colorSub: Color) : BaggageModel(ds, dm, 0)


fun BaggageModel.norma(): Double {
	return Math.sqrt(scalar(this))
}


fun BaggageModel.scalar(point: BaggageModel): Double {
	return this.ds * point.ds + this.dm * point.dm
}