package com.restful.magalu.technical.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import lombok.Getter
import lombok.Setter


@Getter
@Setter
@Entity
@Table(
    name = "tb_status",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_status_description",
            columnNames = ["description"]
        )
    ]
)
open class Status protected constructor() {

    @Id
    var id: Long? = null

    lateinit var description: String

    constructor(description: String) : this() {
        this.description = description
    }

    enum class Values(val id: Long, val description: String) {
        PENDING(1L, "pending"),
        SUCCESS(2L, "success"),
        ERROR(3L, "error"),
        CANCELED(4L, "canceled");

        fun toStatus(): Status =
            Status(description).also { it.id = id }
    }
}