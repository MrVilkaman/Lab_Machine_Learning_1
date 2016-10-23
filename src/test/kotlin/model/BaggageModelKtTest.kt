package model

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*
import BaseTestCase

/**
 * Created by Zahar on 23.10.16.
 */
class BaggageModelKtTest: BaseTestCase() {

	@Test
	fun norma() {
		val norma = BaggageModel(3.0, 4.0, 0).norma()
		Assert.assertEquals(5.0,norma,0.5)
	}

	@Test
	fun scalar() {

		val scalar = BaggageModel(1.0, 8.0, 0).scalar(BaggageModel(3.0, 5.0, 0))

		Assert.assertEquals(43.0,scalar,0.5)
	}

}