package com.restful.magalu.technical.test.repository

import com.restful.magalu.technical.test.entity.Status
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface StatusRepository : JpaRepository<Status, Long>