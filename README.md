#burning-config

## job last run monitoring 

This feature allows to monitor last execution of the job. To use it: 

* provide job execute metod with one paremeter type def
* annotate it with @JobLastRun

Example

```groovy
import groovy.util.logging.Slf4j
import pl.burningice.burningconfig.features.JobLastRun

@Slf4j
class MyTestJob {

    static triggers = {
        simple startDelay: 10000, repeatInterval: 10000
    }

    
    @JobLastRun
    def execute(lastRun) {
        // do stuff, lastRun is Date type
    }
}
```


