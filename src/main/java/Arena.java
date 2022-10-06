import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.util.ArrayList;
import java.util.List;

public class Arena {
    int width;
    int height;
    private final Hero hero;
    private List<Wall> walls;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(width/2, height/2);
        this.walls = createWalls();
    }

    public void processKey(KeyStroke key) {
        System.out.println(key);
        switch (key.getKeyType().toString()) {
            case "ArrowUp" -> moveHero(hero.moveUp());
            case "ArrowDown" -> moveHero(hero.moveDown());
            case "ArrowLeft" -> moveHero(hero.moveLeft());
            case "ArrowRight" -> moveHero(hero.moveRight());
        }
    }
    public void moveHero(Position position) {
            if (canHeroMove(position))
                hero.setPosition(position);
        }

    public boolean canHeroMove(Position position){
        return position.x < width - 1 && position.x > 0 && position.y > 0 && position.y < height - 1;
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(screen);
        for (Wall wall : walls)
            wall.draw(screen);
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }
}
