import classification.*
import dp.DataProviders
import graph.DrawGraph
import utils.LabUtils
import utils.TableUtils
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

fun main(args: Array<String>) {
	val items = DataProviders.trainingSet
	val controlSet = DataProviders.controlSet

	println("Исходные денные:")
	TableUtils.printTable("Обучающая выборка", items)
	TableUtils.printTable("Контрольная выборка", controlSet)

	val centerPos = LabUtils.getCenterPos(items)

	println()
	println("Классификация сравнение с эталоном:")
	val arrayList = listOf(СlassificationCos(), СlassificationEuclid(), СlassificationTanimoto())
	TableUtils.printTable("Обучающая выборка", items, arrayList, centerPos)
	TableUtils.printTable("Контрольная выборка", controlSet, arrayList, centerPos)

	println()
	println("Классификация K-means:")
	arrayList.forEach {
		KMeans(it).classifyKNN(items, controlSet, 3)
	}

	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(items, controlSet, centerPos)
	}
}


