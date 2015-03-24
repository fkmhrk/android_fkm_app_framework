package jp.fkmsoft.android.framework.model;

/**
 * Base DTO interface
 * @param <T> from
 * @param <U> to
 */
public interface DTO<T, U> {
    /**
     * Encodes U into T
     * @param input Input object
     * @return encoded object
     */
    T encode(U input);

    /**
     * Decodes T into U
     * @param input Input object
     * @return decoded object
     */
    U decode(T input);
}
