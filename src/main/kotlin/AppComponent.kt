import AppModule
import GameFrame
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject (gameFrame: GameFrame)
    fun inject (gamePanel: GamePanel)
}