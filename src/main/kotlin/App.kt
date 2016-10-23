import dp.DataProviders
import graph.DrawGraph
import utils.LabUtils
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

fun main(args: Array<String>) {
	val items = DataProviders.trainingSet
	val controlSet = DataProviders.controlSet

//	TableUtils.printTable("Обучающая выборка", items)
//	TableUtils.printTable("Контрольная выборка", controlSet)

	val centerPos = LabUtils.getCenterPos(items)


	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(items, controlSet, centerPos)
	}
}

