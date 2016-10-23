package classification

import model.BaggageModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by Zahar on 23.10.16.
 */
class СlassificationTest {

	@Test
	fun doWork_cos() {
		val doWork = СlassificationCos().doWork(BaggageModel(0.0,10.0,0),BaggageModel(4.0,4.0,0))
		assertEquals(0.7071,doWork,0.001)
	}

	@Test
	fun doWork_euclid() {
		val doWork = СlassificationEuclid().doWork(BaggageModel(0.0,10.0,0),BaggageModel(4.0,4.0,0))
		assertEquals(7.211,doWork,0.001)
	}


	@Test
	fun doWork_tanimoto() {
		val doWork = СlassificationTanimoto().doWork(BaggageModel(0.0,10.0,0),BaggageModel(4.0,4.0,0))
		assertEquals(0.4347,doWork,0.001)
	}
}