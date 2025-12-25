package com.restful.magalu.technical.test.entity

import jakarta.persistence.Basic
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType.LAZY
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType.IDENTITY
import jakarta.persistence.Id
import jakarta.persistence.Index
import jakarta.persistence.JoinColumn
import jakarta.persistence.Lob
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(
    name = "tb_notification",
    indexes = [
        Index(name = "ix_notification_channel_id", columnList = "channel_id"),
        Index(name = "ix_notification_status_id", columnList = "status_id"),
        Index(name = "ix_notification_date_time", columnList = "date_time"),
        Index(name = "ix_notification_destination", columnList = "destination")
    ]
)
open class Notification protected constructor() {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    var id: Long? = null

    @Column(name = "date_time", nullable = false)
    lateinit var dateTime: LocalDateTime

    @Column(name = "destination", nullable = false, length = 255)
    lateinit var destination: String

    @Lob
    @Basic
    @Column(name = "message", nullable = false)
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