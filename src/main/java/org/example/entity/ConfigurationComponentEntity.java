package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.common.ComponentTypeConstants;
import org.hibernate.envers.AuditJoinTable;
import org.hibernate.envers.Audited;

import java.util.LinkedList;
import java.util.List;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = ComponentTypeConstants.CONFIG)
@Audited
public class ConfigurationComponentEntity extends AbstractComponentEntity {
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "config_component_id", referencedColumnName = "id", nullable = false)
    @AuditJoinTable(name = "config_component_config_component_has_component_aud")
    private List<ConfigurationComponentHasComponentEntity> childComponents = new LinkedList<>();
}
