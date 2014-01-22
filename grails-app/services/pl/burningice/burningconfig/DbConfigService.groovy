package pl.burningice.burningconfig

import grails.transaction.Transactional
import org.apache.commons.lang.Validate
import pl.burningice.burningconfig.formatters.FormatterRepository

class DbConfigService implements ConfigSource {

    FormatterRepository formatterRepository

    @Transactional(readOnly = true)
    public String get(final String key) {
        BurningConfig.findByKey(key)?.value
    }

    @Transactional
    public boolean save(final String key, final Date value) {
        save(key, formatterRepository.get(Date).toString(value))
    }

    @Transactional
    public boolean save(final String key, final String value) {
        Validate.notEmpty(key, 'Config key cant be null or empty')
        BurningConfig config = BurningConfig.findByKey(key) ?: new BurningConfig(key: key)
        config.value = value
        config.save() != null
    }
}
