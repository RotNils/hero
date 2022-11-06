import com.googlecode.lanterna.SGR
import com.googlecode.lanterna.TerminalPosition
import com.googlecode.lanterna.TextColor
import com.googlecode.lanterna.graphics.TextGraphics
import spock.lang.Specification

class CoinTest extends Specification{

    def"coin draw test"(){
        given:
        def screen = Mock(TextGraphics.class)
        Coin coin = new Coin(5,5)
        when:
        coin.draw(screen)
        then:
        1 * screen.setForegroundColor(TextColor.Factory.fromString("#FFD700"))
        1 * screen.enableModifiers(SGR.BOLD)
        1 * screen.putString(new TerminalPosition(coin.position.getX(), coin.position.getY()), "o")
    }
}
