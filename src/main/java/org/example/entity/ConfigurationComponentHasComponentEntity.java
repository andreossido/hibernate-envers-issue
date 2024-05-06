package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Where;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(name = "config_component_has_component")
@Where(clause = "deleted = 0")
@Data
public class ConfigurationComponentHasComponentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "component_id")
    private ProductComponentEntity component;

    @Column(name="deleted")
    private Long deleted = 0L;
}