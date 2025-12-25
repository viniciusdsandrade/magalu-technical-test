package com.restful.magalu.technical.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "tb_channel")
class Channel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
    var description: String? = null
}