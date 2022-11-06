import spock.lang.Specification

class PositionTest extends Specification{

    def"Position equals Position"(){
        given:
        Position p1 = new Position(5,5)
        Position p2 = new Position(5,5)
        def test = false
        when:
        test = p1.equals(p2)
        then:
        test
    }
}
