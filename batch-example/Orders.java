//package com.example.kafkawriteprojectconsumer.v1;
//
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.data.domain.Persistable;
//
//import java.time.LocalDateTime;
//
//@Data
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class Orders implements Persistable<String> {
//    @Id
//    @Column(name = "order_id", length = 50)
//    private String id;
//
//    @Column(name = "user_id", nullable = false)
//    private Long userId;
//
//    @Column(name = "amount", nullable = false)
//    private Integer amount;
//
//    @Column(name = "created_at", nullable = false)
//    private LocalDateTime createdAt;
//
//    @Column(name = "status", nullable = false, length = 20)
//    private String status;
//
//    @Override
//    public boolean isNew() {
//        return true;
//    }
//}
