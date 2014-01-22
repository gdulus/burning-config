package pl.burningice.burningconfig.features

import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import pl.burningice.burningconfig.ConfigAccessor
import pl.burningice.burningconfig.ConfigSourceType
import pl.burningice.burningconfig.DbConfigService

@Aspect
public class JobLastRunAspect {

    ConfigAccessor configAccessor

    DbConfigService dbConfigService

    @Around("@annotation(pl.burningice.burningconfig.features.JobLastRun)")
    Object execute(final ProceedingJoinPoint joinPoint) {
        Date currentRun = new Date()
        String key = joinPoint.getTarget().getClass().getCanonicalName() + ".lastRun"
        Date lastRun = configAccessor.getAsDate(key, ConfigSourceType.DB)
        Object result = joinPoint.proceed([lastRun] as Object[])
        dbConfigService.save(key, currentRun)
        return result
    }

}