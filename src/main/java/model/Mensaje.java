package model;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection
public class Mensaje {
    private String contenido;
    private String timestamp;

   
    public Mensaje() {
    }

    public Mensaje(String contenido, String timestamp) {
        this.contenido = contenido;
        this.timestamp = timestamp;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Mensaje{" +
                "contenido='" + contenido + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}