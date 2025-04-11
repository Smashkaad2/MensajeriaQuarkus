package service;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import io.vertx.core.json.JsonObject;
import model.Mensaje;



@ApplicationScoped
public class EnvioCorreos {
    @Inject Mailer mailer;
    @Incoming("mensaje")
    public Mensaje creacion(JsonObject json) throws InterruptedException {
        //Thread.sleep(1000);
        Mensaje mensaje = new Mensaje();
        mensaje.setContenido(json.getString("contenido"));
        mensaje.setTimestamp(json.getString("timestamp"));
        System.out.println("Mensaje recibido en el envio: " + mensaje);
        sendEmail(mensaje);
        System.out.println("Correo enviado con exito");
        return mensaje;
    }
                                                                                                                   
    public void sendEmail(Mensaje correoMensaje) {
        String destinatario = "quarkuscorreo@quarkus.io";
        String asunto = "Prueba de correo desde Quarkus";
        String cuerpo = "Hola, este es un mensaje de prueba desde Quarkus. \n" +
                "Contenido: " + correoMensaje.getContenido() + "\n" +
                "Timestamp: " + correoMensaje.getTimestamp();
        mailer.send(
                Mail.withText(destinatario,asunto,cuerpo)
        );
    }
}
