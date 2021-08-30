import java.awt.Frame
import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor
import java.awt.datatransfer.StringSelection
import java.util.*
import kotlin.concurrent.timerTask


fun main() {
    GameFrame ()

    /*
    BlockGrid (16 , 8) . apply {
        listOf(3 to 1, 3 to 2, 3 to 3, 2 to 3, 1 to 2).forEach { pair ->
            changeBlockColor(pair)
        }
        printBlocks()
        for (i in 1..28)
        {
            eval()
            printBlocks()
        }
    }


*/
/*
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard

    val injectData =
        clipboard
          . getData(DataFlavor.stringFlavor)
          . toString()
            . replace(" ", "")
            . replace("\t", "")
            . split("\n")
            . map { it.split("").map { e -> e == "O" || e == "o" } }

    println("\n\n\n$injectData\n\n\n")

    BlockGrid (16, 16) . apply {
        injectGameObject(injectData, 0, 0)
        printBlocks()
    }
    /*
    ..O..
    .OOO.
    ..O..

    OOO
    OOO
    OOO
     */

*/
}