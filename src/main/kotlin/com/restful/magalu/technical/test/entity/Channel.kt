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
    name = "tb_channel",
    uniqueConstraints = [
        UniqueConstraint(
            name = "uk_channel_description",
            columnNames = ["description"]
        )
    ]
)
open class Channel protected constructor() {

    @Id
    var id: Long? = null

    lateinit var description: String

    constructor(description: String) : this() {
        this.description = description
    }

    enum class Values(val id: Long, val description: String) {
        EMAIL(1L, "email"),
        SMS(2L, "sms"),
        PUSH(3L, "push"),
        WHATSAPP(4L, "whatsapp");

        fun toChannel(): Channel =
            Channel(description).also { it.id = id }
    }
}