import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;

public class Game {
    private Boolean Running = true;
    private final TerminalScreen screen;
    Arena arena;
    public Game(int width, int height) throws IOException{
        TerminalSize terminalSize = new TerminalSize(width, height);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();
        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        arena = new Arena(10,10);
    }

    public void draw() throws IOException{
        screen.clear();
        arena.draw(screen.newTextGraphics());
        screen.refresh();
    }

    private void processKey(KeyStroke key) throws IOException{
        switch (key.getKeyType().toString()){
            case "Character":
                if (key.getCharacter() == 'q') {
                    Running = false;
                    screen.close();
                }
                break;
            case "EOF":
                Running = false;
                break;
            default: arena.processKey(key);
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
