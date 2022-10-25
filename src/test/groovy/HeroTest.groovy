import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class HeroTest extends Specification{
    def "Hero down"() {
        given:
        Hero hero = new Hero(5, 5)
        when:
        Position position = hero.moveDown()
        then:
        position.getY() == 6
    }

    def "Hero up"() {
        given:
        Hero hero = new Hero(5, 5)
        when:
        Position position = hero.moveUp()
        then:
        position.getY() == 4
    }

    def "Hero left"() {
        given:
        Hero hero = new Hero(5, 5)
        when:
        Position position = hero.moveLeft()
        then:
        position.getX() == 4
    }

    def "Hero right"() {
        given:
        Hero hero = new Hero(5, 5)
        when:
        Position position = hero.moveRight()
        then:
        position.getX() == 6
    }

    def "Hero draw"(){
        given:
        def screen = Mock(TextGraphics.class)
        Hero hero = new Hero (5,5)
        when:
        hero.draw(screen)
        then:
        1 * screen.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        1 * screen.enableModifiers(SGR.BOLD);
        1 * screen.putString(new TerminalPosition(hero.getX(), hero.getY()), "X");
    }


}
