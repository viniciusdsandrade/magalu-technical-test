package com.restful.magalu.technical.test.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_channel")
class Notification {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null
    var dateTime: LocalDateTime? = null
    var destination : String? = null
    var message: String? = null

    @ManyToOne
    var channelId: Channel? = null

    @ManyToOne
    var statusId: Status? = null
}