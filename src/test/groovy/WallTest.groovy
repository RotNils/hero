import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.screen.Screen
import spock.lang.Specification

class WallTest extends Specification{

    def"Wall draw test"(){
        given:
        def screen = Mock(TextGraphics.class)
        Wall wall = new Wall(5,5)
        when:
        wall.draw(screen)
        then:
        1 * screen.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        1 * screen.enableModifiers(SGR.BOLD);
        1 * screen.putString(new TerminalPosition(wall.position.getX(), wall.position.getY()), "+");
    }
}
