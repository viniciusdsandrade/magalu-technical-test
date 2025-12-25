package com.restful.magalu.technical.test.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint

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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "description", nullable = false, length = 120)
    lateinit var description: String

    constructor(description: String) : this() {
        this.description = description
    }
}