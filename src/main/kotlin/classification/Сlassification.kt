package classification

import model.BaggageModel
import model.norma
import model.scalar

/**
 * Created by Zahar on 23.10.16.
 */

interface Сlassification {
	fun doWork(point1: BaggageModel, point2: BaggageModel): Double
	fun moreIsBetter(): Boolean
	fun name(): String
}

class СlassificationCos : Сlassification {
	override fun moreIsBetter(): Boolean = true
	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val scalar = point1.scalar(point2)
		return scalar / (point1.norma() * point2.norma())
	}

	override fun name(): String = "Направляющие косинусы"

}

class СlassificationEuclid : Сlassification {
	override fun moreIsBetter(): Boolean = false

	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val d = point1.ds - point2.ds
		val d2 = point1.dm - point2.dm
		return Math.sqrt(d * d + d2 * d2)
	}

	override fun name(): String = "Eвклидово расстояние"
}

class СlassificationTanimoto : Сlassification {
	override fun moreIsBetter(): Boolean = true

	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		val scalar = point1.scalar(point2)
		val norma = point1.norma()
		val norma1 = point2.norma()
		return scalar / (norma * norma + norma1 * norma1 - scalar)
	}

	override fun name(): String = "Расстояние Танимото"
}