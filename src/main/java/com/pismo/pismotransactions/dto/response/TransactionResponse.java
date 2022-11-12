package com.pismo.pismotransactions.dto.response;

import com.pismo.pismotransactions.model.OperationType;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends GenericJackson2JsonRedisSerializer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long accountId;

    private OperationType operationType;

    private BigDecimal amount;

    private String eventDate;
}
