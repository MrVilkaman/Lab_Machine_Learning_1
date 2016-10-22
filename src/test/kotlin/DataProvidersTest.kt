package dp

import model.BaggageModel
import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import java.util.*

/**
 * Created by Zahar on 22.10.16.
 */
@RunWith(Parameterized::class)
class DataProvidersTest(val baggage: BaggageModel)  {


	companion object {
		@JvmStatic
		@Parameterized.Parameters(name = "{index}) {0}")
		fun data() : List<BaggageModel> {
			val elements = DataProviders.trainingSet
			val elements1 = DataProviders.controlSet

			val listOf = ArrayList(elements)
			listOf.addAll(elements1)
			return listOf
		}
	}

	@Test
	fun qwer() {

		val value = (3 * baggage.ds + 4 * baggage.dm) <= 30

		val i = if (value) 1 else 0
		Assert.assertEquals(i,baggage.objClass);
	}

}