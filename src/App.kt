import graph.DrawGraph
import model.BaggageModel
import utils.TableUtils
import java.util.*
import javax.swing.SwingUtilities

/**
 * Created by Zahar on 22.10.16.
 */


val trainingSet: ArrayList<Pair<BaggageModel, Boolean>> = ArrayList()
val controlSet: ArrayList<Pair<BaggageModel, Boolean>> = ArrayList()


fun main(args: Array<String>) {

	init()

	val tableUtils = TableUtils()
	tableUtils.printTable("Обучающая выборка",trainingSet)
	tableUtils.printTable("Контрольная выборка",controlSet)


	SwingUtilities.invokeLater { DrawGraph.createAndShowGui() }
}

fun init() {
	trainingSet.add(Pair(BaggageModel(1,2),true))
	trainingSet.add(Pair(BaggageModel(2,3),true))
	trainingSet.add(Pair(BaggageModel(2,3),true))
	trainingSet.add(Pair(BaggageModel(5,3),true))
	trainingSet.add(Pair(BaggageModel(10,0),true))
	trainingSet.add(Pair(BaggageModel(0,7),true))
	trainingSet.add(Pair(BaggageModel(5,6),false))
	trainingSet.add(Pair(BaggageModel(5,10),false))
	trainingSet.add(Pair(BaggageModel(0,10),false))
	trainingSet.add(Pair(BaggageModel(5,5),false))

	controlSet.add(Pair(BaggageModel(0,0),true))
	controlSet.add(Pair(BaggageModel(1,5),true))
	controlSet.add(Pair(BaggageModel(7,7),false))
}
