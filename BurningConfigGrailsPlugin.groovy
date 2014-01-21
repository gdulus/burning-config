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

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { ctx ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }

    def onShutdown = { event ->
    }
}
