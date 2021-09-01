import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

fun getGameObjectFromClipboard () : List<List<Boolean>> {
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard

    return clipboard
        . getData(DataFlavor.stringFlavor)
        . toString()
        . replace(" ", "")
        . replace("\t", "")
        . split("\n")
        . map { it.split("").map { e -> e == "O" || e == "o" } }
}