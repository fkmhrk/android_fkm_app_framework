package jp.fkmsoft.android.framework;

/**
 * UI holder
 */
public interface UIHolder<T extends UI> {
    /**
     * Gets an instance of {@link T}. Caller must check whether returned instance is null or not.
     * @return an instance of {@link T} or null
     */
    T get();
}
