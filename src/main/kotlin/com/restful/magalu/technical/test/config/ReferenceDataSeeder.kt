package com.restful.magalu.technical.test.config

import com.restful.magalu.technical.test.entity.Channel
import com.restful.magalu.technical.test.entity.Status
import com.restful.magalu.technical.test.repository.ChannelRepository
import com.restful.magalu.technical.test.repository.StatusRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional

@Component
class ReferenceDataSeeder(
    private val channelRepository: ChannelRepository,
    private val statusRepository: StatusRepository
) : CommandLineRunner {

    @Transactional
    override fun run(vararg args: String) {

        Channel.Values.entries
            .map(Channel.Values::toChannel)
            .forEach(channelRepository::save)

        Status.Values.entries
            .map(Status.Values::toStatus)
            .forEach(statusRepository::save)
    }
}