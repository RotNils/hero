import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class MonsterTest extends Specification{
    def "Monster draw"(){
        given:
        def screen = Mock(TextGraphics.class)
        Monster monster = new Monster (5,5)
        when:
        monster.draw(screen)
        then:
        1 * screen.setForegroundColor(TextColor.Factory.fromString("#7CFC00"))
        1 * screen.enableModifiers(SGR.BOLD)
        1 * screen.putString(new TerminalPosition(monster.getX(), monster.getY()), "M")
    }
}
