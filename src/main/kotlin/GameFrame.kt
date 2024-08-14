import java.awt.BorderLayout
import java.awt.Color
import java.awt.FlowLayout
import java.awt.Toolkit
import javax.inject.Inject
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants
enum class GameMode {
    SELECTION_MODE,
    EVAL_MODE,
    INSERT_MODE,
    WITHOUT_MODE
}

class GameFrame : JFrame () {

    private val _size by lazy {
        Toolkit.getDefaultToolkit().screenSize
    }
    @Inject lateinit var mainGamePanel : GamePanel

    @Inject lateinit var selectionAreaMouseAdapter: SelectionAreaMouseAdapter

    @Inject lateinit var hotKeyListener: HotKeyListener

    private val evalModeButton = JButton ("Перейти в режим исполнения игры") . apply {
        background = Color.GREEN
        addActionListener {
            text = if (mainGamePanel . isEvalMode) {
                mainGamePanel . stopEvalMode()
                "Перейти в режим исполнения игры"
            } else {
                mainGamePanel . startEvalMode()
                "Вернуться в режим редактирования"
            }
            mainGamePanel . isEvalMode = ! mainGamePanel . isEvalMode

            doSwitchToAnotherMode (GameMode.EVAL_MODE)
        }
    }

    @Inject lateinit var insertAreaMouseAdapter : InsertAreaMouseAdapter

    private val insertsAreaButton = JButton ("Вставить") . apply {
        background = Color.CYAN
        addActionListener {
            mainGamePanel . apply {
                isInsertMode = true
                doSwitchToAnotherMode(GameMode.INSERT_MODE)
                addMouseListener(insertAreaMouseAdapter)
                addMouseMotionListener(insertAreaMouseAdapter)
            }
        }
    }

    private val selectionAreaButton = JButton ("Режим выделения") . apply {
        background = Color.PINK
        addActionListener {
            mainGamePanel . apply {
                isSelectionMod = true
                addMouseListener(selectionAreaMouseAdapter)
                addMouseMotionListener(selectionAreaMouseAdapter)
            }
        }
    }

    private val clearGridSystemButton = JButton("Отчистить") . apply {
        background = Color.magenta
        addActionListener {
            mainGamePanel . isEvalMode = false
            mainGamePanel . clearGridSystem ()
        }
    }

    fun doSwitchToAnotherMode (currentMode : GameMode = GameMode.WITHOUT_MODE) {
        when {
            currentMode != GameMode.SELECTION_MODE ->
                mainGamePanel . apply {
                    removeMouseListener(selectionAreaMouseAdapter)
                    removeMouseMotionListener(selectionAreaMouseAdapter)
                    isSelectionMod  = false
                }
            currentMode != GameMode.EVAL_MODE -> {
                mainGamePanel . isEvalMode = false
                mainGamePanel . apply {
                    canAddNewBlock = false
                }
            }

            currentMode != GameMode.INSERT_MODE -> {
                mainGamePanel . isInsertMode = false
                mainGamePanel . apply {
                    removeMouseListener(insertAreaMouseAdapter)
                    removeMouseMotionListener(insertAreaMouseAdapter)
                    selectionAreaModel . setAreaPositions()
                }
            }

            currentMode != GameMode.WITHOUT_MODE -> {

            }
        }
    }

    private val flowPanel = JPanel () . apply {
        layout = FlowLayout ()
        add(evalModeButton)
        add(selectionAreaButton)
        add(insertsAreaButton)
        add(clearGridSystemButton)
    }

    init {

       dagger . inject(this)

        title = "GameOfLife"
        setSize(_size.width, _size.height)

        contentPane . add (
            BorderLayout.CENTER,
            mainGamePanel
        )
        contentPane . add(
            BorderLayout.SOUTH,
            flowPanel
        )
        isFocusable = true

        addKeyListener(hotKeyListener)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isVisible = true
    }
}