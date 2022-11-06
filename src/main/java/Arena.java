import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    int width;
    int height;
    private final Hero hero;
    private List<Wall> walls;
    private ArrayList<Coin> coins;
    private ArrayList<Monster> monsters;
    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        hero = new Hero(width/2, height/2);
        createWalls();
        createCoins();
        createMonster();
    }

    public void processKey(KeyStroke key) {
        switch (key.getKeyType().toString()) {
            case "ArrowUp" -> moveHero(hero.moveUp());
            case "ArrowDown" -> moveHero(hero.moveDown());
            case "ArrowLeft" -> moveHero(hero.moveLeft());
            case "ArrowRight" -> moveHero(hero.moveRight());
            default -> {
                break;
            }
        }
    }
    public void moveHero(Position position) {
            if (canHeroMove(position)) {
                hero.setPosition(position);
                verifyMonsterCollisions();
                retrieveCoins();
                moveMonster();
                verifyMonsterCollisions();
            }
        }

    public boolean canHeroMove(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position)) {
                return false;
        }
        return true;
    }

    public void draw(TextGraphics screen){
        screen.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');
        hero.draw(screen);
        for (Wall wall : walls)
            wall.draw(screen);
        for (Coin coin : coins)
            coin.draw(screen);
        for (Monster monster : monsters)
            monster.draw(screen);
    }
    private void createWalls() {
        walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
    }
    private void createCoins() {
        Random random = new Random();
        coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            coins.add(new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1));
        }
    }
    private void retrieveCoins(){
        for (Coin coin : coins){
            if (coin.getPosition().equals(hero.getPosition())) {
                coins.remove(coin);
                if(coins.isEmpty()){
                    System.out.println("YOU WIN !!!!");
                    System.exit(0);
                }
                break;
            }
        }
    }
    private void createMonster() {
        Random random = new Random();
        monsters = new ArrayList<>();
        Monster monster;
        for (int i = 0; i < 5; i++) {
            monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            if(monster.getPosition().equals(hero.getPosition())){
                i--;
            }
            else {
                monsters.add(monster);
            }
        }
    }

    private void moveMonster(){
        for (Monster monster : monsters)
            monster.move();
    }

    private void verifyMonsterCollisions(){
        for (Monster monster : monsters)
           if(monster.getPosition().equals(hero.getPosition())){
               System.out.println("YOU LOSE !!");
               System.exit(0);
           }
    }
}
