package utils

import model.BaggageModel
import java.util.*

/**
 * Created by Zahar on 22.10.16.
 */

class TableUtils {
	companion object {
		private val count = 3
		private val s = "| %${count}s | %${count}s | %${count}s | %${count}s |"

		fun printTable(tableName: String, items: ArrayList<BaggageModel>) {

			println(tableName)
			println(s.format("№", "ds", "dm", "cl"))

			items.forEachIndexed { i, pair ->
				printRow(i, pair.ds, pair.dm, pair.objClass)
			}
			println()

		}

		private fun printRow(i: Int, ds: Int, dm: Int, second: Int) {
			println(s.format(i, ds, dm, second))
		}
	}
}