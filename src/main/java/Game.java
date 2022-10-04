import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    Boolean Running = true;
    private TerminalScreen screen;
    Hero hero;
    public Game(int width, int height) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        hero = new Hero(10,10);
    }

    public void draw() throws IOException{
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }
    private void processKey(KeyStroke key) throws IOException{
        System.out.println(key);
        switch (key.getKeyType().toString()){
            case "ArrowUp":
                hero.moveUp();
                break;
            case "ArrowDown":
                hero.moveDown();
                break;
            case "ArrowLeft":
                hero.moveLeft();
                break;
            case "ArrowRight":
                hero.moveRight();
                break;
            case "Character":
                if (key.getCharacter() == 'q') {
                    Running = false;
                    screen.close();
                }
                break;
            case "EOF":
                Running = false;
                break;
        }
    }
    public void run() throws IOException{
        while (Running) {
            draw();
            KeyStroke key = screen.readInput();
            processKey(key);
        }
    }

}
