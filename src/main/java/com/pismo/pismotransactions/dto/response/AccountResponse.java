package com.pismo.pismotransactions.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse extends GenericJackson2JsonRedisSerializer implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long documentNumber;

    private BigDecimal credit;

    private List<TransactionResponse> transactions;
}
