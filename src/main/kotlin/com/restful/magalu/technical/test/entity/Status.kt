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
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "description", nullable = false, length = 60)
    lateinit var description: String

    constructor(description: String) : this() {
        this.description = description
    }
}