package com.shashir.gadgetappgraphqlkotlinmongodb.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "Gadget")
data class Gadget(

    @Id
    val gadgetId: String? = null,
    var gadgetName: String? = null,
    var gadgetCategory: String? = null,
    var gadgetAvailability: Boolean? = true,
    var gadgetPrice: Double? = null
)