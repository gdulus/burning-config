package pl.burningice.burningconfig

public class ConfigSourceFactory {

    ConfigSource dbConfigSource

    ConfigSource fileConfigSource

    public ConfigSource produce(final ConfigSourceType sourceType) {
        switch (sourceType) {
            case ConfigSourceType.DB:
                return dbConfigSource
            case ConfigSourceType.FILE:
                return fileConfigSource
            default:
                throw new IllegalArgumentException("Unknown config source type ${sourceType}")
        }
    }
}