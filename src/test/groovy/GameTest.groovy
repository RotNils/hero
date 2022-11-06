import com.googlecode.lanterna.input.KeyStroke
import com.googlecode.lanterna.input.KeyType
import com.googlecode.lanterna.screen.TerminalScreen
import spock.lang.Specification

class GameTest extends Specification{

    /*
    def "Game draw test"(){
        given:
        def screen = Mock(TerminalScreen.class)
        Game game = new Game (20,20)
        when:
        game.draw()
        then:
        1 * screen.clear()
        1 * game.arena.draw(screen.newTextGraphics())
        1 * screen.refresh()
    }
     */

    def"process Key test with q"(){
        given:
        KeyStroke key = KeyStroke.fromString("q")
        Game game = new Game(20,20)
        when:
        game.processKey(key)
        then:
        game.Running == false

    }

    def"process Key test with down"(){
        given:
        KeyStroke key = new KeyStroke(KeyType.ArrowDown)
        Game game = new Game(20,20)
        when:
        game.processKey(key)
        then:
        game.Running == true

    }

    def"process Key test with EOF"(){
        given:
        KeyStroke key = new KeyStroke(KeyType.EOF)
        Game game = new Game(20,20)
        when:
        game.processKey(key)
        then:
        game.Running == false
    }

    /*
    def "Game run test"(){
        given:
        Game game = new Game(20,20)
        KeyStroke key = Mock(KeyStroke.class)
        when:
        game.run()
        then:
        1 * game.draw();
        1 * game.processKey(key);
    }
    */

}
