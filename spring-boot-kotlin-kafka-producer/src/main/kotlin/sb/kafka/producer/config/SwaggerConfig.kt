package sb.kafka.producer.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    @Value("\${spring.kafka.topics.topic-name}")
    private lateinit var topic: String

    @Bean
    fun springShopOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Producer API")
                    .description("Microservice responsible for producing messages for the topic: $topic")
            )
    }
}