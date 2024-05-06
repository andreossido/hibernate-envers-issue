package org.example.entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.common.ComponentTypeConstants;
import org.hibernate.envers.Audited;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue(value = ComponentTypeConstants.PRODUCT)
@Audited
public class ProductComponentEntity extends AbstractComponentEntity {
}
