package com.example

import javax.persistence.*

@MappedSuperclass
abstract class AbstractDemoJpaEntity<T> {
    abstract val id: T

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractDemoJpaEntity<*>) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

@Embeddable
data class DemoClassId(val value: Long) : java.io.Serializable

@Entity
data class DemoClass(
    @EmbeddedId
    @AttributeOverride(name = "value", column = Column(name = "id"))
    override val id: DemoClassId,

) : AbstractDemoJpaEntity<DemoClassId>() {
    override fun equals(other: Any?) = super.equals(other)
    override fun hashCode() = super.hashCode()
}
