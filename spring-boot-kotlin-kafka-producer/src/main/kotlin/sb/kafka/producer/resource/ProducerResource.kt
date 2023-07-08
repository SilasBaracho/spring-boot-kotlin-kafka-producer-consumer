package sb.kafka.producer.resource

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import sb.kafka.producer.useCase.producer.sendMessage.ProducerSendMessageInput
import sb.kafka.producer.useCase.producer.sendMessage.ProducerSendMessageUseCase

@RestController
@RequestMapping("v1/producer")
class ProducerResource(
    val producerSendMessageUseCase: ProducerSendMessageUseCase
) {

    @PostMapping
    fun sendMessage(@RequestBody input: ProducerSendMessageInput): ResponseEntity<String> {
        producerSendMessageUseCase.invoke(input)
        return ResponseEntity.ok("Message sent")
    }

}