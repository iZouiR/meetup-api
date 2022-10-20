package self.izouir.meetupapi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import self.izouir.meetupapi.controller.advice.ControllerExceptionHandlingAdvice;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandlingAdvice.class);

    @Before("execution(* self.izouir.meetupapi.controller.advice.*.*(..))")
    public void beforeAllExceptionHandlingAdvices(final JoinPoint joinPoint) {
        final RuntimeException e = (RuntimeException) joinPoint.getArgs()[0];
        logger.error(e.getMessage());
    }
}
