package de.predic8.workshop.checkout.event;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ShopListener {
	private final Map<String, BigDecimal> prices;

	@KafkaListener(id = "stock-listener",
			topicPartitions =
					{ @TopicPartition(topic = "shop",
							partitionOffsets = @PartitionOffset(partition = "0", initialOffset = "0"))})
	public void listen(Operation operation) throws IOException {

		if (!operation.getType().equals("article")) {
			return;
		}

		if (!operation.getAction().equals("create")) {
			return;
		}

		prices.put(operation.getObject().get("uuid").asText(), operation.getObject().get("price").decimalValue());
	}
}