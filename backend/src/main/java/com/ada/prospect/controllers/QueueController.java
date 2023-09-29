package com.ada.prospect.controllers;

import com.ada.prospect.models.BaseProspect;
import com.ada.prospect.services.QueueService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Queue;


@RestController
@RequestMapping("/queue/")
@Tag(name = "Fila")
@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso."),
        @ApiResponse(responseCode = "400", description = "Requisição inválida."),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor."),
})
@CrossOrigin(origins = "http://localhost:3000")
public class QueueController {

    private final QueueService queueService;

    public QueueController(QueueService queueService) {
        this.queueService = queueService;
    }

    @GetMapping(value = "getcurrentqueue", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retorna os Prospects atualmente na fila.")
    @Validated
    public Queue<BaseProspect> getQueuedProspects() {
        return queueService.getQueue();
    }

    @GetMapping(value = "getnextinqueue", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Consome o próximo elemento da fila.")
    @Validated
    public BaseProspect getNextInQueue() {
        return queueService.getNextQueueItem();
    }

}
