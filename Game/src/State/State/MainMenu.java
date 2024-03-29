package State.State;

import UI.UI;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import static helpers.Artist.*;
import UI.Button;

public class MainMenu {

    private Texture background;
    private UI menuUI;

    public MainMenu() {
        background = QuickLoad("menu");
        menuUI = new UI();
        setup();
    }

    private void setup() {
        menuUI.getButtons().add(new Button("Play", QuickLoad("play"), WIDTH/2 - 32, HEIGHT / 2 + 150));
    }

    private void updateButton() {
        if (Mouse.isButtonDown(0)) {
            System.out.println(Mouse.getX() + " " + Mouse.getY());
            if (menuUI.isButtonClicked("Play")) {
                StateManager.setState(StateManager.GameState.GAME);
                System.out.println("Play is clicked");
            }
        }
    }

    public void update() {
        drawQuadTex(background, -32, 0, 1440, 768);
        updateButton();
        menuUI.draw();
    }

}
