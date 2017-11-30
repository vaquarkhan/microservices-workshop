package de.predi8.workshop.catalogue.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.predi8.workshop.catalogue.dto.Article;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopListener {
    private final ObjectMapper mapper;
    private final Map<String, Article> articles;

    @KafkaListener(id = "stock-listener",
            topicPartitions =
                    {@TopicPartition(topic = "shop",
                            partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))})
    public void listen(Operation operation) throws IOException {

        if (!operation.getType().equals("article"))
            return;

        Article article = mapper.convertValue(operation.getObject(), Article.class);

        switch (operation.getAction()) {
            case "update":
            case "create":
                articles.put(article.getUuid(), article);
                return;
            case "delete":
                articles.remove(article.getUuid());
        }


    }
}