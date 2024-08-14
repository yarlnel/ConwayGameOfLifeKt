import GameFrame
import GamePanel
import InsertAreaMouseAdapter
import SelectionAreaMouseAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {
//    @Provides
//    @Singleton
//    fun provideBlockGrid () : BlockGrid
//        = BlockGrid(16, 16)

    @Provides
    @Singleton
    fun provideGamePanel () : GamePanel
        = GamePanel()
}