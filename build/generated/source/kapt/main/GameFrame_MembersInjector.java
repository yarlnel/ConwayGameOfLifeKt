import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class GameFrame_MembersInjector implements MembersInjector<GameFrame> {
  private final Provider<GamePanel> mainGamePanelProvider;

  private final Provider<SelectionAreaMouseAdapter> selectionAreaMouseAdapterProvider;

  private final Provider<HotKeyListener> hotKeyListenerProvider;

  private final Provider<InsertAreaMouseAdapter> insertAreaMouseAdapterProvider;

  public GameFrame_MembersInjector(Provider<GamePanel> mainGamePanelProvider,
      Provider<SelectionAreaMouseAdapter> selectionAreaMouseAdapterProvider,
      Provider<HotKeyListener> hotKeyListenerProvider,
      Provider<InsertAreaMouseAdapter> insertAreaMouseAdapterProvider) {
    this.mainGamePanelProvider = mainGamePanelProvider;
    this.selectionAreaMouseAdapterProvider = selectionAreaMouseAdapterProvider;
    this.hotKeyListenerProvider = hotKeyListenerProvider;
    this.insertAreaMouseAdapterProvider = insertAreaMouseAdapterProvider;
  }

  public static MembersInjector<GameFrame> create(Provider<GamePanel> mainGamePanelProvider,
      Provider<SelectionAreaMouseAdapter> selectionAreaMouseAdapterProvider,
      Provider<HotKeyListener> hotKeyListenerProvider,
      Provider<InsertAreaMouseAdapter> insertAreaMouseAdapterProvider) {
    return new GameFrame_MembersInjector(mainGamePanelProvider, selectionAreaMouseAdapterProvider, hotKeyListenerProvider, insertAreaMouseAdapterProvider);
  }

  @Override
  public void injectMembers(GameFrame instance) {
    injectMainGamePanel(instance, mainGamePanelProvider.get());
    injectSelectionAreaMouseAdapter(instance, selectionAreaMouseAdapterProvider.get());
    injectHotKeyListener(instance, hotKeyListenerProvider.get());
    injectInsertAreaMouseAdapter(instance, insertAreaMouseAdapterProvider.get());
  }

  @InjectedFieldSignature("GameFrame.mainGamePanel")
  public static void injectMainGamePanel(GameFrame instance, GamePanel mainGamePanel) {
    instance.mainGamePanel = mainGamePanel;
  }

  @InjectedFieldSignature("GameFrame.selectionAreaMouseAdapter")
  public static void injectSelectionAreaMouseAdapter(GameFrame instance,
      SelectionAreaMouseAdapter selectionAreaMouseAdapter) {
    instance.selectionAreaMouseAdapter = selectionAreaMouseAdapter;
  }

  @InjectedFieldSignature("GameFrame.hotKeyListener")
  public static void injectHotKeyListener(GameFrame instance, HotKeyListener hotKeyListener) {
    instance.hotKeyListener = hotKeyListener;
  }

  @InjectedFieldSignature("GameFrame.insertAreaMouseAdapter")
  public static void injectInsertAreaMouseAdapter(GameFrame instance,
      InsertAreaMouseAdapter insertAreaMouseAdapter) {
    instance.insertAreaMouseAdapter = insertAreaMouseAdapter;
  }
}
