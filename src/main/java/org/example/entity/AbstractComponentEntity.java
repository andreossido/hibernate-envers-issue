package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

@Data
@Entity
@Table(name = "component")
@Where(clause="deleted=0")
@Audited
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class AbstractComponentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer internalId;

    @Column(name="deleted")
    private Long deleted = 0L;
}
