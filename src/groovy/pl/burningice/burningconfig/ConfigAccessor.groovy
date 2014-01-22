package pl.burningice.burningconfig

import pl.burningice.burningconfig.formatters.FormatterRepository

class ConfigAccessor {

    ConfigSourceFactory configSourceFactory

    FormatterRepository formatterRepository

    public Date getAsDate(final String key, final ConfigSourceType sourceType) {
        getAs(key, sourceType, Date)
    }

    public String getAsString(final String key, final ConfigSourceType sourceType) {
        getAs(key, sourceType, String)
    }

    private <T> T getAs(final String key, final ConfigSourceType sourceType, Class<T> type) {
        String value = configSourceFactory.produce(sourceType).get(key)

        if (!value) {
            return null
        }

        return formatterRepository.get(type).fromString(value)
    }

}
