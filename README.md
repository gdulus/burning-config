#burning-config

##Features

###Job last run monitoring 

This feature allows to monitor last execution of the job. 

#####To use it: 
* provide job execute metod with one paremeter type def (name is not important)
* annotate it with @JobLastRun

####Additional info:
* job execution time will be stored in DB and passed as a parameter to it next run
* at the first time when there is no DB entry null will be returned 
* date will be stored in DB under key FULL_JOB_NAME.lastRun, e.g.: org.example.MyTestJob.lastRun

####Example:

```groovy
package org.example

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




