package com.restful.magalu.technical.test.repository

import com.restful.magalu.technical.test.entity.Notification
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NotificationRepository  : JpaRepository<Notification, Long>