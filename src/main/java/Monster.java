import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import java.util.Random;

public class Monster extends Element{

    public Monster(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(TextGraphics screen) {
        screen.setForegroundColor(TextColor.Factory.fromString("#7CFC00"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public void move(){
        Random random = new Random();
        Position newPosition;
        newPosition = new Position(this.position.x + random.nextInt(3) - 1, this.position.y + random.nextInt(3) - 1);
        while(newPosition.x > 8 || newPosition.x < 1 || newPosition.y > 8 || newPosition.y < 1)
            newPosition = new Position(this.position.x + random.nextInt(3) - 1, this.position.y + random.nextInt(3) - 1);
        setPosition(newPosition);
    }
}
