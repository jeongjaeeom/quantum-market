package com.quantum.market.catalogs

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@Configuration
@ComponentScan(basePackageClasses = [OrderModuleConfiguration::class])
class OrderModuleConfiguration {
}