package classification

import model.BaggageModel
import java.util.*

/**
 * Created by Zahar on 23.10.16.
 */

class KMeans(val distAlg: Сlassification) {

	fun classifyKNN(trainData: ArrayList<BaggageModel>, testData: ArrayList<BaggageModel>, k: Int, numberOfClasses: Int) {

		for (i in 0..testData.size - 1) {
			val baggageModel = testData[i]

			val set: ArrayList<Pair<BaggageModel, Double>> = ArrayList()
			for (j in 0..trainData.size - 1) {
				val baggageModelTrain = trainData[j]
				val doWork = dist(baggageModelTrain, baggageModel)
				set.add(Pair(baggageModelTrain, doWork))
			}

			Collections.sort(set) { t, t2 -> if (t.second < t2.second) -1 else 1 }


			val subList = set.subList(0, k)
			var ss = "${baggageModel.ds} ${baggageModel.dm} ${baggageModel.objClass} | "
			for (ii in 0..subList.size - 1) {
				ss += subList[ii].first.objClass.toString()
			}
			println(ss)
		}

	}

	fun dist(a: BaggageModel, b: BaggageModel): Double = distAlg.doWork(a, b)
}

/*
* def classifyKNN (trainData, testData, k, numberOfClasses):
    #Euclidean distance between 2-dimensional point
    def dist (a, b):
        return math.sqrt((a[0] - b[0])**2 + (a[1] - b[1])**2)
    testLabels = []
    for testPoint in testData:
        #Claculate distances between test point and all of the train points
        testDist = [ [dist(testPoint, trainData[i][0]), trainData[i][1]] for i in range(len(trainData))]
        #How many points of each class among nearest K
        stat = [0 for i in range(numberOfClasses)]
        for d in sorted(testDist)[0:k]:
            stat[d[1]] += 1
        #Assign a class with the most number of occurences among K nearest neighbours
        testLabels.append( sorted(zip(stat, range(numberOfClasses)), reverse=True)[0][1] )
    return testLabels
*
* */