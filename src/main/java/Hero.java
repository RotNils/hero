import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    int x;
    int y;

    public Hero(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveUp(){
        this.y = this.y - 1;
    }

    public void moveDown(){
        this.y = this.y + 1;
    }

    public void moveLeft(){
        this.x = this.x - 1;
    }

    public void moveRight(){
        this.x = this.x + 1;
    }
    public void draw(Screen screen){
        screen.setCharacter(x, y, TextCharacter.fromCharacter('X')[0]);
    }

}
