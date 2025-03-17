package com.sanovus.mega.concepts.config;

import com.sanovus.mega.concepts.dto.OrderPrice;
import com.sanovus.mega.concepts.dto.TradePrice;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.converter.ByteArrayJsonMessageConverter;
import org.springframework.kafka.support.converter.JsonMessageConverter;
import org.springframework.kafka.support.converter.RecordMessageConverter;
import org.springframework.kafka.support.mapping.DefaultJackson2JavaTypeMapper;
import org.springframework.kafka.support.mapping.Jackson2JavaTypeMapper;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
        return props;
    }
    @Bean
    public Map<String, Object> consumerJsonConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(JsonDeserializer.TYPE_MAPPINGS,
                "orderPrice:com.sanovus.mega.concepts.dto.OrderPrice, " +
                "tradePrice:com.sanovus.mega.concepts.dto.TradePrice");
        props.put(JsonDeserializer.TRUSTED_PACKAGES,"*");
        return props;
    }


    @Bean
    public ConsumerFactory<Object, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    @Bean
    KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Object, Object>>
    kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Object, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(3);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

//    @Bean
//    public RecordMessageConverter converter() {
//        JsonMessageConverter converter = new   JsonMessageConverter();
//        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
//        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
//        typeMapper.addTrustedPackages("com.sanovus.mega.concepts.dto");
//        Map<String, Class<?>> mappings = new HashMap<>();
//        mappings.put("orderPrice", OrderPrice.class);
//        mappings.put("tradePrice", TradePrice.class);
//        typeMapper.setIdClassMapping(mappings);
//        converter.setTypeMapper(typeMapper);
//        return converter;
//    }

    @Bean
    public RecordMessageConverter byteArrayJsonMessageConverter() {
        ByteArrayJsonMessageConverter byteArrayJsonMessageConverter = new ByteArrayJsonMessageConverter();
        DefaultJackson2JavaTypeMapper typeMapper = new DefaultJackson2JavaTypeMapper();
        typeMapper.setTypePrecedence(Jackson2JavaTypeMapper.TypePrecedence.TYPE_ID);
        typeMapper.addTrustedPackages("com.sanovus.mega.concepts.dto");

        Map<String, Class<?>> mappings = new HashMap<>();
        mappings.put("orderPrice", OrderPrice.class);
        mappings.put("tradePrice", TradePrice.class);
        typeMapper.setIdClassMapping(mappings);
        byteArrayJsonMessageConverter.setTypeMapper(typeMapper);
        return byteArrayJsonMessageConverter;
    }

}
