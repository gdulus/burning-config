package pl.burningice.burningconfig

class BurningConfig {

    String key

    String value

    static constraints = {
        key(nullable: false, blank: false, unique: true)
        value(nullable: true)
    }
}
