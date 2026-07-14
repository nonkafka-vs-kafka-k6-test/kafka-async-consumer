//package com.example.kafkawriteprojectconsumer.v1;
//
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import tools.jackson.databind.ObjectMapper;
//
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class OrdersSendMessage {
//    private String id;
//    private Long userId;
//    private Integer amount;
//    private String createdAt; // JSON 직렬화 및 전송 편의를 위해 String으로 정의
//    private String status;
//
//    // Json 값을 EmailSendMessage로 역직렬화하는 메서드
//    public static OrdersSendMessage fromJson(String json) {
//        try {
//            ObjectMapper objectMapper = new ObjectMapper();
//            return objectMapper.readValue(json, OrdersSendMessage.class);
//        } catch (Exception e) {
//            throw new RuntimeException("JSON 파싱 실패");
//        }
//    }
//
//    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    public static Orders fromOrdersSendMessage(OrdersSendMessage ordersSendMessage) {
//        LocalDateTime parsedDateTime = LocalDateTime.parse(ordersSendMessage.getCreatedAt(), FORMATTER);
//
//        return Orders.builder()
//                .id(ordersSendMessage.getId())
//                .userId(ordersSendMessage.getUserId())
//                .amount(ordersSendMessage.getAmount())
//                .status(ordersSendMessage.getStatus())
//                .createdAt(parsedDateTime)
//                .build();
//    }
//}
