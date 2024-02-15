package Spring_AOP.PackageName;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserActionAspect {
    private static final Logger logger = LoggerFactory.getLogger(UserActionAspect.class);

    @Pointcut("@annotation(YourPackageName.TrackUserAction)")
    public void trackUserAction() {
    }

    @AfterReturning(pointcut = "trackUserAction()", returning = "result")
    public void logUserAction(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        // строка извлекает имя метода, который был вызван, из объекта joinPoint.

        String className = joinPoint.getTarget().getClass().getSimpleName();
        // здесь извлекается имя класса, к которому относится вызванный метод

        Object[] args = joinPoint.getArgs();
        // эта строка извлекает аргументы, переданные вызванному методу.

        String userDetails = "Пользователь: [получить подробную информацию о пользователе можно здесь]";
        // Получение информации о пользователе

        logger.info("User {} performed action: {}.{} with arguments: {} and result: {}", userDetails, className, methodName, args, result);
    }
}
