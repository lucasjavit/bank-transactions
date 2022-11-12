package com.pismo.pismotransactions.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse extends GenericJackson2JsonRedisSerializer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private List<AccountResponse> accounts;
}
