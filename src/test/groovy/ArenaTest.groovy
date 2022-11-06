import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TerminalSize
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.input.KeyStroke;
import spock.lang.Specification

class ArenaTest extends Specification{

    def "Arena draw"() {
        given:
        Arena arena = new Arena(20,20)
        def screen = Mock(TextGraphics.class)
        def hero = Mock(Hero.class)
        def wall = Mock(Wall.class)
        def monster = Mock(Monster.class)
        def coin = Mock(Coin.class)
        when:
        arena.draw(screen)
        then:
        1 * screen.setBackgroundColor(TextColor.Factory.fromString("#336699"))
        1 * screen.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(20, 20), ' ')
        _ * hero.draw(screen)
        _ * wall.draw(screen)
        _ * monster.draw(screen)
        _ * coin.draw(screen)
    }

    def "Arena process key down"(){
        given:
        Arena arena = new Arena(20,20)
        KeyStroke key = new KeyStroke(KeyType.ArrowDown)
        def hero = Mock(Hero.class)
        when:
        arena.processKey(key)
        then:
        arena.moveHero(hero.moveDown())

    }
}
