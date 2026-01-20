package org.templateproject.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PreUpdate
import java.time.OffsetDateTime
import java.time.OffsetDateTime.now

@MappedSuperclass
abstract class BaseDates {

    @Column(nullable = false, updatable = false)
    var inserted: OffsetDateTime = now()
        protected set

    @Column(nullable = false)
    var updated: OffsetDateTime = now()
        protected set

    @PreUpdate
    protected fun onUpdate() {
        updated = now()
    }
}
