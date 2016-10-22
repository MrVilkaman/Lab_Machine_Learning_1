import dp.DataProviders
import graph.DrawGraph
import model.BaggageModel
import utils.TableUtils
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */

fun main(args: Array<String>) {
	TableUtils.printTable("Обучающая выборка", DataProviders.trainingSet)
	TableUtils.printTable("Контрольная выборка", DataProviders.controlSet)

	SwingUtilities.invokeLater { DrawGraph.createAndShowGui(DataProviders.trainingSet,DataProviders.controlSet) }
}
