package com.shashir.gadgetappgraphqlkotlinmongodb.resolver

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.shashir.gadgetappgraphqlkotlinmongodb.model.Gadget
import com.shashir.gadgetappgraphqlkotlinmongodb.model.GadgetInput
import com.shashir.gadgetappgraphqlkotlinmongodb.model.GadgetResponse
import com.shashir.gadgetappgraphqlkotlinmongodb.repository.GadgetRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class GadgetMutationResolver : GraphQLMutationResolver {

    @Autowired
    var gadgetRepository: GadgetRepository? = null

    fun persistGadgetData(persistGadget: GadgetInput): GadgetResponse {
        val saveGadgetData = Gadget()
        saveGadgetData.gadgetName = persistGadget.gadgetName
        saveGadgetData.gadgetCategory = persistGadget.gadgetCategory
        saveGadgetData.gadgetPrice = persistGadget.gadgetPrice
        saveGadgetData.gadgetAvailability = persistGadget.gadgetAvailability
        val persistedGadget: Gadget? = gadgetRepository?.save(saveGadgetData)
        return mapGadgetToGadgetResponse(persistedGadget)
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