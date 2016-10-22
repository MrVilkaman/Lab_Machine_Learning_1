import graph.DrawGraph
import model.BaggageModel
import utils.TableUtils
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */


val trainingSet: ArrayList<BaggageModel> = ArrayList()
val controlSet: ArrayList<BaggageModel> = ArrayList()


fun main(args: Array<String>) {

	init()

	val tableUtils = TableUtils()
	tableUtils.printTable("Обучающая выборка", trainingSet)
	tableUtils.printTable("Контрольная выборка", controlSet)


	SwingUtilities.invokeLater { DrawGraph.createAndShowGui() }
}

fun init() {
	trainingSet.add(BaggageModel(1, 2, 1))
	trainingSet.add(BaggageModel(2, 3, 1))
	trainingSet.add(BaggageModel(2, 3, 1))
	trainingSet.add(BaggageModel(5, 3, 1))
	trainingSet.add(BaggageModel(10, 0, 1))
	trainingSet.add(BaggageModel(0, 7, 1))
	trainingSet.add(BaggageModel(5, 6, 0))
	trainingSet.add(BaggageModel(5, 1, 0))
	trainingSet.add(BaggageModel(0, 1, 0))
	trainingSet.add(BaggageModel(5, 5, 0))

	controlSet.add(BaggageModel(0, 0, 1))
	controlSet.add(BaggageModel(1, 5, 1))
	controlSet.add(BaggageModel(7, 7, 0))
}
