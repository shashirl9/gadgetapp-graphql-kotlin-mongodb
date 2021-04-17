package com.shashir.gadgetappgraphqlkotlinmongodb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories(basePackages = ["com.shashir.gadgetappgraphqlkotlinmongodb.repository"])
class GadgetappGraphqlKotlinMongodbApplication

fun main(args: Array<String>) {
	runApplication<GadgetappGraphqlKotlinMongodbApplication>(*args)
}
