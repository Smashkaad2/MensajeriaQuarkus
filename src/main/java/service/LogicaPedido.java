package service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Mensaje;

import io.smallrye.reactive.messaging.annotations.Channel;
import io.smallrye.reactive.messaging.annotations.Emitter;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/mensajes")
public class LogicaPedido {
    @Channel("mensaje-peticion")
    Emitter<Mensaje> mensajePeticionEmitter;

    @POST
    @Path("/enviar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje enviarMensaje(Mensaje mensaje) {

        mensaje.setTimestamp(LocalDateTime.now()
                .format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        mensajePeticionEmitter.send(mensaje);
        System.out.println(("Mensaje enviado: " + mensaje));

        return mensaje;
    }
}