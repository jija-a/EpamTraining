package by.alex.task06.service.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public final class FigureRegistrar {

    /**
     * @see Logger
     */
    private static final Logger LOGGER =
            LoggerFactory.getLogger(FigureRegistrar.class);

    /**
     * Class instance (Singleton pattern).
     */
    public static final FigureRegistrar REGISTRAR = new FigureRegistrar();

    /**
     * Map of characteristics. {@link Long} as key,
     * and {@link Characteristic} as value.
     */
    private final Map<Long, Characteristic> characteristic;

    /**
     * Private class constructor.
     */
    private FigureRegistrar() {
        characteristic = new HashMap<>();
    }

    /**
     * Method to put characteristic in characteristics map.
     *
     * @param id                  - {@link Long} id of value
     * @param characteristicValue - {@link Characteristic}
     *                            characteristic of figure
     */
    public void putCharacteristic(final long id,
                                  final Characteristic characteristicValue) {

        LOGGER.info("Characteristic, id - {} was added to warehouse", id);
        this.characteristic.put(id, characteristicValue);
    }

    /**
     * Method to get {@link Characteristic} from characteristics map.
     *
     * @param id - id of characteristic
     * @return {@link Characteristic}
     */
    public Characteristic getCharacteristic(final long id) {
        return characteristic.get(id);
    }

    /**
     * Method to remove characteristic from map.
     *
     * @param id - id of characteristic
     */
    public void removeCharacteristic(final long id) {
        LOGGER.info("Characteristic - {} was removed from warehouse", id);
        this.characteristic.remove(id);
    }

    /**
     * Mehod to check if map contains characteristic
     * with certain id.
     *
     * @param id - id of characteristic
     * @return true - if contains, else - false
     */
    public boolean contains(final long id) {
        return characteristic.containsKey(id);
    }
}
