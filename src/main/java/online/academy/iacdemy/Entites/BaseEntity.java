package online.academy.iacdemy.Entites;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;

@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @CreationTimestamp
    @Column(name = "created_at", updatable = false, nullable = true)
    private Instant createAt;
    @Column(name = "updated_at", updatable = false, nullable = true)
    private Instant updateAt;

   

}
