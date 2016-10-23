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
		val items = arrayListOf(BaggageModel(0f,0f,1),BaggageModel(1f,1f,1))
		val centerPos = LabUtils.getCenterPos(items)

		Assertions.assertThat(centerPos).contains(SimplePoint(0.5f,0.5f)).hasSize(1)
	}

	@Test
	fun getCenterPos_twoClass() {
		val items = arrayListOf(BaggageModel(0f,0f,1),BaggageModel(1f,1f,1),BaggageModel(0f,0f,0),BaggageModel(4f,4f,0))
		val centerPos = LabUtils.getCenterPos(items)

		Assertions.assertThat(centerPos).contains(SimplePoint(0.5f,0.5f),SimplePoint(2f,2f)).hasSize(2)
	}

}

@RunWith(MockitoJUnitRunner::class)
open class BaseTestCase {

}
