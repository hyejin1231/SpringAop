package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

// 프록시 내부 호출 문제 - 대안 2 지연 조회하기
@Slf4j
@Component
public class CallServiceV2 {

    // 근데 ApplicationContext 는 너무 거대하다. 기능이 너무 많다!!
//    private final ApplicationContext applicationContext;

    // ObjectProvider의 getObject() 를 호출하면 내부에서는 스프링 컨테이너를 통해 해당 빈을 찾아서 반 환한다.
    private final ObjectProvider<CallServiceV2> callServiceProvider;

    public CallServiceV2(ObjectProvider<CallServiceV2> callServiceProvider) {
        this.callServiceProvider = callServiceProvider;
    }


    public void external() {
        log.info("call external");
//        CallServiceV2 callServiceV2 = applicationContext.getBean(CallServiceV2.class);
        CallServiceV2 callServiceV2 = callServiceProvider.getObject();
        callServiceV2.internal();
    }

    public void internal() {
        log.info("call internal");
    }


}
