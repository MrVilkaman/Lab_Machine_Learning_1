package classification

import model.BaggageModel
import model.norma
import model.scalar

/**
 * Created by Zahar on 23.10.16.
 */

interface Сlassification {
	fun doWork(point1: BaggageModel, point2: BaggageModel): Double
}

class СlassificationCos : Сlassification {
	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val scalar = point1.scalar(point2)
		return scalar / (point1.norma() * point2.norma())
	}
}

class СlassificationEuclid : Сlassification {
	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val d = point1.ds - point2.ds
		val d2 = point1.dm - point2.dm
		return Math.sqrt(d * d + d2 * d2)
	}
}

class СlassificationTanimoto : Сlassification {
	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val scalar = point1.scalar(point2)
		val norma = point1.norma()
		val norma1 = point2.norma()
		return scalar / (norma * norma + norma1 * norma1 - scalar)
	}
}