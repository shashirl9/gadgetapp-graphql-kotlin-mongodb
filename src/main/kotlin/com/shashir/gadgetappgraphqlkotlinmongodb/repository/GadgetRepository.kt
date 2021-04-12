package com.shashir.gadgetappgraphqlkotlinmongodb.repository

import com.shashir.gadgetappgraphqlkotlinmongodb.model.Gadget
import org.springframework.data.mongodb.repository.MongoRepository

import org.springframework.stereotype.Repository

@Repository
interface GadgetRepository : MongoRepository<Gadget?, String?> { }