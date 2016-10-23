package utils

import model.BaggageModel
import model.SimplePoint
import java.util.*

/**
 * Created by Zahar on 23.10.16.
 */

class LabUtils {
	companion object {
		fun getCenterPos(items: ArrayList<BaggageModel>): ArrayList<SimplePoint> {

			val filter = getCenterPos2(items.filter { it.objClass == 0 })
			val filter2 = getCenterPos2(items.filter { it.objClass == 1 })
			val arrayList = ArrayList<SimplePoint>(2)

			addNotNull(arrayList, filter)
			addNotNull(arrayList, filter2)
			return arrayList
		}

		private fun addNotNull(arrayList: ArrayList<SimplePoint>, filter: SimplePoint?) {
			if (filter != null)
				arrayList.add(filter)
		}

		private fun getCenterPos2(filter: List<BaggageModel>): SimplePoint? {
			var x:Double = 0.0
			var y:Double = 0.0
			val size = filter.size
			if (size == 0) {
				return null
			}
			for (i in 0..size - 1) {
				val baggageModel = filter[i]
				x += baggageModel.ds
				y += baggageModel.dm
			}
			x /= size
			y /= size
			return SimplePoint(x, y,filter.first().objClass)
		}
	}
}