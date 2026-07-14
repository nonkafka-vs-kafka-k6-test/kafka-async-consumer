package com.example.kafkaasyncconsumer;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class OrderNotificationConsumer {

    private final ObjectMapper objectMapper;
    private final OrderNotificationService orderNotificationService;

    @KafkaListener(
            topics = "order.notification",
            groupId = "order-notification-group",
            concurrency = "5" // 5개의 스레드로 메시지 poll
    )
    public void consume(String message) {
        try {
            OrderNotificationMessage dto = objectMapper.readValue(message, OrderNotificationMessage.class);

            // 알림 발송 시뮬레이션
            Thread.sleep(1000);

            // 주문 테이블의 알림 컬럼 update
            orderNotificationService.updateNotificationStatus(dto.getOrderId());

            log.info("🔔 [Thread: {}] 알림 발송 완료 - orderId: {}",
                    Thread.currentThread().getName(), dto.getOrderId());

        } catch (Exception e) {
            log.error("❌ 알림 처리 중 에러 발생: {}", e.getMessage());
        }
    }
}
