package classification

import model.BaggageModel
import java.util.*

/**
 * Created by Zahar on 23.10.16.
 */

class KMeans(val distAlg: Сlassification) {

	fun classifyKNN(trainData: ArrayList<BaggageModel>, testData: ArrayList<BaggageModel>, k: Int) {

		println(distAlg.name())

		for (i in 0..testData.size - 1) {
			val baggageModel = testData[i]

			val set: ArrayList<Pair<BaggageModel, Double>> = ArrayList()
			for (j in 0..trainData.size - 1) {
				val baggageModelTrain = trainData[j]
				val doWork = distAlg.doWork(baggageModelTrain, baggageModel)
				set.add(Pair(baggageModelTrain, doWork))
			}

			Collections.sort(set) { t, t2 -> sort(t, t2, distAlg.moreIsBetter()) }


			val subList = set.subList(0, k)
			var ss = "Точка №${baggageModel.number} должна быть: ${baggageModel.objClass} | "
			subList.forEachIndexed { i, pair ->
				val model = subList[i].first
				ss += "${model.number}/"
			}
			ss = ss.dropLast(1)
			ss += " -> "
			subList.forEachIndexed { i, pair ->
				val model = subList[i].first
				ss += "${model.objClass}"
			}
			ss += " критерий: "
			subList.forEachIndexed { i, pair ->
				val model = subList[i].second
				ss += "${model.format(3)}/"
			}
			ss = ss.dropLast(1)
			println(ss)

		}
		println()

	}

	private fun sort(t: Pair<BaggageModel, Double>, t2: Pair<BaggageModel, Double>, flag: Boolean): Int {
		val i = if (t.second < t2.second) -1 else 1
		return if (flag) -i else i
	}

	fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)

}
