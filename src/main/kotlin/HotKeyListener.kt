import java.awt.event.KeyEvent
import java.awt.event.KeyListener
import javax.inject.Inject

typealias HotkeyActionHandler = (HotKeyActions) -> Unit
class HotKeyListener @Inject constructor() : KeyListener {

    private var hotkeyActionHandler: HotkeyActionHandler = {
        println("fdsfsdfsdf")
    }

    fun onHotkeyAction(hotkeyActionHandler: HotkeyActionHandler) {
        this.hotkeyActionHandler = hotkeyActionHandler
    }
    private fun obtainKeyCode(keyCode: Int) {
        when(keyCode) {
            KeyEvent.VK_R -> hotkeyActionHandler(HotKeyActions.RoundClipboardFigure)
        }
    }

    override fun keyTyped(e: KeyEvent?) {

    }

    override fun keyPressed(e: KeyEvent?) {

    }

    override fun keyReleased(e: KeyEvent?) {

    }
}

enum class HotKeyActions {
    RoundClipboardFigure
}