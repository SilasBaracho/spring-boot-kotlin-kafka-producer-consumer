package sb.kafka.producer.useCase.producer.sendMessage

import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class ProducerSendMessageUseCase(
    val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Value("\${spring.kafka.topics.topic-name}")
    private lateinit var topicName: String

    operator fun invoke(input: ProducerSendMessageInput) {
        kafkaTemplate.send(topicName, input.message)
    }
}