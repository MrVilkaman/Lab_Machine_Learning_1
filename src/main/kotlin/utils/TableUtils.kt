package utils

import classification.Сlassification
import model.BaggageModel
import model.SimplePoint
import model.toBaggage
import java.util.*

/**
 * Created by Zahar on 22.10.16.
 */

class TableUtils {
	companion object {
		private val count = 4
		private val s = "| %${count}s | %${count}s | %${count}s | %${count}s |"

//		fun printTable(tableName: String, items: ArrayList<BaggageModel>) {
//
//			println(tableName)
//			println(s.format("№", "ds", "dm", "cl"))
//
//			items.forEachIndexed { i, pair ->
//				printRow(i, pair.ds.toInt(), pair.dm.toInt(), pair.objClass)
//			}
//			println()
//
//		}
//
//		private fun printRow(i: Int, ds: Int, dm: Int, second: Int) {
//			println(s.format(i, ds, dm, second))
//		}

		fun printTable(tableName: String, items: ArrayList<BaggageModel>, arrayList: List<Сlassification>, centerPos: ArrayList<SimplePoint>) {

			println(tableName)
			var message = "| %${count}s | %${count}s | %${count}s | %${count}s | %${count}s | %${count}s | %${count}s | %${count}s | %${count}s | %${count}s |"
			println(message.format("№", "ds", "dm", "cl", "cos0", "cos1", "Pe0", "Pe1", "Pt1", "Pt1"))

			val MAX_CLASS = 2
			items.forEachIndexed { i, pair ->
				val arr = ArrayList<Double>(arrayList.size * MAX_CLASS)
				for (k in 0..arrayList.size - 1) {
					for (j in 0..MAX_CLASS - 1) {
						arr.add(arrayList[k].doWork(pair, centerPos[j].toBaggage()))
					}
				}
				printRow(i, pair.ds.toInt(), pair.dm.toInt(), pair.objClass, arr)

			}
			println()
		}

		private fun printRow(i: Int, ds: Int, dm: Int, clas: Int, second: ArrayList<Double>) {
			var message = "| %${count}s | %${count}s | %${count}s | %${count}s |"

			second.forEach {
				message += " ${it.format(2)} |"
			}
			println(message.format(i, ds.toInt(), dm.toInt(), clas))
		}

		fun Double.format(digits: Int) = java.lang.String.format("%$count.${digits}f", this)
	}
}