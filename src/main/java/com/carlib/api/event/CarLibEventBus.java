package com.carlib.api.event;
import java.util.List;import java.util.concurrent.CopyOnWriteArrayList;import java.util.function.Consumer;
public final class CarLibEventBus<T> { private final List<Consumer<T>> listeners = new CopyOnWriteArrayList<>(); public void register(Consumer<T> l){listeners.add(l);} public void unregister(Consumer<T> l){listeners.remove(l);} public void post(T e){for(Consumer<T> l:listeners){l.accept(e);}} }
