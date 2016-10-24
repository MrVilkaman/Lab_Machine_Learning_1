import classification.KMeans
import classification.СlassificationCos
import classification.СlassificationEuclid
import classification.СlassificationTanimoto
import dp.DataProviders
import graph.DrawGraph
import model.BaggageModel
import utils.LabUtils
import utils.TableUtils
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

val needRandom: Boolean = false

fun main(args: Array<String>) {


	val items: ArrayList<BaggageModel> = if (needRandom) {
		val arrayList = ArrayList<BaggageModel>()
		val random = Random()
		for (i in 0..9) {
			val ds = ge(random)
			val dm = ge(random)
			val value = (3 * ds + 4 * dm) <= 30

			val cla = if (value) 1 else 0
			arrayList.add(BaggageModel(ds, dm, cla, i))
		}
		arrayList
	} else {
		DataProviders.trainingSet
	}

	val controlSet = DataProviders.controlSet

//	println("Исходные денные:")
//	TableUtils.printTable("Обучающая выборка", items)
//	TableUtils.printTable("Контрольная выборка", controlSet)

	val centerPos = LabUtils.getCenterPos(items)

	println()
	println("Классификация сравнение с эталоном:")
	val arra = listOf(СlassificationCos(), СlassificationEuclid(), СlassificationTanimoto())
	TableUtils.printTable("Обучающая выборка", items, arra, centerPos)
	TableUtils.printTable("Контрольная выборка", controlSet, arra, centerPos)

	println("Центры кластеров:")
	centerPos.forEachIndexed { i, simplePoint ->
		val format = simplePoint.x.format(2)
		val format2 = simplePoint.y.format(2)
		println("$i) $format, $format2")
	}

	println()
	println("Классификация K-means:")
	arra.forEach {
		KMeans(it).classifyKNN(items, controlSet, 3)
	}

	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(items, controlSet, centerPos)
	}


}

private fun ge(random: Random): Double {
	val nextInt = random.nextInt(99).toDouble()
	return nextInt / 10
}


fun Double.format(digits: Int) = java.lang.String.format("%.${digits}f", this)


