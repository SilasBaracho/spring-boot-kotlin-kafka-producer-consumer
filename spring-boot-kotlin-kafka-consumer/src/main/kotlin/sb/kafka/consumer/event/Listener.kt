package sb.kafka.consumer.event

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Slf4j
@Component
class Listener {

    private val logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["\${spring.kafka.topics.topic-name}"], groupId = "group-1")
    fun listen(message: String){
        logger.info("Thread: {}", Thread.currentThread().id);
        logger.info("Received: {}", message);
    }
}