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
public final class SelectionAreaMouseAdapter_Factory implements Factory<SelectionAreaMouseAdapter> {
  private final Provider<GamePanel> gamePanelProvider;

  public SelectionAreaMouseAdapter_Factory(Provider<GamePanel> gamePanelProvider) {
    this.gamePanelProvider = gamePanelProvider;
  }

  @Override
  public SelectionAreaMouseAdapter get() {
    return newInstance(gamePanelProvider.get());
  }

  public static SelectionAreaMouseAdapter_Factory create(Provider<GamePanel> gamePanelProvider) {
    return new SelectionAreaMouseAdapter_Factory(gamePanelProvider);
  }

  public static SelectionAreaMouseAdapter newInstance(GamePanel gamePanel) {
    return new SelectionAreaMouseAdapter(gamePanel);
  }
}
