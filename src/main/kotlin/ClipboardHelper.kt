import java.awt.Toolkit
import java.awt.datatransfer.DataFlavor

fun getGameObjectFromClipboard () : List<List<Boolean>> {
    val clipboard = Toolkit.getDefaultToolkit().systemClipboard
    val injectData =
        clipboard
            . getData(DataFlavor.stringFlavor)
            . toString()
            . replace(" ", "")
            . replace("\t", "")
            . split("\n")
            . map { it.split("").map { e -> e == "O" || e == "o" } }

    return injectData
}