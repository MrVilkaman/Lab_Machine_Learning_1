import dp.DataProviders
import graph.DrawGraph
import model.BaggageModel
import model.BaggageModelColored
import utils.LabUtils
import utils.TableUtils
import java.awt.Color
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

fun main(args: Array<String>) {
	val items = DataProviders.trainingSet
	TableUtils.printTable("Обучающая выборка", items)
	TableUtils.printTable("Контрольная выборка", DataProviders.controlSet)

	val centerPos = LabUtils.getCenterPos(items)

	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(items, DataProviders.controlSet, centerPos)
	}
}

