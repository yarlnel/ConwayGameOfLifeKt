import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent

class InsertAreaMouseAdapter(val gamePanel: GamePanel) : MouseAdapter() {
    override fun mousePressed(e: MouseEvent?) {
        e ?. apply {
            val mouseX = x
            val mouseY = y
            gamePanel . apply {
                injectWithGraphicsGameObjectFromClipboard(
                    xBlockStart = mouseX / blockSize,
                    yBlockStart = mouseY / blockSize
                )
                selectionAreaModel . setAreaPositions(
                    xStart = mouseX,
                    yStart = mouseY,
                    xEnd = mouseX,
                    yEnd = mouseY,
                )
                repaint()

            }
        }
        gamePanel . removeMouseListener (this)
        gamePanel . removeMouseMotionListener (this)
    }

    override fun mouseMoved(e: MouseEvent?) {
        e ?. apply {
            gamePanel . drawInsertArea(x, y, getGameObjectFromClipboard())
        }
    }
}