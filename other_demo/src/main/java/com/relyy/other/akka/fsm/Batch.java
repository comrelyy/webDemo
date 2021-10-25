package com.relyy.other.akka.fsm;

import java.util.List;
import java.util.Objects;

public final class Batch {
    private final List<Object> list;

    public Batch(List<Object> list) {
        this.list = list;
    }

    public List<Object> getList() {
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(list, batch.list);
    }

    @Override
    public int hashCode() {
        return Objects.hash(list);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Batch{list=");
        list.stream().forEachOrdered(
                e -> {
                    builder.append(e);
                    builder.append(",");
                });
        int len = builder.length();
        builder.replace(len,len,"}");
        return builder.toString();
    }
}
