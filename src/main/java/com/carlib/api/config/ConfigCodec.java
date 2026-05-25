package com.carlib.api.config;
public interface ConfigCodec { ConfigFormat format(); <T> String encode(T value, Class<T> type); <T> T decode(String encoded, Class<T> type); }
