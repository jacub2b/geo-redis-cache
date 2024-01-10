package jack.awsome.data;

import com.fasterxml.jackson.databind.util.JSONPObject;

import java.io.Serializable;

public record GeoObject(Type type, String content, Double number) implements Serializable {};
