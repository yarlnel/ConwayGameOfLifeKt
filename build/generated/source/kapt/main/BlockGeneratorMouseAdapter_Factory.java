import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BlockGeneratorMouseAdapter_Factory implements Factory<BlockGeneratorMouseAdapter> {
  private final Provider<GamePanel> gamePanelProvider;

  public BlockGeneratorMouseAdapter_Factory(Provider<GamePanel> gamePanelProvider) {
    this.gamePanelProvider = gamePanelProvider;
  }

  @Override
  public BlockGeneratorMouseAdapter get() {
    return newInstance(gamePanelProvider.get());
  }

  public static BlockGeneratorMouseAdapter_Factory create(Provider<GamePanel> gamePanelProvider) {
    return new BlockGeneratorMouseAdapter_Factory(gamePanelProvider);
  }

  public static BlockGeneratorMouseAdapter newInstance(GamePanel gamePanel) {
    return new BlockGeneratorMouseAdapter(gamePanel);
  }
}
