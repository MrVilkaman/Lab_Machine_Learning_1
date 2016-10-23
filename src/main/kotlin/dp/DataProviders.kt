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
			arrayList.add(BaggageModel(1f, 2f, 1))
			arrayList.add(BaggageModel(2f, 3f, 1))
			arrayList.add(BaggageModel(2f, 3f, 1))
			arrayList.add(BaggageModel(5f, 3f, 1))
			arrayList.add(BaggageModel(10f, 0f, 1))
			arrayList.add(BaggageModel(0f, 7f, 1))
			arrayList.add(BaggageModel(5f, 6f, 0))
			arrayList.add(BaggageModel(5f, 1f, 1))
			arrayList.add(BaggageModel(7f, 3f, 0))
			arrayList.add(BaggageModel(5f, 7f, 0))
			return@lazy arrayList
		}

		val controlSet: ArrayList<BaggageModel> by lazy {
			val list = ArrayList<BaggageModel>()
			list.add(BaggageModel(0f, 0f, 1))
			list.add(BaggageModel(1f, 5f, 1))
			list.add(BaggageModel(7f, 7f, 0))
			return@lazy list
		}
	}
}
