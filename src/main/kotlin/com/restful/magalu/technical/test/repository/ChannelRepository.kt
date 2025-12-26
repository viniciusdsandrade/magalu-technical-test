package com.restful.magalu.technical.test.repository

import com.restful.magalu.technical.test.entity.Channel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChannelRepository : JpaRepository<Channel, Long>