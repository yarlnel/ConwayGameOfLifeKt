import java.awt.Graphics
import java.lang.Thread.sleep
import kotlin.collections.toMutableList

fun setInterval (millis: Long, lam: () -> Any) {
    val t = Thread {
        while (true) {
            sleep(1000)
            lam ()
        }
    }.run()
}


fun List<List<Boolean>> . getObjectWeightAndHeightPair () : Pair<Int, Int>
    = this [ 0 ] . size to this . size

class BlockGrid (val yBlockCount: Int, val xBlockCount: Int) {
    val blocks : MutableList<MutableList<Boolean>> = mutableListOf()
    val weightsBlocks : MutableList<MutableList<Int>> = mutableListOf()
    init {
        for (yGridNumber in 0 until  yBlockCount) {
            blocks.plusAssign((0 until  xBlockCount) . map { false } . toMutableList())
            weightsBlocks += (0 until  xBlockCount) . map { 0 } . toMutableList()
        }
    }

    fun clearAll () {
        blocks . forEachIndexed { lineIndex, _ ->
            blocks [ lineIndex ] . forEachIndexed { elemIndex, _ ->
                blocks [ lineIndex ] [ elemIndex ] = false
            }
        }
    }



    fun eval () {

        for (yPosition in 0 until yBlockCount)
            for (xPosition in 0 until xBlockCount) {
                var counterOfBlackBlock = 0

                try {
                        listOf(
                            yPosition + 1 to xPosition,
                            yPosition - 1 to xPosition,

                            yPosition to xPosition + 1,
                            yPosition to xPosition - 1,

                            yPosition + 1 to xPosition + 1,
                            yPosition - 1 to xPosition - 1,

                            yPosition - 1 to xPosition + 1,
                            yPosition + 1 to xPosition - 1,

                        ) . forEach { pair ->
                            if (blocks [pair.first] [pair.second]) counterOfBlackBlock++
                        }
                    } catch (ex: Exception) {

                    }

                weightsBlocks [yPosition] [xPosition] = counterOfBlackBlock

            }
        for (yPosition in 0 until yBlockCount)
            for (xPosition in 0 until xBlockCount)
            {
                when {
                    weightsBlocks [yPosition] [xPosition] == 3 ->
                        blocks [yPosition] [xPosition] = true

                    weightsBlocks [yPosition] [xPosition] < 2 ||
                            weightsBlocks [yPosition] [xPosition] > 3->
                        blocks [yPosition] [xPosition] = false
                }

            }

    }

    fun changeBlockColor (idFirstSecond: Pair<Int, Int>) {

            val elem = blocks [idFirstSecond.first] [idFirstSecond.second]

            blocks [idFirstSecond.first] [idFirstSecond.second] = !elem

    }

    fun injectGameObject (gameObject : List<List<Boolean>>, xBlockStart : Int, yBlockStart : Int) {
        if (blocks . size < (yBlockStart + gameObject . size)) {
            println("Y max error !!!")
            return
        }
        if (blocks [0] . size < (xBlockStart + gameObject [0] . size)) {
            println("X max error !!!")
            return
        }
        gameObject . forEachIndexed { lineIndex, line ->
            line . forEachIndexed { elemIndex, elem ->
                blocks [lineIndex + yBlockStart] [elemIndex + xBlockStart] = elem
            }
        }
    }


    fun printBlocks () {
        print("\n\n\n")
        for (line in blocks) {
            println()
            for (e in line)
                print("${if (e) "O" else "."}\t\t")
        }
    }
    fun printWeights () {
        print("\n\n\n")
        for (line in weightsBlocks) {
            println()
            for (e in line)
                print("$e\t\t")
        }
    }
}
/*
11 21 31
12 22 32
13 23 33
 */