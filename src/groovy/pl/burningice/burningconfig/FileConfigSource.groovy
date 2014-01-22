package pl.burningice.burningconfig

import org.codehaus.groovy.grails.commons.GrailsApplication

public class FileConfigSource implements ConfigSource {

    GrailsApplication grailsApplication

    public String get(final String key) {
        grailsApplication.flatConfig.get(key)
    }
}