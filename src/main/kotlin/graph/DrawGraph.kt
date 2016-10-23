package graph

import model.BaggageModel
import model.BaggageModelColored
import java.awt.*
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel


@SuppressWarnings("serial")
class DrawGraph(private val scores: ArrayList<BaggageModel>, private val controlSet: ArrayList<BaggageModel>,
                private val pointSet: ArrayList<BaggageModelColored>) : JPanel() {

	override fun paintComponent(g: Graphics) {
		super.paintComponent(g)
		val g2 = g as Graphics2D
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

		val xScale = (width.toDouble() - 2 * BORDER_GAP) / X_HATCH_CNT
		val yScale = (height.toDouble() - 2 * BORDER_GAP) / Y_HATCH_CNT

		val graphPoints = ArrayList<ColorPoint>()
		fillPoints(graphPoints, xScale, yScale, controlSet) { GRAPH_POINT_COLOR_CONTROL }

		val color1: (BaggageModel) -> Color = {
			if (it.objClass == 0) GRAPH_POINT_COLOR_FALSE else GRAPH_POINT_COLOR_TRUE
		}
		fillPoints(graphPoints, xScale, yScale, scores, color1)
		fillPoints(graphPoints, xScale, yScale, controlSet, color1)
		fillPoints(graphPoints, xScale, yScale, pointSet) {
			it.color
		}

		drawGrid(g2, xScale, yScale)


		for (i in graphPoints.indices) {
			val colorPoint = graphPoints[i]
			val color = colorPoint.color
			g2.color = color

			val ovalW: Float
			val ovalH: Float
			if (GRAPH_POINT_COLOR_CONTROL != color) {
				ovalW = GRAPH_POINT_WIDTH.toFloat()
				ovalH = GRAPH_POINT_WIDTH.toFloat()
			} else {
				ovalW = GRAPH_POINT_WIDTH * GRAPH_POINT_WIDTH_MULT
				ovalH = GRAPH_POINT_WIDTH * GRAPH_POINT_WIDTH_MULT
			}
			val x = colorPoint.x - ovalW / 2
			val y = colorPoint.y - ovalH / 2
			g2.fillOval(x.toInt(), y.toInt(), ovalW.toInt(), ovalH.toInt())
		}
	}

	private fun <T : BaggageModel> fillPoints(graphPoints: ArrayList<ColorPoint>, xScale: Double, yScale: Double,
	                                          arrayList: ArrayList<T>, color: (T) -> Color) {
		for (i in arrayList.indices) {
			val baggageModel = arrayList[i]
			val x1 = getX(baggageModel, xScale)
			val y1 = getY(baggageModel, yScale)
			graphPoints.add(ColorPoint(x1, y1, color(baggageModel)))
		}
	}

	private fun <T : BaggageModel> getY(baggageModel: T, yScale: Double) = ((Y_HATCH_CNT - baggageModel.dm) * yScale + BORDER_GAP).toInt()

	private fun <T : BaggageModel> getX(baggageModel: T, xScale: Double) = (baggageModel.ds * xScale + BORDER_GAP).toInt()

	private fun drawGrid(g2: Graphics2D, xScale: Double, yScale: Double) {
		// create x and y axes
		g2.drawLine(BORDER_GAP, height - BORDER_GAP, BORDER_GAP, BORDER_GAP)
		g2.drawLine(BORDER_GAP, height - BORDER_GAP, width - BORDER_GAP, height - BORDER_GAP)

		// create hatch marks for y axis.
		for (i in 0..Y_HATCH_CNT - 1) {
			val x0 = BORDER_GAP
			val x1 = GRAPH_POINT_WIDTH + BORDER_GAP
			val y0 = (yScale * i + BORDER_GAP).toInt()
			val y1 = y0
			g2.drawLine(x0, y0, x1, y1)
		}

		for (i in 0..Y_HATCH_CNT - 1) {

			val x0 = (xScale * i + BORDER_GAP).toInt()
			val x1 = x0
			val y0 = height - BORDER_GAP
			val y1 = y0 - GRAPH_POINT_WIDTH
			g2.drawLine(x0, y0, x1, y1)
		}
	}

	override fun getPreferredSize(): Dimension {
		return Dimension(PREF_W, PREF_H)
	}

	companion object {

		private val PREF_W = 640
		private val PREF_H = 480
		private val BORDER_GAP = 30

		private val GRAPH_POINT_COLOR_TRUE = Color(255, 0, 0)
		private val GRAPH_POINT_COLOR_FALSE = Color(0, 0, 255)
		private val GRAPH_POINT_COLOR_CONTROL = Color(0, 0, 0)

		private val GRAPH_POINT_WIDTH_MULT = 1.5f
		private val GRAPH_POINT_WIDTH = 12
		private val Y_HATCH_CNT = 10
		private val X_HATCH_CNT = 10

		fun createAndShowGui(scores: ArrayList<BaggageModel>, controlSet: ArrayList<BaggageModel>,
		                     pointSet: ArrayList<BaggageModelColored>) {

			val mainPanel = DrawGraph(scores, controlSet, pointSet);


			val frame = JFrame("DrawGraph")
			frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
			frame.contentPane.add(mainPanel)
			frame.pack()
			frame.isLocationByPlatform = true
			frame.isVisible = true
		}
	}
}

data class ColorPoint(val x: Int, val y: Int, val color: Color)
