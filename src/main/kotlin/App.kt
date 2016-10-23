import classification.Сlassification
import classification.СlassificationCos
import classification.СlassificationEuclid
import classification.СlassificationTanimoto
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

	TableUtils.printTable("Обучающая выборка", items)
	TableUtils.printTable("Контрольная выборка", controlSet)

	val centerPos = LabUtils.getCenterPos(items)

	val arrayList = listOf<Сlassification>(СlassificationCos(), СlassificationEuclid(), СlassificationTanimoto())
	TableUtils.printTable("Обучающая выборка", items, arrayList,centerPos)
	TableUtils.printTable("Контрольная выборка", controlSet,arrayList,centerPos)

	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(items, controlSet, centerPos)
	}
}

