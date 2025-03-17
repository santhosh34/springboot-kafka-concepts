package com.sanovus.mega.concepts.util;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class ByteArrayCustomDeserializer {

    public Object getObject(byte[] data) {

        try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(bis)) {
            return ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize object", e);
        }
    }
}
