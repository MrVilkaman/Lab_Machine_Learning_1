package graph

import model.BaggageModel
import java.awt.*
import java.util.*
import javax.swing.JFrame
import javax.swing.JPanel

@SuppressWarnings("serial")
class DrawGraph(private val scores: ArrayList<BaggageModel>) : JPanel() {

	override fun paintComponent(g: Graphics) {
		super.paintComponent(g)
		val g2 = g as Graphics2D
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)

		val xScale = (width.toDouble() - 2 * BORDER_GAP) / X_HATCH_CNT
		val yScale = (height.toDouble() - 2 * BORDER_GAP) / Y_HATCH_CNT

		val graphPoints = ArrayList<ColorPoint>()
		for (i in scores.indices) {
			val baggageModel = scores[i]
			val x1 = (baggageModel.ds * xScale + BORDER_GAP).toInt()
			val y1 = ((Y_HATCH_CNT - baggageModel.dm) * yScale + BORDER_GAP).toInt()
			val color = if (baggageModel.objClass == 0) GRAPH_POINT_COLOR_FALSE else GRAPH_POINT_COLOR_TRUE
			graphPoints.add(ColorPoint(x1, y1,color))
		}
		drawGrid(g2, xScale, yScale)


		for (i in graphPoints.indices) {
			val colorPoint = graphPoints[i]
			g2.color = colorPoint.color
			val x = colorPoint.x - GRAPH_POINT_WIDTH / 2
			val y = colorPoint.y - GRAPH_POINT_WIDTH / 2
			val ovalW = GRAPH_POINT_WIDTH
			val ovalH = GRAPH_POINT_WIDTH
			g2.fillOval(x, y, ovalW, ovalH)
		}
	}

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
		private val GRAPH_POINT_COLOR_CONTROL = Color(0, 255, 0)

		private val GRAPH_STROKE = BasicStroke(3f)

		private val GRAPH_POINT_WIDTH = 12
		private val Y_HATCH_CNT = 10
		private val X_HATCH_CNT = 10

		fun createAndShowGui(scores: ArrayList<BaggageModel>) {

			val mainPanel = DrawGraph(scores)

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
