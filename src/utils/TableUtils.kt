package utils

import model.BaggageModel
import java.util.*

/**
 * Created by Zahar on 22.10.16.
 */

class TableUtils {
	private val count = 3
	private val s = "| %${count}s | %${count}s | %${count}s | %${count}s |"

	fun printTable(tableName:String, items: ArrayList<Pair<BaggageModel, Boolean>>) {

		println(tableName)
		println(s.format("№","ds","dm", "cl"))

		items.forEachIndexed { i, pair ->
			val first = pair.first
			printRow(i, first.ds, first.dm, pair.second)
		}
		println()

	}

	private fun printRow(i: Int, ds: Int, dm: Int, second: Boolean) {
		println(s.format(i,ds,dm, second.toInt()))
	}

}


fun Boolean.toInt():Int = if(this) 1 else 0