package utils

import model.BaggageModel
import model.SimplePoint
import org.assertj.core.api.Assertions
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Zahar on 23.10.16.
 */
class LabUtilsTest : BaseTestCase() {

	@Test
	fun getCenterPos_oneClass() {
		val items = arrayListOf(BaggageModel(0.0,0.0,1),BaggageModel(1.0,1.0,1))
		val centerPos = LabUtils.getCenterPos(items)

		Assertions.assertThat(centerPos).contains(SimplePoint(0.5,0.5,1)).hasSize(1)
	}

	@Test
	fun getCenterPos_twoClass() {
		val items = arrayListOf(BaggageModel(0.0,0.0,1),BaggageModel(1.0,1.0,1),BaggageModel(0.0,0.0,0),BaggageModel(4.0,4.0,0))
		val centerPos = LabUtils.getCenterPos(items)

		Assertions.assertThat(centerPos).contains(SimplePoint(0.5,0.5,1),SimplePoint(2.0,2.0,0)).hasSize(2)
	}

}

@RunWith(MockitoJUnitRunner::class)
open class BaseTestCase {

}
