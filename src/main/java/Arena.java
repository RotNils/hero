import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.TerminalScreen;
public class Arena {
    int width;
    int height;
    private final Hero hero;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(width/2, height/2);
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
        return position.x <= width && position.x >= 0 && position.y >= 0 && position.y <= height;
    }

    public void draw(TerminalScreen screen){
        hero.draw(screen);
    }
}
