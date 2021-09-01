import GameFrame
import GamePanel
import InsertAreaMouseAdapter
import SelectionAreaMouseAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
    @Provides
    @Singleton
    fun provideGamePanel () : GamePanel
        = GamePanel(20)
}