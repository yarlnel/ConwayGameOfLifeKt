import java.awt.event.MouseEvent
import javax.inject.Inject
import javax.swing.event.MouseInputAdapter

class SelectionAreaMouseAdapter
@Inject constructor(val gamePanel: GamePanel) : MouseInputAdapter() {

    override fun mousePressed(e: MouseEvent?) {
        e ?. apply {
            gamePanel . selectionAreaModel . apply {
                gamePanel . saveObject()
                setAreaPositions(
                        xStart = x,
                        yStart = y,
                        xEnd = x,
                        yEnd = y,
                )
            }
        }
    }

    override fun mouseDragged(e: MouseEvent?) {
        e ?. apply {
            gamePanel . selectionAreaModel . setAreaPositions(
                xEnd =  x,
                yEnd =  y,
            )
        }
    }



    override fun mouseReleased(e: MouseEvent?) {
        e ?. apply {
            gamePanel . selectionAreaModel . setAreaPositions(
                xEnd =  x,
                yEnd =  y,
            )

            gamePanel . saveObject ()
        }
    }
}