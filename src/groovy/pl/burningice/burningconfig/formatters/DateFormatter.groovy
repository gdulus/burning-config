package pl.burningice.burningconfig.formatters

public class DateFormatter implements Formatter<Date> {

    private static final String FORMAT = "dd-MM-yyyy HH:mm:ss"

    Date fromString(final String source) {
        if (!source) {
            return null
        }

        return Date.parse(FORMAT, source)
    }

    String toString(final Date source) {
        if (!source) {
            return null
        }

        source.format(FORMAT)
    }
}
