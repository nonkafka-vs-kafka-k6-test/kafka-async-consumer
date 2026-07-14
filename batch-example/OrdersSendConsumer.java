//package com.example.kafkawriteprojectconsumer.v1;
//
//
//import jakarta.persistence.EntityManager;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//@Slf4j
//@RequiredArgsConstructor
//public class OrdersSendConsumer {
//
//    private final OrdersRepository ordersRepository;
//    private final EntityManager entityManager;
//
//    @KafkaListener(
//            topics = "db.write",
//            groupId = "orders-bulk-group",
//            concurrency = "5" // 파티션 5개와 1:1 매핑되어 병렬 처리
//    )
//    @Transactional
//    public void consumeBatch(List<String> messages) {
//        List<Orders> ordersList = new ArrayList<>();
//
//        for (String message : messages) {
//            try {
//                OrdersSendMessage dto = OrdersSendMessage.fromJson(message);
//                Orders entity = OrdersSendMessage.fromOrdersSendMessage(dto);
//                ordersList.add(entity);
//            } catch (Exception e) {
//                log.error("❌ 파싱 실패한 원본 데이터 구조 확인용 로그: [{}]", message);
//                log.error("메시지 파싱 및 변환 중 에러 발생 (건너뜀): {}", e.getMessage());
//            }
//        }
//
//        // 변환된 엔티티 묶음을 일괄 insert 후 영속성 컨텍스트 초기화
//        if (!ordersList.isEmpty()) {
//            ordersRepository.saveAll(ordersList);
//
//            entityManager.flush();
//            entityManager.clear();
//
//            log.info("🎯 [Thread: {}] {}건 배치 insert 완료!",
//                    Thread.currentThread().getName(), ordersList.size());
//        }
//    }
//}
