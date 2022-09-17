package com.example.security.aspect;

import com.example.security.entity.FireWordLogger;
import com.example.security.entity.User;
import com.example.security.repository.UserRepository;
import com.example.security.service.FireWordLoggerService;
import com.example.security.service.FireWordService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
public class WaaOffensiveWords {

    @Autowired
    FireWordService fireWordService;

    @Autowired
    FireWordLoggerService fireWordLoggerService;

    @Autowired
    UserRepository userRepository;

    @Pointcut("@annotation(com.example.security.aspect.Loggable)")
    public void dummyMethod(){

    }

    @Around("dummyMethod()")
    public Object offensiveWordsAspect(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("atleast");
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        boolean offensive = fireWordService.checkOffensiveWord("stupid");
            System.out.println(Arrays.stream(joinPoint.getArgs()).findFirst().get().toString());
        if(offensive){
            UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            User user = userRepository.findByEmail(userDetails.getUsername()).get();
            List<FireWordLogger> blacklist = fireWordLoggerService.getListOfUser(user.getId()).stream().filter(fireWordLogger -> ChronoUnit.MINUTES.between(LocalDateTime.now(),fireWordLogger.getTime())<30).collect(Collectors.toList());
            if(blacklist.size() >5)
                    throw new RuntimeException();

        }
        Object result = joinPoint.proceed();
        return result;
    }
}
