package dp

import model.BaggageModel
import java.util.*

/**
 * Created by Zahar on 22.10.16.
 */

class DataProviders {

	companion object {

		val trainingSet: ArrayList<BaggageModel> by lazy {
			val arrayList = ArrayList<BaggageModel>()
			arrayList.add(BaggageModel(1.0, 2.0, 1))
			arrayList.add(BaggageModel(2.0, 3.0, 1))
			arrayList.add(BaggageModel(2.0, 3.0, 1))
			arrayList.add(BaggageModel(5.0, 3.0, 1))
			arrayList.add(BaggageModel(10.0, 0.0, 1))
			arrayList.add(BaggageModel(0.0, 7.0, 1))
			arrayList.add(BaggageModel(5.0, 6.0, 0))
			arrayList.add(BaggageModel(5.0, 1.0, 1))
			arrayList.add(BaggageModel(7.0, 3.0, 0))
			arrayList.add(BaggageModel(5.0, 7.0, 0))
			return@lazy arrayList
		}

		val controlSet: ArrayList<BaggageModel> by lazy {
			val list = ArrayList<BaggageModel>()
			list.add(BaggageModel(0.0, 0.0, 1))
			list.add(BaggageModel(1.0, 5.0, 1))
			list.add(BaggageModel(7.0, 7.0, 0))
			return@lazy list
		}
	}
}
