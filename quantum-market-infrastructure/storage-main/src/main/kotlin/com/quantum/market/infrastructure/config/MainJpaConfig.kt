package com.quantum.market.infrastructure.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = ["com.quantum.market.infrastructure"])
@EnableJpaRepositories(basePackages = ["com.quantum.market.infrastructure"])
internal class MainJpaConfig
