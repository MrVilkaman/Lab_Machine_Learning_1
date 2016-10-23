import dp.DataProviders
import graph.DrawGraph
import model.BaggageModel
import model.BaggageModelColored
import utils.TableUtils
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

fun main(args: Array<String>) {
	TableUtils.printTable("Обучающая выборка", DataProviders.trainingSet)
	TableUtils.printTable("Контрольная выборка", DataProviders.controlSet)

	val pointSet:ArrayList<BaggageModelColored> = ArrayList()
	SwingUtilities.invokeLater {
		DrawGraph.createAndShowGui(DataProviders.trainingSet, DataProviders.controlSet, pointSet)
	}
}
