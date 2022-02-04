package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV0 {

    public void external() {
        log.info("call external");
        internal(); // this.internal()인데 this 생략 가능, this는 자기 자신 인스턴스
    }

    public void internal() {
        log.info("call internal");
    }
}
