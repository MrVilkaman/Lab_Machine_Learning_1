package classification

import model.BaggageModel

/**
 * Created by Zahar on 23.10.16.
 */

interface Сlassification {
	fun doWork(point1: BaggageModel, point2: BaggageModel): Double
}

class СlassificationCos :Сlassification{
	override fun doWork(point1: BaggageModel, point2: BaggageModel): Double {
		return 0.0
	}

}