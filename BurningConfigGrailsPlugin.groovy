import pl.burningice.burningconfig.ConfigAccessor
import pl.burningice.burningconfig.ConfigSourceFactory
import pl.burningice.burningconfig.FileConfigSource
import pl.burningice.burningconfig.features.JobLastRunAspect
import pl.burningice.burningconfig.formatters.FormatterRepository

class BurningConfigGrailsPlugin {

    def version = "1.0"

    def grailsVersion = "2.3 > *"

    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

    def title = "Burning Config Plugin"

    def author = "Paweł Gdula"

    def authorEmail = "pawel.gdula@burningice.pl"

    def documentation = "http://grails.org/plugin/burning-config"

    def doWithWebDescriptor = { xml -> }

    def doWithSpring = {

        formatterRepository(FormatterRepository)

        configSourceFactory(ConfigSourceFactory) {
            dbConfigSource = ref('dbConfigService')
            fileConfigSource = { FileConfigSource source ->
                grailsApplication = ref('grailsApplication')
            }
        }

        configAccessor(ConfigAccessor) {
            configSourceFactory = ref('configSourceFactory')
            formatterRepository = ref('formatterRepository')
        }

        lastRunAspect(JobLastRunAspect) {
            configAccessor = ref('configAccessor')
            dbConfigService = ref('dbConfigService')
        }
    }

    def doWithDynamicMethods = { ctx -> }

    def doWithApplicationContext = { ctx -> }

    def onChange = { event -> }

    def onConfigChange = { event -> }

    def onShutdown = { event -> }
}
