import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.processing.Generated;
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
public final class InsertAreaMouseAdapter_Factory implements Factory<InsertAreaMouseAdapter> {
  private final Provider<GamePanel> gamePanelProvider;

  public InsertAreaMouseAdapter_Factory(Provider<GamePanel> gamePanelProvider) {
    this.gamePanelProvider = gamePanelProvider;
  }

  @Override
  public InsertAreaMouseAdapter get() {
    return newInstance(gamePanelProvider.get());
  }

  public static InsertAreaMouseAdapter_Factory create(Provider<GamePanel> gamePanelProvider) {
    return new InsertAreaMouseAdapter_Factory(gamePanelProvider);
  }

  public static InsertAreaMouseAdapter newInstance(GamePanel gamePanel) {
    return new InsertAreaMouseAdapter(gamePanel);
  }
}
