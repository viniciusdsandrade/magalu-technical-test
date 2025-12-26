package com.restful.magalu.technical.test.entity

import jakarta.persistence.Basic
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "tb_notification")
open class Notification protected constructor() {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    var id: Long? = null

    lateinit var dateTime: LocalDateTime

    lateinit var destination: String

    @Lob
    @Basic
    lateinit var message: String

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(
        name = "channel_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_notification_channel")
    )
    lateinit var channel: Channel

    @ManyToOne(fetch = LAZY, optional = false)
    @JoinColumn(
        name = "status_id",
        nullable = false,
        foreignKey = ForeignKey(name = "fk_notification_status")
    )
    lateinit var status: Status

    constructor(
        dateTime: LocalDateTime,
        destination: String,
        message: String,
        channel: Channel,
        status: Status
    ) : this() {
        this.dateTime = dateTime
        this.destination = destination
        this.message = message
        this.channel = channel
        this.status = status
    }
}