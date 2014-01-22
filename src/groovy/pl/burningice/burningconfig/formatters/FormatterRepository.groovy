package pl.burningice.burningconfig.formatters

class FormatterRepository {

    private static final Map<Class<?>, Formatter<?>> REPOSITORY = [
        (Date): new DateFormatter(),
        (String): new StringFormatter()
    ]

    public <T> Formatter<T> get(Class<T> target) {
        Formatter<T> formatter = REPOSITORY[target]

        if (!formatter) {
            throw new IllegalArgumentException("No formatter for type ${target}")
        }

        return formatter
    }
}
