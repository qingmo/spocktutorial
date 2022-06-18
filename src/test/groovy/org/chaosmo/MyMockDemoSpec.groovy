package org.chaosmo

import spock.lang.Specification

class MyMockDemoSpec extends Specification {

    def "test stub"() {
        given:
        def service = Stub(StubDemoService)
        service.hello(_) >> "a" >> "b"
        when:
        def ret1 = service.hello("1")
        def ret2 = service.hello("2")
        then:
        ret1 == "a"
        ret2 == "b"
    }

    def "test mock"() {
        given:
        def service = Mock(StubDemoService)
        service.hello(_) >> "a"
        when:
        service.hello("1")
        service.hello("2")
        then:
        2*service.hello(_)
    }
}
