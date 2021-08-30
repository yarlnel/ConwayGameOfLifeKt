import java.awt.*
import java.awt.datatransfer.DataFlavor
import java.awt.event.*
import java.util.*
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.JTextArea
import javax.swing.JTextPane
import javax.swing.event.MouseInputAdapter
import kotlin.concurrent.schedule
import kotlin.concurrent.scheduleAtFixedRate
import kotlin.properties.Delegates


class GamePanel(sizeOfBlock: Int = 20) : JPanel() {
    var blockSize: Int = sizeOfBlock


    private lateinit var gridSystem: BlockGrid

    var isEvalMode = false
    var isSelectionMod = false
    var isInsertMode = false

    private var timer = Timer ()

    fun startEvalMode() {
        timer.scheduleAtFixedRate(0, 100){
            gridSystem . eval()
            repaint()
        }
    }

    fun clearGridSystem () {
        gridSystem . clearAll()
        repaint()
    }

    fun stopEvalMode () { timer . cancel(); timer = Timer() }

    fun injectWithGraphicsGameObjectFromClipboard (xBlockStart : Int, yBlockStart : Int) {
        val injectData = getGameObjectFromClipboard()

        gridSystem . injectGameObject(injectData, xBlockStart, yBlockStart)
        repaint()
    }

    fun drawInsertArea (xStart : Int, yStart : Int, gameObject: List<List<Boolean>>) {
        selectionAreaModel . apply {
            setAreaPositions(
                xStart = xStart,
                yStart = yStart,
                xEnd = xStart + gameObject [0] . size * blockSize,
                yEnd = yStart + gameObject . size * blockSize
            )
        }
    }

    fun saveObject () {
        selectionAreaModel . apply {
            gridSystem . blocks . filterIndexed{ index, _ ->
                index > (yStart / blockSize) &&
                        index < (yEnd / blockSize)
            } . map { line ->
                line . filterIndexed {index, _ ->
                    index > (xStart / blockSize) &&
                            index < (xEnd / blockSize)
                }
            }.let { blocks ->
                print("\n\n\n")
                for (line in blocks) {
                    println()
                    for (e in line)
                        print(if (e) "O" else ".")
                }
            }
        }
    }


    private val resizeAdapter = object : ComponentAdapter () {
        override fun componentMoved(e: ComponentEvent?) {
            super.componentMoved(e)
            this@GamePanel . repaint()
            println("komp mov")
        }
        override fun componentResized(e: ComponentEvent?) {
            super.componentResized(e)
            gridSystem = BlockGrid(height / blockSize, width / blockSize)
            println("res w${gridSystem } h${height / blockSize}")
        }
    }


    val selectionAreaModel = SelectionAreaModel {
        repaint()
    }



    private fun Graphics2D.drawSelectionArea () {

        selectionAreaModel . apply {
            color = Color.GREEN
            stroke = BasicStroke(4.0f)
            drawLine(xStart, yStart, xEnd, yStart)
            drawLine(xStart, yStart, xStart, yEnd)
            drawLine(xStart, yEnd, xEnd, yEnd)
            drawLine(xEnd, yStart, xEnd, yEnd)
            color = Color.WHITE
            stroke = BasicStroke(1.0f)
        }
    }

    var canAddNewBlock = true
    private val gamePanelMouseListener = object : MouseInputAdapter() {
        override fun mouseClicked(e: MouseEvent?) {

            if (!canAddNewBlock) return
            val panel = e!! . source as? JPanel ?: return
            e.apply {
                gridSystem . changeBlockColor((y - this@GamePanel.y) / blockSize to (x - this@GamePanel.x) / blockSize)
                println("x $x; y $y")
            }

            repaint()
        }
    }



    init {

        gridSystem = BlockGrid(16, 16)

        addComponentListener(resizeAdapter)
        addMouseListener(gamePanelMouseListener)



    }

    private fun Graphics.drawGridLines () {
        val xTimes = width / blockSize
        val yTimes = height / blockSize
        // make vertical GridLines
        for (i in 0 until  xTimes)
            drawLine(i * blockSize, 0, i * blockSize, height)
        for (i in 0 until  yTimes)
            drawLine(0, i * blockSize, width, i * blockSize)
    }

    private fun Graphics.drawBlocks (blocksGrid: BlockGrid) {
        for (yPosition in 0 until blocksGrid.yBlockCount)
            for (xPosition in 0 until blocksGrid.xBlockCount) {
               try {
                   color =
                       if (blocksGrid.blocks[yPosition][xPosition])
                           Color.BLACK
                       else
                           Color.WHITE
                   fillRect(xPosition * blockSize, yPosition * blockSize, blockSize, blockSize)
                   color = Color.WHITE
               } catch (iex: IndexOutOfBoundsException) {
                   println("fuck: \ny: $yPosition\nx: $xPosition")
               }
            }


    }

    override fun paint(g: Graphics?) {
        super.paint(g)


        g?.apply {

            drawBlocks(gridSystem)

            /*
            BlockGrid(14, 12).apply {
                listOf(1 to 2, 2 to 4, 5 to 6, 7 to 5, 2 to 5) . forEach { e ->
                    changeBlockColor(e)
                }
            }
             */
            color = Color.BLACK
            drawGridLines()
/*
            selectionAreaModel . setAreaPositions(
                1 * blockSize,
                1 * blockSize,
                8 * blockSize,
                8 * blockSize
            )*/
            if (isSelectionMod || isInsertMode)
                if (selectionAreaModel . xStart != selectionAreaModel . xEnd
                    || selectionAreaModel . yStart != selectionAreaModel . yEnd)
                        (this as? Graphics2D) ?. drawSelectionArea()

        }
    }
}