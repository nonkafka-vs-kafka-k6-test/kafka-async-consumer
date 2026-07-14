package com.example.kafkaasyncconsumer;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderNotificationService {

    private final OrdersRepository ordersRepository;

    @Transactional
    public void updateNotificationStatus(String orderId) {
        ordersRepository.findById(orderId).ifPresent(order -> {
            order.setNotificationSent(true);
            order.setNotificationSentAt(LocalDateTime.now());
        });
    }
}
