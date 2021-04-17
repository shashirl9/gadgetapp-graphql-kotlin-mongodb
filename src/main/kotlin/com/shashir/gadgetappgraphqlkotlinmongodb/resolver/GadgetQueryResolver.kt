package com.shashir.gadgetappgraphqlkotlinmongodb.resolver

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.shashir.gadgetappgraphqlkotlinmongodb.model.Gadget
import com.shashir.gadgetappgraphqlkotlinmongodb.model.GadgetResponse
import com.shashir.gadgetappgraphqlkotlinmongodb.repository.GadgetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

@Component
class GadgetQueryResolver : GraphQLQueryResolver {

    @Autowired
    var gadgetRepository: GadgetRepository? = null

    fun application() : String {
        return "Welcome to GraphQL with Kotlin and MongoDB...!"
    }

    fun getGadget(gadgetId: String): GadgetResponse? {
        var gadget = gadgetRepository?.findById(gadgetId)?.get()
        return mapGadgetToGadgetResponse(gadget)
    }

    fun getAllGadgets(): List<GadgetResponse?>? {
        return getGadgetResponse(gadgetRepository?.findAll() as List<Gadget>)
    }

    private fun getGadgetResponse(gadgetList: List<Gadget>): List<GadgetResponse>? {
        val gadgetResponseList: MutableList<GadgetResponse> = ArrayList()
        gadgetList.stream().forEach { gadget: Gadget ->
            gadgetResponseList.add(mapGadgetToGadgetResponse(gadget))
        }
        return gadgetResponseList
    }

    private fun mapGadgetToGadgetResponse (gadget : Gadget?) : GadgetResponse {
        var gadgetResponse = GadgetResponse()
        gadgetResponse.gadgetId = gadget?.gadgetId
        gadgetResponse.gadgetName = gadget?.gadgetName
        gadgetResponse.gadgetCategory = gadget?.gadgetCategory
        gadgetResponse.gadgetPrice = gadget?.gadgetPrice
        gadgetResponse.gadgetAvailability = gadget?.gadgetAvailability
        return gadgetResponse;
    }
}