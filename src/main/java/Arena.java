import com.googlecode.lanterna.TextCharacter;
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
            case "ArrowUp":
                moveHero(hero.moveUp());
                break;
            case "ArrowDown":
                moveHero(hero.moveDown());
                break;
            case "ArrowLeft":
                moveHero(hero.moveLeft());
                break;
            case "ArrowRight":
                moveHero(hero.moveRight());
                break;
        }
    }
    public void moveHero(Position position) {
            if (canHeroMove(position))
                hero.setPosition(position);
        }

    public boolean canHeroMove(Position position){
        if (position.x > width || position.x < 0 || position.y < 0 || position.y > height){
            return false;
        }
        else
            return true;

    }

    public void draw(TerminalScreen screen){
        hero.draw(screen);
    }
}
