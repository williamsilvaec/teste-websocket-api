package com.williamsilva.testewebsocketapi.controller;

import com.williamsilva.testewebsocketapi.model.Notificacao;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    private final SimpMessagingTemplate messagingTemplate;

    private Notificacao notificacao = new Notificacao(0);

    public NotificacaoController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @GetMapping
    public String getNotificacao() {
        notificacao.incrementar();
        messagingTemplate.convertAndSend("/topic/notificacao", notificacao);

        return "Notificação enviada!";
    }

    @GetMapping("/count")
    public Integer count() {
        return this.notificacao.getContador();
    }
}
