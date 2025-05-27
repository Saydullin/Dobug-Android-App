package com.saydullin.domain.util.resource

object Status {

    object Success: StatusResource {
        override val code = 1
        override val description = ""
    }

    object Unknown: StatusResource {
        override val code = 2
        override val description = ""
    }

    object PostServerError: StatusResource {
        override val code = 3
        override val description = ""
    }

}