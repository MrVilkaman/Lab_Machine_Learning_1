package model

/**
 * Created by Zahar on 23.10.16.
 */

data class SimplePoint(val x: Double, val y: Double, val objClass: Int)


fun SimplePoint.toBaggage(): BaggageModel {
	return BaggageModel(this.x, this.y, this.objClass)
}