package com.example.framework.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@Configuration
@EnableMongoRepositories
@ComponentScan(basePackages = ["com.example.framework.adapter.mongo"])
class MongoConfig {
}