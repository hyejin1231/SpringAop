package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0;

    @Test
    void external() {
        log.info("target={}", callServiceV0.getClass()); // 프록시가 올라갈 것이다!
        callServiceV0.external();
    }

    @Test
    void internal() {
        callServiceV0.internal(); // 얘는 외부에서 호출하기 때문에 당연~히 프록시 거치기 때문에 AOP 적용된다.
    }

}