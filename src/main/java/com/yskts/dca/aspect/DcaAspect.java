package com.yskts.dca.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author nwong
 */
@Aspect
public class DcaAspect {
    @DcaNoMatch
    @Around("pointcutAny()")
    public Object aroundAnyCall(ProceedingJoinPoint pjp) throws Throwable { 
        
        System.out.println("Method called: " + pjp.getSignature().toLongString());
        
        return pjp.proceed();
    }
    
    @Pointcut("call(* *.*(..)) && !within(com.yskts.dca.aspect..*)")
    public void pointcutAny() {}
}
